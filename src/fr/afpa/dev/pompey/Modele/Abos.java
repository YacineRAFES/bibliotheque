package fr.afpa.dev.pompey.Modele;

import fr.afpa.dev.pompey.Utilitaires.Input;

public class Abos {
    private String nomAbos;
    private String prenomAbos;
    private String emailAbos;
    private String dateInscriptionAbos;

    public Abos(){

    }

    public Abos(String nom, String prenom, String email, String dateInscription) {
        this.nomAbos = nom;
        this.prenomAbos = prenom;
        this.emailAbos = email;
        this.dateInscriptionAbos = dateInscription;
    }

    public Abos(String nom, String prenom) {
        this.nomAbos = nom;
        this.prenomAbos = prenom;
    }

    public String getNomAbos() {
        return nomAbos;
    }

    public void setNomAbos(String nom) {
        this.nomAbos = nom;
    }

    public String getPrenomAbos() {
        return prenomAbos;
    }

    public void setPrenomAbos(String prenom) {
        if(prenom != null && !prenom.isEmpty()){
            this.prenomAbos = prenom;
        }else{
            Input.affichage("Veuillez re-saisir votre prénom");
        }
    }

    public String getEmailAbos() {
        return emailAbos;
    }

    public void setEmailAbos(String email) {
        this.emailAbos = email;
    }

    public String getDateInscriptionAbos() {
        return dateInscriptionAbos;
    }

    public void setDateInscriptionAbos(String dateInscription) {
        this.dateInscriptionAbos = dateInscription;
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
