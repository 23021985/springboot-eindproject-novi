package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.model.Tafel;

import java.util.List;

public interface TafelService {
    List<Tafel> getTafel();
    Tafel getTafel(long id) throws RecordNotFoundException;
    Tafel addTafel(Tafel tafel);
    void removeTafel(long id) throws RecordNotFoundException;
    void updateTafel(long id, Tafel tafel) throws RecordNotFoundException;
//    String createTafel(Tafel tafel);
}




