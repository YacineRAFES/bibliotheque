package fr.afpa.dev.pompey.Interface;

import fr.afpa.dev.pompey.Modele.Abos;
import fr.afpa.dev.pompey.Modele.Livre;
import fr.afpa.dev.pompey.Modele.Pret;
import fr.afpa.dev.pompey.Modele.datamodele.AbosTableModel;
import fr.afpa.dev.pompey.Modele.datamodele.LivreTableModel;
import fr.afpa.dev.pompey.Modele.datamodele.PretTableModel;
import fr.afpa.dev.pompey.Modele.listmodele.Liste;
import fr.afpa.dev.pompey.exception.SaisieException;
import fr.afpa.dev.pompey.Utilitaires.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JPanel barSearchPanel;
    private JTextField barSearchField;

    public BiblioApp() {
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        setLocationRelativeTo(null);

        AbosTableModel model1 = new AbosTableModel(Liste.getAbos());
        this.listAbos.setModel(model1);

        LivreTableModel model2 = new LivreTableModel(Liste.getLivres());
        this.listLivres.setModel(model2);

        PretTableModel model3 = new PretTableModel(Liste.getPret());
        this.tablePret.setModel(model3);

        DefaultComboBoxModel<Abos> comboBoxModel1 = (DefaultComboBoxModel<Abos>) utilisateurComboBoxPret.getModel();
        DefaultComboBoxModel<Livre> comboBoxModel2 = (DefaultComboBoxModel<Livre>) livreComboBoxPret.getModel();

/*        DefaultComboBoxModel<Abos> comboBoxModel1 = new DefaultComboBoxModel();

        for(Abos abos : Liste.getAbos()){
            comboBoxModel1.addElement(abos);
        }

        livreComboBoxPret.setModel(comboBoxModel1);*/

// ESSAI 1

        /*DefaultComboBoxModel<Livre> comboBoxModel2 = new DefaultComboBoxModel<>();

        for(Livre livres : Liste.getLivres()){
            comboBoxModel2.addElement(livres);
        }*/

// ESSAI 2


//


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
                    new RuntimeException(ex);
                }
            }
        });
        annulerSaisiePret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    annulerSaisiePret();
                }catch(Exception ex){
                    new RuntimeException(ex);
                }
            }
        });

        onglets.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (onglets.getSelectedIndex() == 3) {
                    for (Abos abos : Liste.getAbos()) {
                        comboBoxModel1.addElement(abos);
                    }
                    for (Livre livre : Liste.getLivres()) {
                        comboBoxModel2.addElement(livre);
                    }

                }else{
                    comboBoxModel2.removeAllElements();
                    comboBoxModel1.removeAllElements();
                }
            }
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
        Liste.addAbos(abos);

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

        Liste.addLivre(livres);

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
        Object titre = livreComboBoxPret.getSelectedItem();
        Object utilisateur = utilisateurComboBoxPret.getSelectedItem();

        if (titre.equals("0") || utilisateur.equals("0")) {
            Input.AffMsgWindows("Vous n'aviez pas choisi les informations de l'utilisateur et le livre");
            throw new SaisieException();
        }

        Pret prets = new Pret(
                (Abos) utilisateur,
                (Livre) titre,
                Input.CreateDateNow(),
                Input.EndDate()
        );

        Liste.addPret(prets);

        tablePret.revalidate();
        tablePret.repaint();

        Input.AffMsgWindows("Le Pret a été ajouté");

        utilisateurComboBoxPret.setSelectedIndex(0);
        livreComboBoxPret.setSelectedIndex(0);
    }

    private void annulerSaisiePret(){
        utilisateurComboBoxPret.setSelectedIndex(0);
        livreComboBoxPret.setSelectedIndex(0);

    }

    // Affichage d'une liste


}