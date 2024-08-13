package fr.afpa.dev.pompey.Modele;

import fr.afpa.dev.pompey.Utilitaires.Input;

import java.time.LocalDate;

public class Abos {
    private String nomAbos;
    private String prenomAbos;
    private String emailAbos;
    private LocalDate dateAbos;

    public Abos() {

    }

    public Abos(String nom, String prenom, String email, LocalDate dateAbos){
        this.nomAbos = nom;
        this.prenomAbos = prenom;
        this.emailAbos = email;
        this.dateAbos = dateAbos;
    }

    public Abos(String nom, String prenom) {
        this.nomAbos = nom;
        this.prenomAbos = prenom;
    }

    public String getNomAbos() {
        return nomAbos;
    }

    public void setNomAbos(String nom){
        if ( nom == null || !nom.isEmpty() ) {
            this.nomAbos = nom;
        }

    }

    public String getPrenomAbos() {
        return prenomAbos;
    }

    public void setPrenomAbos(String prenom){
        if ( prenom == null || !prenom.isEmpty() ) {
            this.prenomAbos = prenom;
        }

    }

    public String getEmailAbos() {
        return emailAbos;
    }

    public void setEmailAbos(String email) {
        if (email != null && !email.isEmpty()) {
            this.emailAbos = email;
        }else{
            Input.affichage("Veuillez re-saisir votre email");
        }
    }

    public LocalDate getDateInscriptionAbos() {
        return dateAbos;
    }

    public void setDateInscriptionAbos(LocalDate dateAbos) {
        this.dateAbos = dateAbos;
    }

    @Override
    public String toString() {
        return
                "Le nom de l'abonné : " + getNomAbos() + '\n' +
                "le prenom de l'abonne : " + getPrenomAbos() + '\n' +
                "le email : " + getEmailAbos() + '\n' +
                "La date de l'inscription : " + getDateInscriptionAbos() + '\n';
    }
}
