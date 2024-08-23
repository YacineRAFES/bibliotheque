package fr.afpa.dev.pompey.Utilitaires;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Fonctionnalite de recherche dans une table
public class filterTable extends javax.swing.JFrame {
    private JTextField barRecherche;
    private TableRowSorter<TableModel> rowSorter;
    private TableModel tableModel;
    private JTable NomDeLaTable;

    public filterTable(JTextField barRecherche, TableModel tableModel, JTable NomDeLaTable) {

        this.rowSorter = new TableRowSorter<>(tableModel);
        NomDeLaTable.setRowSorter(rowSorter);
        this.barRecherche = barRecherche;

        this.barRecherche.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = barRecherche.getText();
                if (text.trim().isEmpty()) {
                    rowSorter.setRowFilter(null);
                } else {
                    RowFilter<Object, Object> rf = RowFilter.regexFilter("(?i)" + text);
                    rowSorter.setRowFilter(rf);
                }
            }
        });
    }

}
