package fr.afpa.dev.pompey.Utilitaires;

import java.time.LocalDate;
import java.util.Scanner;

public class Input extends MyException {
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
    public static String verifNomPrenom(String message, String type){
        String saisie;
        do{
            System.out.print(message);
            saisie = scan.nextLine();
            if(!saisie.matches(REGEXNOMPRENOM)){
                affichage("Veuillez re-saisir votre "+ type);
            }
        }while(!saisie.matches(REGEXNOMPRENOM));

        return saisie;
    }

    public static String getString(String message){
        String saisie;
        do{
            System.out.print(message);
            saisie = scan.nextLine();
            if(!saisie.matches(REGEXSTRING)){
                affichage("Veuillez re-saisir");
            }
        }while(!saisie.matches(REGEXSTRING));

        return saisie;
    }

    //Affichage d'un message et lecture saisie d'email
    public static String getEmail(String message){
        String saisie;
        do{
            System.out.print(message);
            saisie = scan.nextLine();
            if(!saisie.matches(REGEXEMAIL)){
                affichage("Veuillez re-saisir votre email par exemple : votrenom@domaine.com");
            }
        }while(!saisie.matches(REGEXEMAIL));

        return saisie;
    }

    //Affichage d'un message et lecture saisie de type Int
    public static String getInt(String message){
        String saisie;
        do{
            System.out.print(message);
            saisie = scan.nextLine();
            if(!saisie.matches(REGEXINT)){
                affichage("Veuillez re-saisir en entier");
            }
        }while(!saisie.matches(REGEXINT));

        return saisie;
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