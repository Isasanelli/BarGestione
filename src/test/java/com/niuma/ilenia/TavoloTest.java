package com.niuma.ilenia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TavoloTest {


    @Test
    void tavoloNuovoDeveEssereDisponibile() {
        var tavolo = new Tavolo();
        assertEquals (true, tavolo.isDisponibile());

    }
    @Test
    void tavoloPrenotatoNonDeveEssereDisponibile() {
        var tavolo = new Tavolo();
        tavolo.prenotaPer ("ilenia");
        assertEquals (false, tavolo.isDisponibile());
    }
    @Test
    void tavoloPrenotatoELiberatoDeveEssereDisponibile() {
        var tavolo = new Tavolo();
        tavolo.prenotaPer ("ilenia");
        tavolo.liberaTavolo ();
        assertEquals (true, tavolo.isDisponibile());
    }

    @Test
    void prenotaPer() {
    }

    @Test
    void getNominativo() {
    }
}