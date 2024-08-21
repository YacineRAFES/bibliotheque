package fr.afpa.dev.pompey.Modele.datamodele;

import fr.afpa.dev.pompey.Modele.Pret;
import fr.afpa.dev.pompey.Modele.Abos;
import fr.afpa.dev.pompey.Modele.Livre;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class PretTableModel extends AbstractTableModel {
    private final String[] ENTETE = new String[] {
            "Nom/Prénom", "Email", "Livres", "Début Prêt", "Fin Prêt", "Se termine dans"
    };
    private final List<Pret> pret;
    private final List<Abos> abos;
    private final List<Livre> livres;

    public PretTableModel(List<Pret> pret, List<Abos> abos, List<Livre> livres) {
        this.pret = pret;
        this.abos = abos;
        this.livres = livres;
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
        Livre livres = new Livre();
        Abos abos = new Abos();
        switch (columnIndex) {
            case 0:
                return abos.getNomAbos() + " " + abos.getPrenomAbos();
            case 1:
                return abos.getEmailAbos();
            case 2:
                return abos.getEmailAbos();
            case 3:
                return livres.getTitre() + " " + livres.getAuteur();
            case 4:
                return prets.getDateDebut();
            case 5:
                return prets.getDateFin();
            case 6:
                return ChronoUnit.DAYS.between(LocalDate.now(), prets.getDateFin())+ " jours";
            default:
                return null;
        }
    }

}
