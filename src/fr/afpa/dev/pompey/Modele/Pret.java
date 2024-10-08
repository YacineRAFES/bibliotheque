package fr.afpa.dev.pompey.Modele;

import fr.afpa.dev.pompey.exception.SaisieException;

import java.time.LocalDate;

public class Pret {
    private Abos abos;
    private Livre livre;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    // Constructeur sans paramètre
    public Pret(){
    }

    public Abos getAbos() {
        return abos;
    }

    public void setAbos(Abos abos) {
        this.abos = abos;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Pret(Abos abos, Livre livre, LocalDate dateDebut, LocalDate dateFin) {
        this.abos=abos;
        this.livre = livre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;

    }
    public Pret(LocalDate dateDebut, LocalDate dateFin){
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    //Gutter et Setter de DateDebut
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) throws SaisieException {
        if (dateDebut.isAfter(LocalDate.now())) {
            throw new SaisieException("La date de fin ne doit pas être supérieure de 7 jours.");
        }
        if (dateDebut.isBefore(LocalDate.now())) {
            throw new SaisieException("la date de fin ne doit pas être inférieur de 7 jours.");
        }
        this.dateDebut = dateDebut;
    }

    //Gutter et Setter de DateFin
    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) throws SaisieException {
        if (dateFin.isAfter(LocalDate.now().plusDays(7))) {
            throw new SaisieException("La date de fin ne doit pas être supérieure de 7 jours.");
        }
        if (dateFin.isBefore(LocalDate.now().plusDays(7))) {
            throw new SaisieException("la date de fin ne doit pas être inférieur de 7 jours.");
        }
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
