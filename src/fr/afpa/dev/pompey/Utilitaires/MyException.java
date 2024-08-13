package fr.afpa.dev.pompey.Utilitaires;

public class MyException extends Exception {
    public MyException(){
        Input.affichage("Erreur de saisie");
    }

//    public Exception(String message, Throwable cause){
//        Input.affichage(message);
//    }


//    public Exception(Throwable cause){
//        cause.toString();
//    }


}
