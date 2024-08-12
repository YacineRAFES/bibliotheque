package fr.afpa.dev.pompey.Modele;

import fr.afpa.dev.pompey.Utilitaires.Input;

public class Bibliothecaire extends Livre {
    private String biblioNom;
    private String biblioPrenom;
    private int biblioId;

    // Constructeur sans paramètre
    public Bibliothecaire() {

    }

    // Constructeur avec le nom, prénom et id de la Bibliothecaire
    public Bibliothecaire(String nom, String prenom, int id) {
        this.biblioNom = nom;
        this.biblioPrenom = prenom;
        this.biblioId = id;
    }

    // Constructeur avec nom et prénom de la Bibliothecaire. Titre et auteur du livre
    public Bibliothecaire(String nom, String prenom, String titre, String auteur){
        super(titre, auteur);
        this.biblioNom = nom;
        this.biblioPrenom = prenom;
    }

    // Constructeur avec nom et prenom de la Bibliothecaire
    public Bibliothecaire(String nom, String prenom) {
        this.biblioNom = nom;
        this.biblioPrenom = prenom;
    }

    // Gutter et Setter de Nom de la Bibliothecaire
    public String getbiblioNom() {
        return biblioNom;
    }

    public void setbiblioNom(String nom) {
        this.biblioNom = nom;
    }

    // Gutter et Setter de Prenom de la Bibliothecaire
    public String getbiblioPrenom() {
        return biblioPrenom;
    }

    public void setbiblioPrenom(String prenom) {
        this.biblioPrenom = prenom;
    }

    public int getBiblioId() {
        return biblioId;
    }

    public void setBiblioId(int biblioId) {
        this.biblioId = biblioId;
    }

    @Override
    public String toString() {
        return "Bibliothecaire{" +
                "nom='" + getbiblioNom() + '\'' +
                ", prenom='" + getbiblioPrenom() + '\'' +
                ", id=" + biblioId +
                '}';
    }
}
