package fr.afpa.dev.pompey.Modele.datamodele;

import fr.afpa.dev.pompey.Modele.Livre;
import fr.afpa.dev.pompey.exception.SaisieException;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LivreTableModel extends AbstractTableModel {

    private final String[] ENTETE = new String[] {
            "Titre", "Auteur", "Quantite", "Action"
    };

    private final List<Livre> livre;

    public LivreTableModel(List<Livre> livre) {
        this.livre = livre;
    }

    @Override
    public String getColumnName(int column) {
        return ENTETE[column];
    }

    @Override
    public int getRowCount() {
        return livre.size();
    }

    @Override
    public int getColumnCount() {
        return ENTETE.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Livre livres = livre.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return livres.getTitre();
            case 1:
                return livres.getAuteur();
            case 2:
                return livres.getQuantite();
            case 3:
                return "Supprimer";
            default:
                return null;
        }
    }
    public boolean isCellEditable(int row, int col)
    {
        return true;
    }
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Livre livres = livre.get(rowIndex);
        if(0 == columnIndex) {
            try {
                livres.setTitre((String) aValue);
            } catch (SaisieException e) {
                throw new RuntimeException(e);
            }
        }
        else if(1 == columnIndex) {
            try {
                livres.setAuteur((String) aValue);
            } catch (SaisieException e) {
                throw new RuntimeException(e);
            }
        }
        else if(2 == columnIndex) {
            livres.setQuantite((Integer) aValue);
        }
    }
}
