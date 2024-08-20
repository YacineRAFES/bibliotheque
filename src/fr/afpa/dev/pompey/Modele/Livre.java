package fr.afpa.dev.pompey.Modele;

import fr.afpa.dev.pompey.exception.SaisieException;

public class Livre {
    private String titre;
    private String auteur;
    private int quantite = 1;

    // Constructeur sans paramètre
    public Livre(){

    }

    public Livre(String titre, String auteur, int quantite) {
        this.titre = titre;
        this.auteur = auteur;
        this.quantite = quantite;
    }

    //----------- Gutter et Setter de Titre -----------
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) throws SaisieException {
        if ( titre == null ) {
            throw new SaisieException("le titre du livre ne doit pas être vide");
        }
        if ( titre.isEmpty() ) {
            throw new SaisieException("le titre du livre ne doit pas être vide");
        }
        this.titre = titre;

    }

    //----------- Gutter et Setter de Auteur -----------
    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) throws SaisieException {
        if ( auteur == null ) {
            throw new SaisieException("le nom de l'auteur ne doit pas être vide");
        }
        if ( auteur.isEmpty() ) {
            throw new SaisieException("le nom de l'auteur ne doit pas être vide");
        }
        this.auteur = auteur;
    }

    //-----------Gutter et Setter de Quantité -----------
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return
                "Le titre du Livre : " + getTitre() + '\n' +
                "L'auteur du Livre : " + getAuteur() + '\n' +
                "La quantite : " + getQuantite() + '\n';
    }
}
