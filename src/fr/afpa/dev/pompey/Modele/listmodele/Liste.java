package fr.afpa.dev.pompey.Modele.listmodele;

import fr.afpa.dev.pompey.Modele.Abos;
import fr.afpa.dev.pompey.Modele.Livre;
import fr.afpa.dev.pompey.Modele.Pret;

import java.util.ArrayList;
import java.util.List;

public class Liste {
    private static List<Abos> abos = new ArrayList<>();
    private static List<Livre> livres = new ArrayList<>();
    private static List<Pret> prets = new ArrayList<>();

    //GETTER ET SETTER
    public static List<Abos> getAbos() {
        return abos;
    }

    public static List<Livre> getLivres() {
        return livres;
    }

    public static List<Pret> getPret() {
        return prets;
    }

    public static void addAbos(Abos abos) {
        getAbos().add(abos);
    }

    public static void removeAbos(Abos abos) {
        getAbos().remove(abos);
    }

    public static void addLivre(Livre livre) {
        getLivres().add(livre);
    }

    public static void removeLivre(Livre livre) {
        getLivres().remove(livre);
    }

    public static void addPret(Pret pret) {

        getPret().add(pret);
    }
    public static void removePret(Pret pret) {
        getPret().remove(pret);
    }
}
