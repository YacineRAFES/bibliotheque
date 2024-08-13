package fr.afpa.dev.pompey.Modele;

import java.time.LocalDate;

public class Pret{
    private LocalDate dateDebut;
    private LocalDate dateFin;

    // Constructeur sans paramètre
    public Pret(){
    }

    // Constructeur Pret avec dateDebut et dateFin.
    // Biblio
    // Livre : titre et auteur.
    // Abos : Nom et prenom
    public Pret(LocalDate dateDebut, LocalDate dateFin){
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    //Gutter et Setter de DateDebut
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    //Gutter et Setter de DateFin
    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Prêt : " + "\n" +
               "Le prêt du livre : " + "\n" +
               "débute le " + getDateDebut() + '\n' +
               "terminera le " + getDateFin() + '\n';
    }
}