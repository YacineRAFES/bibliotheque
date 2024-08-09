package fr.afpa.dev.pompey.Utilitaires;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Input {
    private static final String REGEXDATE = "^-\\d{2}-\\d{2}-\\d{4}$";
    private static final String REGEXSTRING = "^[A-Za-zÀ-ÖØ-öø-ÿ' -]+$";
    private static final String REGEXINT = "^[0-9]+$";


    //Gestion de scan
    private static Scanner scan = new Scanner(System.in);

    public static void affichage(String message){
        System.out.println(message);
    }

    private Input(){

    }

    //Affichage d'un message et lecture saisie de type de caractère
    public static String getString(String message){
        System.out.print(message);
        String saisie = scan.nextLine();
        if(saisie.contains(REGEXDATE)){
            return saisie;
        }else{
            affichage(message);
        }

    }

    //Affichage d'un message et lecture saisie de type Int
    public static String getInt(String message){
        System.out.print(message);
        String saisie = scan.nextLine();
        boolean valid = false;
        while(!valid){
            if(saisie.matches(REGEXINT)){
                valid = true;
            }else{
                affichage("Veuillez re-saisir un entier");
            }
        }
        return saisie;
    }

    //Affichage d'un message et lecture saisie de type date
    public static String date(String message){
        System.out.print(message);
        String pdate = scan.nextLine();
        boolean valid = false;
        while(!valid){
            if(pdate.matches(REGEXDATE)){
                valid = true;
            }else{
                affichage("Veuillez re-saisir la date JJ-MM-AAAA");
                pdate = scan.nextLine();
            }
        }
        return pdate;
    }

    public static String CreateDateNow(){
        LocalDate dateActuelle = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = date(formatter.format(dateActuelle));
        return date;
    }

    public static String EndDate(){
        LocalDate dateActuelle = LocalDate.now();
        LocalDate dateFin = dateActuelle.plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = date(formatter.format(dateFin));
        return date;
    }
}
