package com.niuma.ilenia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Tavolo {
    private String nominativo;

    public boolean isDisponibile () {
        return ( nominativo == null ) || ( nominativo.length () == 0 );
    }

    public void prenotaPer(String nominativo){
        this.nominativo =nominativo;
    }

    public void liberaTavolo(){
        nominativo = null;
    }

    public Object Nominativo () {
        return nominativo;
    }

}
