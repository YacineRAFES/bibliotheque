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
        abos.setNomAbos(Input.getString("Entrer votre nom"));
        //Entrer un prénom
        abos.setPrenomAbos(Input.getString("Entrer votre prénom"));
        //Entrer un email
        abos.setEmailAbos(Input.getString("Entrer votre email"));
        //Créer une date actuelle
        abos.setDateInscriptionAbos(String.valueOf(Input.CreateDateNow()));

        // ------ Saisie un nouveau livre ------
        // Entrer le titre du livre
        Livre.setTitre(Input.getString("Entrer votre titre"));
        // Entrer l'auteur du livre
        Livre.setAuteur(Input.getString("Entrer le nom du livre"));

        // ------ Saisie un nouveau pret ------
        Input.affichage("Bibliothécaire");
        pret.setbiblioNom("Nom de bibliothécaire");
        pret.setbiblioPrenom("Nom de bibliothécaire");
        // ------ Saisie automatiquement la date d'aujourd'hui et la fin de date ------
        pret.setDateDebut(Input.CreateDateNow());
        pret.setDateFin(Input.EndDate());
        // ------ Saisie du Livre ------
        Input.affichage("le Livre :");
        pret.setTitre(Input.getString("Entrer le titre du livre"));
        pret.setAuteur(Input.getString("Entrer l'auteur du livre"));
        // ------ Saisie l'abonné ------
        Input.affichage("l'Abonné :");
        pret.setNomAbos("Entrer le nom de l'abonné");
        pret.setPrenomAbos("Entrer le prénom de l'abonné");

        //Affichage
//        System.out.println(Abos);
//        System.out.println(Livre);
//        System.out.println(Pret);

    }

}