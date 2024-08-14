package fr.afpa.dev.pompey.Modele;

import fr.afpa.dev.pompey.exception.SaisieException;

public class Livre {
    private String titre;
    private String auteur;
    private int quantite = 1;

    // Constructeur sans paramètre
    public Livre(){

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

    public void setAuteur(String auteur) {
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
