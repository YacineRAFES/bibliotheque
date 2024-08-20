package fr.afpa.dev.pompey.test;

import fr.afpa.dev.pompey.Modele.Abos;
import fr.afpa.dev.pompey.exception.SaisieException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class AbosTest {
    private Abos abosUnderTest;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        abosUnderTest = new Abos("Nom","prenom", "yacine.rafes@gmail.com", LocalDate.now());
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        abosUnderTest = null;
    }

    @org.junit.jupiter.api.Test
    void getNomAbos() {
    }

    // NOM NULL
    @ParameterizedTest
    @NullSource
    void setNomAbosNull(String nom) {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            abosUnderTest.setNomAbos(nom);
        });
        assertEquals(exception.getMessage(), "le nom ne doit pas être vide");
    }
    // NOM EMPTY
    @ParameterizedTest
    @EmptySource
    void setNomAbosBlank(String nom) {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            abosUnderTest.setNomAbos(nom);
        });
        assertEquals(exception.getMessage(), "le nom ne doit pas être vide");
    }

    @org.junit.jupiter.api.Test
    void getPrenomAbos() {
    }

    // PRENOM NULL
    @ParameterizedTest
    @NullSource
    void setPrenomAbosNull(String prenom) {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            abosUnderTest.setPrenomAbos(prenom);
        });
        assertEquals(exception.getMessage(), "le prenom ne doit pas être vide");
    }

    // PRENOM EMPTY
    @ParameterizedTest
    @EmptySource
    void setPrenomAbosEmpty(String prenom) {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            abosUnderTest.setPrenomAbos(prenom);
        });
        assertEquals(exception.getMessage(), "le prenom ne doit pas être vide");
    }

    @org.junit.jupiter.api.Test
    void getEmailAbos() {
    }

    @ParameterizedTest
    @NullSource
    void setEmailAbosNull(String email) {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            abosUnderTest.setEmailAbos(email);
        });
        assertEquals(exception.getMessage(), "l'email ne doit pas être vide");
    }

    @ParameterizedTest
    @EmptySource
    void setEmailAbosBlank(String email) {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            abosUnderTest.setEmailAbos(email);
        });
        assertEquals(exception.getMessage(), "l'email ne doit pas être vide");
    }

    @org.junit.jupiter.api.Test
    void getDateInscriptionAbos() {
    }

    @org.junit.jupiter.api.Test
    void setDateInscriptionAbosUnJourAvant() {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            abosUnderTest.setDateInscriptionAbos(LocalDate.now().minusDays(1));
        });
        assertEquals(exception.getMessage(), "La date ne doit pas être antérieure qu'aujourd'hui");
    }

    @org.junit.jupiter.api.Test
    void setDateInscriptionAbosUnJourApres() {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            abosUnderTest.setDateInscriptionAbos(LocalDate.now().plusDays(1));
        });
        assertEquals(exception.getMessage(), "La date d'inscription ne doit pas être supérieur qu'aujourd'hui");
    }
}