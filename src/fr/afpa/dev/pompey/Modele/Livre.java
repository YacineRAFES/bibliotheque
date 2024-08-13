package fr.afpa.dev.pompey.Modele;

public class Livre {
    private String titre;
    private String auteur;
    private int quantite = 1;

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

    //----------- Gutter et Setter de Titre -----------
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre){
        if ( titre == null || !titre.isEmpty() ) {
            this.titre = titre;
        }

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
