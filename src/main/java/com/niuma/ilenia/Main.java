package com.niuma.ilenia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    List<Tavolo> tavoli;

    public Main (int nTavoli) {
        tavoli = new ArrayList<> ();
        setTavoli (nTavoli);
    }
    public void setTavoli (int nTavoli) {
        tavoli.clear ();
        for (int i = 0; i < nTavoli; i++) {
            tavoli.add (new Tavolo ());
        }
    }

    public static void main (String[] args) {
        var Main = new Main (3);
        Main.run ();

    }
    private void run () {
        var  sc = new Scanner (System.in);

        int scelta = -1;

        do{
            System.out.println ("Gestione prenotazioni");
            System.out.println ("tavoli liberi =" + getTavoliLiberi ());
            System.out.println ("1 - prenota");
            System.out.println ("2 - libera");
            System.out.println ("0 - esci");

            System.out.println ();
            System.out.println (">");
            scelta =sc.nextInt ();

            switch (scelta){
                case 1: prenotaTavolo();
                    break;

                case 2: liberaTavolo();
                    break;
                case 0: return;
            }


        }while (scelta != 0);
    }

    private void liberaTavolo () {
        var sc = new Scanner (System.in);
        var nominativo = sc.nextLine ();
        for (var tavolo: tavoli){
            if(tavolo.Nominativo ().equals(nominativo)){
                tavolo.liberaTavolo ();
                return;
            }
        }

    }

    private void prenotaTavolo () {
        var sc = new Scanner (System.in);
        var nominativo = sc.nextLine ();
        try {
            prenota (nominativo);
        } catch (NessunTavoloDisponibileException e) {
            throw new RuntimeException (e);
        }
    }

    public int getTavoliLiberi () {
        int tavoliLiberi = 0;
        for (var tavolo: tavoli){
            if(tavolo.isDisponibile ()){
                tavoliLiberi++;
            }
        }
        return tavoliLiberi;
    }

    public void prenota (String nominativo) throws NessunTavoloDisponibileException {
        if (getTavoliLiberi () ==0){
            throw new NessunTavoloDisponibileException();
        }
        for (var tavolo: tavoli){
            if(tavolo.isDisponibile ()){
                tavolo.prenotaPer (nominativo);
                return;
            }
        }
    }
}