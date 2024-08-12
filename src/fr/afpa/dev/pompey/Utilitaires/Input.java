package fr.afpa.dev.pompey.Utilitaires;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Input {
    //Gestion de scan
    private static Scanner scan = new Scanner(System.in);

    private Input(){
    }

    //Liste de REGEX
    private static final String REGEXDATE = "^-\\d{2}-\\d{2}-\\d{4}$";
    private static final String REGEXSTRING = "^[A-Za-zÀ-ÖØ-öø-ÿ' -]+$";
    private static final String REGEXINT = "^[0-9]+$";
    private static final String REGEXEMAIL = "^(?=.{1,64}@)[\\p{L}0-9\\+_-]+(\\.[\\p{L}0-9\\+_-]+)*@"
            + "[^-][\\p{L}0-9\\+-]+(\\.[\\p{L}0-9\\+-]+)*(\\.[\\p{L}]{2,})$";

    //Affichage d'un message et lecture saisie de type de caractère
    public static String getString(String message){
        System.out.print(message);
        return scan.nextLine();
    }

    //Affichage d'un message et lecture saisie de email
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
    public static String CreateDateNow(){
        LocalDate dateActuelle = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = formatter.format(dateActuelle);
        return date;
    }

    //Création de date de fin
    public static String EndDate(){
        LocalDate dateActuelle = LocalDate.now();
        LocalDate dateFin = dateActuelle.plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = formatter.format(dateFin);
        return date;
    }

    //Affichage de message
    public static void affichage(String message){
        System.out.println(message);
    }
}
