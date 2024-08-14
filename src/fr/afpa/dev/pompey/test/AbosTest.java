package fr.afpa.dev.pompey.test;

import fr.afpa.dev.pompey.Modele.Abos;

import static org.junit.jupiter.api.Assertions.*;

class AbosTest {
    private final Abos abos = new Abos();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getNomAbos() {
    }

    @org.junit.jupiter.api.Test
    void setNomAbos() {
        String testNom = " ";
        abos.setNomAbos(testNom);

        assertAll("properties",
                () -> {
                    String firstName = abos.getNomAbos();
                    assertNotNull(firstName);
                    });
    }

    @org.junit.jupiter.api.Test
    void getPrenomAbos() {
    }

    @org.junit.jupiter.api.Test
    void setPrenomAbos() {
        assertAll();
    }

    @org.junit.jupiter.api.Test
    void getEmailAbos() {
    }

    @org.junit.jupiter.api.Test
    void setEmailAbos() {
        assertAll();
    }

    @org.junit.jupiter.api.Test
    void getDateInscriptionAbos() {
    }

    @org.junit.jupiter.api.Test
    void setDateInscriptionAbos() {
        assertAll();
    }
}