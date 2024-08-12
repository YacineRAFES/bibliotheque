package fr.afpa.dev.pompey.Biblio;

import fr.afpa.dev.pompey.Modele.Abos;
import fr.afpa.dev.pompey.Modele.Livre;
import fr.afpa.dev.pompey.Modele.Pret;
import fr.afpa.dev.pompey.Utilitaires.Input;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BiblioLivre {
    public static void main(String[] args) {

        BiblioLivre Livre = new BiblioLivre();
        Livre.start();
    }
    public void start() {

        //Saisie un nouveau abonné
        Abos abos = new Abos();
        Livre Livre = new Livre();
        Pret pret = new Pret();

        // ------ Saisie un nouvel abonné ------
        // Entrer un nom
        abos.setNomAbos(Input.getString("Entrer votre nom : "));
        //Entrer un prénom
        abos.setPrenomAbos(Input.getString("Entrer votre prénom : "));
        //Entrer un email
        abos.setEmailAbos(Input.getEmail("Entrer votre email : "));
        //Créer une date actuelle
        abos.setDateInscriptionAbos(Input.CreateDateNow());

        // ------ Saisir un nouveau livre ------
        Input.affichage("Le livre");
        // Entrer le titre du livre
        Livre.setTitre(Input.getString("Entrer votre titre : "));
        // Entrer l'auteur du livre
        Livre.setAuteur(Input.getString("Entrer l'auteur du livre : "));

        // ------ Saisie un nouveau pret ------
        Input.affichage("Le pret");
        pret.setPrenomAbos(Input.getString("Entrer le prénom de l'abonné : "));
        pret.setNomAbos(Input.getString("Entrer le nom de l'abonné : "));
        // ------ Saisie automatiquement la date d'aujourd'hui et la fin de date ------
        pret.setDateDebut(Input.CreateDateNow());
        pret.setDateFin(Input.EndDate());

        //Affichage
        Input.affichage(abos.toString());
        Input.affichage(Livre.toString());
        Input.affichage(pret.toString());

    }

}