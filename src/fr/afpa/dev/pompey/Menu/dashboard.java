package fr.afpa.dev.pompey.Menu;

import javax.swing.*;
import java.awt.*;

public class dashboard extends JFrame {  // Class name should start with an uppercase letter
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;

    public dashboard() {  // Constructor name should match the class name
        setTitle("DashBoard");

        // Initialize tabbed panes
        tabbedPane1 = new JTabbedPane();
        tabbedPane2 = new JTabbedPane();
        tabbedPane3 = new JTabbedPane();

        // Add tabbed panes to the main tabbed pane
        tabbedPane1.addTab("Tab 1", tabbedPane2);  // Example usage
        tabbedPane1.addTab("Tab 2", tabbedPane3);  // Example usage

        setContentPane(tabbedPane1);  // Set the content pane to tabbedPane1
        setMaximumSize(new Dimension(500, 429));
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  // Make sure the frame is visible
    }

    public static void main(String[] args) {
        // Instantiate the dashboard, which will call the constructor
        dashboard dashboard = new dashboard();
    }
}
