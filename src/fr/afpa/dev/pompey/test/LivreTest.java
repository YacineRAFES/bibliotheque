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
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @NullSource
    void setTitreNull(String livre) {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            livreUnderTest.setTitre(livre);
        });
        assertEquals(exception.getMessage(), "le prenom ne doit pas être vide");
    }

    @ParameterizedTest
    @EmptySource
    void setTitreEmpty(String livre) {
        SaisieException exception = assertThrows(SaisieException.class, () -> {
            livreUnderTest.setTitre(livre);
        });
        assertEquals(exception.getMessage(), "le prenom ne doit pas être vide");
    }

    @Test
    void setAuteur() {
    }

    @Test
    void setQuantite() {
    }
}