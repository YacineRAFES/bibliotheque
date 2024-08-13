package fr.afpa.dev.pompey.Menu.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Compte extends JFrame implements ActionListener {
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;

    public Compte(){
        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Création de compte");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
