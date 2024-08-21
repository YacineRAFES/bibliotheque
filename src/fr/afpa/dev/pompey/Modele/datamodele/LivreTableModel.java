package fr.afpa.dev.pompey.Modele.datamodele;

import fr.afpa.dev.pompey.Modele.Livre;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LivreTableModel extends AbstractTableModel {

    private final String[] ENTETE = new String[] {
            "Titre", "Auteur", "Quantite"
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
            default:
                return null;
        }
    }
}
