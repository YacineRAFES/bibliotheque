package fr.afpa.dev.pompey.test;

import fr.afpa.dev.pompey.Modele.Pret;
import fr.afpa.dev.pompey.exception.SaisieException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PretTest {
    private Pret pretTest;

    @BeforeEach
    void setUp() {
        pretTest = new Pret(LocalDate.now(), LocalDate.now().plusDays(7));
    }

    @AfterEach
    void tearDown() {
        pretTest = null;
    }

    @Test
    void setDateDebutBeforeOf7Days() {

    }

    @Test
    void setDateDebutAfterOf7Days() {

    }

    @Test
    void setDateFinTestBeforeOf7Days() {

    }

    @Test
    void setDateFinTestAfterOf7Days() {

    }
}