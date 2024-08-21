package fr.afpa.dev.pompey.Interface;

import fr.afpa.dev.pompey.Modele.Abos;
import fr.afpa.dev.pompey.Modele.Biblio;
import fr.afpa.dev.pompey.Modele.datamodele.AbosTableModel;
import fr.afpa.dev.pompey.exception.SaisieException;
import fr.afpa.dev.pompey.Utilitaires.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import static fr.afpa.dev.pompey.Modele.Biblio.getAbos;

public class BiblioApp extends JFrame {
    private JTabbedPane onglets;
    private JPanel accuelPanel;
    private JPanel abonnesPanelAbos;
    private JPanel livresPanel;
    private JPanel pretPanel;
    private JTextField nomFieldAbos;
    private JTextField prenomFieldAbos;
    private JButton annulerButtonAbos;
    private JButton validerButtonAbos;
    private JPanel titrePanelAbos;
    private JPanel contentPane;
    private JTextField emailFieldAbos;
    private JLabel emailLabelAbos;
    private JLabel nomLabelAbos;
    private JLabel prenomLabelAbos;
    private JLabel titreIdentifiantLabelAbos;
    private JPanel listAbonnesPanel;
    private JPanel accueilPanel;
    private JPanel titrePanelLivre;
    private JLabel titreLivreLabel;
    private JButton annulerSaisieLivre;
    private JButton validerButtonLivre;
    private JPanel CreateLivrePanel;
    private JTextField titreFieldLivre;
    private JTextField auteurFieldLivre;
    private JPanel CreateAbonnes;
    private JPanel CreatePretPanel;
    private JTextField UtilisateurFieldPret;
    private JTextField livreFieldPret;
    private JButton validerSaisiePret;
    private JButton annulerSaisiePret;
    private JLabel livreLabelPret;
    private JLabel UtilisateurLabelPret;
    private JLabel titreLabelPret;
    private JPanel boutonPanelPret;
    private JLabel auteurLabelLivre;
    private JLabel titreLabelLivre;
    private JPanel boutonPanelLivre;
    private JPanel boutonPanelAbos;
    private JTable listAbos;
    private JScrollPane scroll;

    public BiblioApp() {
        Abos abos = new Abos();
        JFrame frame = new JFrame();
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        setLocationRelativeTo(null);

        AbosTableModel model = new AbosTableModel(getAbos());
        this.listAbos.setModel(model);

        // ----Les Actions Listeners----

        // Abonnés

        validerButtonAbos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    enregistrerAbos();
                } catch (SaisieException ex) {
                    Input.AffMsgWindows("Problème de saisie, veuillez contacter le développement de logiciel");
                }
            }
        });
        annulerButtonAbos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                annulerSaisieAbos();
            }
        });

        //Livres

        validerButtonLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    enregistrerLivre();
                } catch (SaisieException ex) {
                    Input.AffMsgWindows("Problème de saisie, veuillez contacter le développement de logiciel");
                }
            }
        });
        annulerSaisieLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                annulerSaisieLivre();
            }
        });

        // Pret

        validerSaisiePret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    enregistrerPret();
                } catch (SaisieException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        annulerSaisiePret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                annulerSaisiePret();
            }
        });
    }

    //Les Fonctions

    //Abonnees

    private void enregistrerAbos() throws SaisieException {
        Abos abos = new Abos();
        String Nom = nomFieldAbos.getText();
        String Prenom = prenomFieldAbos.getText();
        String Email = emailFieldAbos.getText();

        // Validation simple des champs (vous pouvez ajouter plus de validation si nécessaire)
        if (Nom.isEmpty() || Prenom.isEmpty() || Email.isEmpty()) {
            Input.AffMsgWindows("Les champs manquants n'ont pas été saisis");
        }
        abos.setNomAbos(Nom);
        abos.setPrenomAbos(Prenom);
        abos.setEmailAbos(Email);
        abos.setDateInscriptionAbos(Input.CreateDateNow());
        System.out.println(abos);
        repaint();
        


    }

    private void annulerSaisieAbos(){
        nomFieldAbos.setText("");
        prenomFieldAbos.setText("");
        emailFieldAbos.setText("");
    }

    // Livres

    private void enregistrerLivre() throws SaisieException {
        String titre = titreFieldLivre.getText();
        String auteur = auteurFieldLivre.getText();

        if (titre.isEmpty() || auteur.isEmpty()) {
            Input.AffMsgWindows("Les champs manquants n'ont pas été saisis");
        }


    }
    private void annulerSaisieLivre(){
        titreFieldLivre.setText("");
        auteurFieldLivre.setText("");
    }

    // Prets

    private void enregistrerPret() throws SaisieException {
        String titre = livreFieldPret.getText();
        String utilisateur = UtilisateurFieldPret.getText();

        if (titre.isEmpty() || utilisateur.isEmpty()) {
            Input.AffMsgWindows("Les champs manquants n'ont pas été saisis");
        }
    }

    private void annulerSaisiePret(){
        livreFieldPret.setText("");
        UtilisateurFieldPret.setText("");
    }

    // Affichage d'une liste

    public static class AbosTableModel extends AbstractTableModel {

        private final String[] ENTETE = new String[] {
                "Nom", "Prénom", "Email", "Date d'inscription"
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
                default:
                    return null;
            }
        }
    }



}