package fr.afpa.dev.pompey.Modele.datamodele;

import fr.afpa.dev.pompey.Modele.Abos;
import fr.afpa.dev.pompey.Modele.Livre;
import fr.afpa.dev.pompey.Utilitaires.Input;
import fr.afpa.dev.pompey.exception.SaisieException;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AbosTableModel extends AbstractTableModel {

    private final String[] ENTETE = new String[] {
            "Nom", "Prénom", "Email", "Date d'inscription", "Action"
    };
    private final List<Abos> abos;

    public AbosTableModel(List<Abos> abos) {
        this.abos = abos;
    }

    @Override
    public String getColumnName(int column) {
        return ENTETE[column];
    }

    @Override
    public int getRowCount() {
        return abos.size();
    }

    @Override
    public int getColumnCount() {
        return ENTETE.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Abos abo = abos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return abo.getNomAbos();
            case 1:
                return abo.getPrenomAbos();
            case 2:
                return abo.getEmailAbos();
            case 3:
                return abo.getDateInscriptionAbos();
            case 4:
                return "Supprimer";
            default:
                return null;
        }
    }
    public boolean isCellEditable(int row, int col)
    {
        return true;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Abos abo = abos.get(rowIndex);
        try{
            if(0 == columnIndex) {
                abo.setNomAbos(Input.verifNomPrenom((String) aValue, "nom"));
            }
            else if(1 == columnIndex) {
                abo.setPrenomAbos(Input.verifNomPrenom((String) aValue, "prénom"));
            }
            else if(2 == columnIndex) {
                abo.setEmailAbos(Input.getEmail((String) aValue));
            }
        }catch (SaisieException e){
            Input.AffMsgWindows("Une erreur est survenu");
        }

    }
}
