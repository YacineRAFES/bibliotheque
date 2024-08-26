package fr.afpa.dev.pompey.Utilitaires;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class refreshTable extends javax.swing.JFrame {
    public refreshTable(JTable tableModel) {
        tableModel.revalidate();
        tableModel.repaint();
        ((AbstractTableModel) tableModel.getModel()).fireTableDataChanged();
    }
}
