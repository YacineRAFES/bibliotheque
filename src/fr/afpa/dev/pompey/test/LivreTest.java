package fr.afpa.dev.pompey.test;

import fr.afpa.dev.pompey.Modele.Abos;
import fr.afpa.dev.pompey.Modele.Livre;
import fr.afpa.dev.pompey.exception.SaisieException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class LivreTest {
    private Livre livreUnderTest;

    @BeforeEach
    void setUp() {
        livreUnderTest = new Livre("titre", "auteur", 1);
    }

    @AfterEach
    void tearDown() {
        livreUnderTest = null;
    }

    @ParameterizedTest
    @NullSource
    void setTitreNull(String livre) {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            livreUnderTest.setTitre(livre);
        });
        assertEquals(exception.getMessage(), "le titre du livre ne doit pas être vide");
    }

    @ParameterizedTest
    @EmptySource
    void setTitreEmpty(String livre) {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            livreUnderTest.setTitre(livre);
        });
        assertEquals(exception.getMessage(), "le titre du livre ne doit pas être vide");
    }

    @ParameterizedTest
    @NullSource
    void setAuteurNull(String auteur) {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            livreUnderTest.setAuteur(auteur);
        });
        assertEquals(exception.getMessage(), "le nom de l'auteur ne doit pas être vide");
    }

    @ParameterizedTest
    @EmptySource
    void setAuteurEmpty(String auteur) {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            livreUnderTest.setAuteur(auteur);
        });
        assertEquals(exception.getMessage(), "le nom de l'auteur ne doit pas être vide");
    }

    @Test
    void setQuantite() {
    }
}