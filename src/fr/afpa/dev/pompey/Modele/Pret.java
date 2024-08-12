package fr.afpa.dev.pompey.Modele;

import fr.afpa.dev.pompey.Utilitaires.Input;

import java.time.LocalDate;

public class Pret extends Bibliothecaire{
    private String dateDebut;
    private String dateFin;

    // Constructeur sans paramètre
    public Pret(){
    }

    // Constructeur Pret avec dateDebut et dateFin.
    // Biblio
    // Livre : titre et auteur.
    // Abos : Nom et prenom
    public Pret(String dateDebut, String dateFin, String titre, String auteur, String nom, String prenom){
        super(titre, auteur, nom, prenom);
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Constructeur Pret avec dateDebut et dateFin
    public Pret(String dateDebut, String dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Constructeur Pret avec dateDebut et dateFin avec Super Titre et Auteur
    public Pret(String titre, String auteur, String dateDebut, String dateFin) {
        super(titre, auteur);
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    //Gutter et Setter de DateDebut
    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    //Gutter et Setter de DateFin
    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Pret : " +
                "Le prêt débute le " + getDateDebut() + '\n' +
                "Le prêt terminera le " + getDateFin() + '\n';
    }
}
