package fr.afpa.dev.pompey.Interface;

import fr.afpa.dev.pompey.Modele.Abos;
import fr.afpa.dev.pompey.Modele.Livre;
import fr.afpa.dev.pompey.Modele.datamodele.AbosTableModel;
import fr.afpa.dev.pompey.Modele.datamodele.LivreTableModel;
import fr.afpa.dev.pompey.exception.SaisieException;
import fr.afpa.dev.pompey.Utilitaires.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;

import static fr.afpa.dev.pompey.Modele.Biblio.getAbos;
import static fr.afpa.dev.pompey.Modele.Biblio.getLivres;

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
    private JLabel UtilisateurLabelPret;
    private JLabel titreLabelPret;
    private JPanel boutonPanelPret;
    private JLabel auteurLabelLivre;
    private JLabel titreLabelLivre;
    private JPanel boutonPanelLivre;
    private JPanel boutonPanelAbos;
    private JTable listAbos;
    private JScrollPane scroll;
    private JTextField quantiteFieldLivre;
    private JLabel quantiteLabelLivre;
    private JTable listLivres;
    private JScrollPane scrollLivre;
    private JTable tablePret;
    private JComboBox utilisateurComboBoxPret;
    private JComboBox livreComboBoxPret;
    private JLabel livreLabelPret;

    public BiblioApp() {
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        setLocationRelativeTo(null);

        AbosTableModel model1 = new AbosTableModel(getAbos());
        this.listAbos.setModel(model1);

        LivreTableModel model2 = new LivreTableModel(getLivres());
        this.listLivres.setModel(model2);

        Util // A FAIRE
        String[] strings = new String[]{getAbos().toString()} ;
        utilisateurComboBoxPret = new JComboBox(strings);




        // ----Les Actions Listeners----

        // Abonnés

        validerButtonAbos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    enregistrerAbos();
                } catch (Exception ex) {
                    new RuntimeException(ex);
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
                    new RuntimeException(ex);
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
        utilisateurComboBoxPret.addContainerListener(new ContainerAdapter() {
        });
    }

    //Les Fonctions

    //Abonnees

    private void enregistrerAbos() throws SaisieException {
        String Nom = nomFieldAbos.getText();
        String Prenom = prenomFieldAbos.getText();
        String Email = emailFieldAbos.getText();

        // Verifie si les champs de saisies ne sont pas vides
        if (Nom.isEmpty() || Prenom.isEmpty() || Email.isEmpty()) {
            Input.AffMsgWindows("Les champs manquants doit être saisis");
            throw new SaisieException();
        }

        // Verifie si l'email est unique
        for(Abos UniqueEmail : getAbos()){
            if(UniqueEmail.getEmailAbos().equalsIgnoreCase(Email)){
                emailFieldAbos.setText("");
                Input.AffMsgWindows("L'email existe déjà, il doit être unique");
                throw new SaisieException();
            }
        }

        // Ajoute les saisies dans le constructeur avec les verification de regex
        Abos abos = new Abos(
                Input.verifNomPrenom(Nom, "nom"),
                Input.verifNomPrenom(Prenom, "prenom"),
                Input.getEmail(Email),
                Input.CreateDateNow());

        // Ajoute une ligne dans la JTable listAbos
        getAbos().add(abos);
        // System.out.println(abos);

        // Refresh l'interface
        listAbos.revalidate();
        listAbos.repaint();

        Input.AffMsgWindows("Abonné enregistré avec succès.");

        nomFieldAbos.setText("");
        prenomFieldAbos.setText("");
        emailFieldAbos.setText("");
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
        String quantite = quantiteFieldLivre.getText();

        if (titre.isEmpty() || auteur.isEmpty()) {
            Input.AffMsgWindows("Les champs manquants n'ont pas été saisis");
            throw new SaisieException();
        }

        // Ajoute les saisies dans le constructeur avec les verification de regex
        Livre livres = new Livre(
                Input.getString(titre),
                Input.verifNomPrenom(auteur, "prenom et nom de l'auteur"),
                Input.getInt(quantite));

        getLivres().add(livres);

        listLivres.revalidate();
        listLivres.repaint();

        Input.AffMsgWindows("Le Livre a été ajouté");

        titreFieldLivre.setText("");
        auteurFieldLivre.setText("");
        quantiteFieldLivre.setText("");
    }

    private void annulerSaisieLivre(){
        titreFieldLivre.setText("");
        auteurFieldLivre.setText("");
        quantiteFieldLivre.setText("");
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


}