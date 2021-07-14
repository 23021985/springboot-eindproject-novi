package com.novi.eindproject.idrunk.version.july.dto;

import com.novi.eindproject.idrunk.version.july.model.Tafel;

public class TafelInputDto {

    public Long tafelNr;
    public int maxGuest;
    public Long id;

    public Tafel toTafel() {
        var tafel = new Tafel(tafelNr, maxGuest);
        tafel.setTafelNr(tafelNr);
        tafel.setMaxGuest(maxGuest);

        return tafel;
    }

}
