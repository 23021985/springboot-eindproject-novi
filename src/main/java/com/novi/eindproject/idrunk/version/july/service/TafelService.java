package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.model.Tafel;

import java.util.List;

public interface TafelService {

    List<Tafel> getTafel();

    List<Tafel> findTafelsByTafelNr(String query);
//
    List<Tafel> findTafelsByType(String type);
//
    Tafel saveTafel(Tafel tafel);
//
    void deleteTafel(Long id);

}





