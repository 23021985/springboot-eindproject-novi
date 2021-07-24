package com.novi.eindproject.idrunk.version.july.dto;

import com.novi.eindproject.idrunk.version.july.model.Tafel;

public class TafelDto {

    public Long id;

    public Long tafelNr;

    public int maxGuest;

    public static TafelDto fromTafel(Tafel tafel) {
//        if (tafel == null) return null;
        var dto = new TafelDto();
        dto.id = tafel.getId();
        dto.tafelNr = tafel.getTafelNr();
        dto.maxGuest = tafel.getMaxGuest();
        return dto;
    }
}
