package fr.afpa.dev.pompey.Menu;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        this.setTitle("Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(800, 600);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.white);
    }
}
