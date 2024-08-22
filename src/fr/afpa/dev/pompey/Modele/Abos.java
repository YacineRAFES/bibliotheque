package fr.afpa.dev.pompey.Modele;

import fr.afpa.dev.pompey.exception.SaisieException;

import java.time.LocalDate;

public class Abos {
    private String nomAbos;
    private String prenomAbos;
    private String emailAbos;
    private LocalDate dateAbos;

    public Abos() {

    }

    public Abos(String nomAbos, String prenomAbos, String emailAbos, LocalDate dateAbos) {
        this.nomAbos = nomAbos;
        this.prenomAbos = prenomAbos;
        this.emailAbos = emailAbos;
        this.dateAbos = dateAbos;
    }

    public String getNomAbos() {
        return nomAbos;
    }

    public void setNomAbos(String nom) throws SaisieException {
        if ( nom == null ) {
            throw new SaisieException("le nom ne doit pas être vide");
        }
        if (nom.isEmpty() ) {
            throw new SaisieException("le nom ne doit pas être vide");
        }
        this.nomAbos = nom;

    }

    public String getPrenomAbos() {
        return prenomAbos;
    }

    public void setPrenomAbos(String prenom) throws SaisieException {
        if ( prenom == null ) {
            throw new SaisieException("le prenom ne doit pas être vide");
        }
        if (prenom.isEmpty() ) {
            throw new SaisieException("le prenom ne doit pas être vide");
        }
        this.prenomAbos = prenom;

    }

    public String getEmailAbos() {
        return emailAbos;
    }

    public void setEmailAbos(String email) throws SaisieException {
        if ( email == null ) {
            throw new SaisieException("l'email ne doit pas être vide");
        }
        if (email.isBlank() ) {
            throw new SaisieException("l'email ne doit pas être vide");
        }
        this.emailAbos = email;
    }

    public LocalDate getDateInscriptionAbos() {
        return dateAbos;
    }

    public void setDateInscriptionAbos(LocalDate dateAbos) throws SaisieException {
        if( dateAbos == null ) {
            throw new SaisieException("La date ne doit pas être vide");
        }
        if (dateAbos.isBefore(LocalDate.now())) {
            throw new SaisieException("La date ne doit pas être antérieure qu'aujourd'hui");
        }
        if (dateAbos.isAfter(LocalDate.now())) {
            throw new SaisieException("La date d'inscription ne doit pas être supérieur qu'aujourd'hui");
        }
        this.dateAbos = dateAbos;
    }

    @Override
    public String toString() {
        return this.getNomAbos() + " " + this.getPrenomAbos();

               // "Le nom de l'abonné : " + getNomAbos() + '\n' +
              //  "le prenom de l'abonne : " + getPrenomAbos() + '\n' +
              //  "le email : " + getEmailAbos() + '\n' +
             //   "La date de l'inscription : " + getDateInscriptionAbos() + '\n';
    }
}
