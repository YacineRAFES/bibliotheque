package fr.afpa.dev.pompey.Biblio;

import fr.afpa.dev.pompey.Modele.Abos;
import fr.afpa.dev.pompey.Modele.Livre;
import fr.afpa.dev.pompey.Modele.Pret;
import fr.afpa.dev.pompey.Utilitaires.Input;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BiblioLivre {
    public static void main(String[] args) {

        BiblioLivre Livre = new BiblioLivre();
        Livre.start();
    }
    public void start() {

        //Saisie un nouvel abonné
        Abos abos = new Abos();
        Livre livre = new Livre();
        Pret pret = new Pret();

        try{
            // ------ Saisie un nouvel abonné ------
            Input.affichage("Saisir votre identifiant : ");
            // Entrer un nom
            abos.setNomAbos(Input.verifNomPrenom("Entrer votre nom : ", "nom"));
            //Entrer un prénom
            abos.setPrenomAbos(Input.verifNomPrenom("Entrer votre prénom : ", "prenom"));
            //Entrer un email
            abos.setEmailAbos(Input.getEmail("Entrer votre email : "));
            //Créer une date actuelle
            abos.setDateInscriptionAbos(Input.CreateDateNow());

            // ------ Saisir un nouveau livre ------
            Input.affichage("Le livre");
            // Entrer le titre du livre
            livre.setTitre(Input.getString("Entrer votre titre : "));
            Input.affichage(livre.getTitre());
            // Entrer l'auteur du livre
            livre.setAuteur(Input.verifNomPrenom("Entrer l'auteur du livre : ", "nom/prenom"));
            Input.affichage(livre.getAuteur());


            // ------ Saisie un nouveau pret ------
            Input.affichage("Le pret");
            // ------ Saisie automatiquement la date d'aujourd'hui et la fin de date ------
            pret.setDateDebut(Input.CreateDateNow());
            pret.setDateFin(Input.EndDate());

            //Affichage
            Input.affichage(abos.toString());
            Input.affichage(livre.toString());
            Input.affichage(pret.toString());
        }catch (Exception e){
            System.out.println("Erreur : " + e.getMessage());
        }


    }

}