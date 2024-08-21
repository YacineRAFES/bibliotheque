package fr.afpa.dev.pompey.Modele;

import fr.afpa.dev.pompey.exception.SaisieException;

import java.util.ArrayList;
import java.util.List;

public class Biblio {

    //attributs d'instance
    private static List<Livre> livres = new ArrayList<>();
    private static List<Abos> abos = new ArrayList<>();

    // GETTER et SETTER
    public static List<Livre> getLivres() {
        return livres;
    }

    public static List<Abos> getAbos() {
        return abos;
    }

    // METHODE STATIC
    public static void addLivre(Livre livre) throws SaisieException {
        if(livre != null) {
            throw new SaisieException("Erreur Système : problème d'enregistrement");
        }
        getLivres().add(livre);
    }

    public static void addAbos(Abos abos) throws SaisieException {
        if(abos != null) {
            throw new SaisieException("Erreur Système : problème d'enregistrement");
        }

        getAbos().add(abos);
    }

    public static void displayAbos(){
        for(Abos abos : getAbos()) {

        }
    }
}
