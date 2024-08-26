package fr.afpa.dev.pompey.Modele.datamodele;

import fr.afpa.dev.pompey.Modele.Livre;
import fr.afpa.dev.pompey.Modele.Pret;
import fr.afpa.dev.pompey.exception.SaisieException;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class PretTableModel extends AbstractTableModel {
    JButton button = new JButton("Edit");
    private final String[] ENTETE = new String[] {
            "Nom/Prénom", "Email", "Livres", "Début Prêt", "Fin Prêt", "Se termine dans", "Action"
    };
    private final List<Pret> pret;

    public PretTableModel(List<Pret> pret) {
        this.pret = pret;
    }

    @Override
    public String getColumnName(int column) {
        return ENTETE[column];
    }

    @Override
    public int getRowCount() {
        return pret.size();
    }

    @Override
    public int getColumnCount() {
        return ENTETE.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pret prets = pret.get(rowIndex);
        switch (columnIndex) {
            case 0:// Nom/Prénom
                return prets.getAbos().getNomAbos() + " " + prets.getAbos().getPrenomAbos();
            case 1://Email
                return prets.getAbos().getEmailAbos();
            case 2://Livres
                return prets.getLivre().getAuteur() + " " + prets.getLivre().getTitre();
            case 3://Début Pret
                return prets.getDateDebut();
            case 4://Fin Pret
                return prets.getDateFin();
            case 5://Se termine
                return ChronoUnit.DAYS.between(LocalDate.now(), prets.getDateFin())+ " jours";
            case 6:
                return "Retourné";
            default:
                return null;
        }
    }

    public boolean isCellEditable(int row, int col)
    {
        return true;
    }

}
