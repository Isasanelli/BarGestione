package com.niuma.ilenia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test

    void tuttiTavoliLiberiAllaPartenza(){
        var prenotazioniApp = new Main(3);
        assertEquals (3, prenotazioniApp.getTavoliLiberi ());
    }
    @Test

    void aggiuntaPrenotazioneDecrementaTavoliLiberi(){
        var prenotazioniApp = new Main(3);
        var tavoliLiberi = prenotazioniApp.getTavoliLiberi ();
        try {
            prenotazioniApp.prenota("Ilenia");
            assertEquals (1,tavoliLiberi - prenotazioniApp.getTavoliLiberi ());
        } catch (NessunTavoloDisponibileException e) {
            throw new RuntimeException (e);
        }

    }

}