package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.model.Tafel;

import java.util.List;

public interface TafelService {

    List<Tafel> getTafel();
    Tafel getTafels(long id);
    Tafel addTafel(Tafel tafel);
    void removeTafel(long id);
    void updateTafel(long id, Tafel tafel);




}



