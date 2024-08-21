package fr.afpa.dev.pompey.Utilitaires;

import fr.afpa.dev.pompey.exception.SaisieException;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Input extends SaisieException {
    //Gestion de scan
    private static Scanner scan = new Scanner(System.in);

    private Input(){
    }

    //Liste de REGEX
    private static final String REGEXNOMPRENOM = "^([a-zA-Z]+[,.]?[ ]?|[a-zA-Z]+[\\'-]?)+$";
    private static final String REGEXDATE = "^-\\d{2}-\\d{2}-\\d{4}$";
    private static final String REGEXSTRING = "^[a-zA-Z0-9_.-]*$";

    private static final String REGEXINT = "^[0-9]+$";
    private static final String REGEXEMAIL = "^(?=.{1,64}@)[\\p{L}0-9\\+_-]+(\\.[\\p{L}0-9\\+_-]+)*@"
            + "[^-][\\p{L}0-9\\+-]+(\\.[\\p{L}0-9\\+-]+)*(\\.[\\p{L}]{2,})$";

    //Affichage d'un message et lecture saisie de type de caractère
    public static String verifNomPrenom(String saisie, String type) throws SaisieException {
        if(!saisie.matches(REGEXNOMPRENOM)){
            AffMsgWindows("Veuillez re-saisir votre " + type);
            throw new SaisieException();
        }

        return saisie;
    }

    public static String getString(String saisie) throws SaisieException {
        if(!saisie.matches(REGEXSTRING)){
            AffMsgWindows("Veuillez re-saisir en caractère, PAS EN ENTIIIIIIIIIIIIIIIER");
            throw new SaisieException();
        }
        return saisie;
    }

    //Affichage d'un message et lecture saisie d'email
    public static String getEmail(String saisie) throws SaisieException {
        if(!saisie.matches(REGEXEMAIL)){
            AffMsgWindows("Veuillez re-saisir votre email par exemple : votrenom@domaine.com");
            throw new SaisieException();
        }
        return saisie;
    }

    //Affichage d'un message et lecture saisie de type Int
    public static int getInt(String saisie) throws SaisieException {
        if(!saisie.matches(REGEXINT)){
            AffMsgWindows("Veuillez re-saisir en entier");
            throw new SaisieException("La saisie n'est pas un entier");
        }
        return Integer.parseInt(saisie);
    }

    //Affichage une fenetre avec un message
    public static void AffMsgWindows(String message){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, message);
    }

    //Affichage d'un message et lecture saisie de type date

    //Création de date actuelle
    public static LocalDate CreateDateNow(){
        return LocalDate.now();
    }

    //Création de date de fin
    public static LocalDate EndDate(){
        return LocalDate.now().plusDays(7);
    }

    //Affichage de message
    public static void affichage(String message){
        System.out.println(message);
    }
}
