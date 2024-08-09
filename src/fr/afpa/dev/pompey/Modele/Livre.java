package fr.afpa.dev.pompey.Modele;

import fr.afpa.dev.pompey.Utilitaires.Input;

public class Livre extends Abos {
    private String titre;
    private String auteur;
    private int quantite = 0;

    // Constructeur sans paramètre
    public Livre(){

    }

    // Constructeur avec Titre, Auteur et Quantite
    public Livre(String titre, String auteur, int quantite) {
        this.titre = titre;
        this.auteur = auteur;
        this.quantite = quantite;
    }
    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }
    // Constructeur de Livre avec Titre et Auteur
    public Livre(String titre, String auteur, String nom, String prenom){
        super(nom, prenom);
        this.titre = titre;
        this.auteur = auteur;
    }

    // Constructeur de Livre avec Titre, Auteur et Quantité du Livre avec Super Nom et prénom de l'Abos
    public Livre(String nom, String prenom, String titre, String auteur, int quantite) {
        super(nom, prenom);
        this.titre = titre;
        this.auteur = auteur;
        this.quantite = quantite;
    }

    //----------- Gutter et Setter de Titre -----------
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = Input.getString(titre);
    }

    //----------- Gutter et Setter de Auteur -----------
    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = Input.getString(auteur);
    }

    //-----------Gutter et Setter de Quantité -----------
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = Integer.parseInt(Input.getInt(String.valueOf(quantite)));
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", quantite=" + quantite +
                '}';
    }
}
