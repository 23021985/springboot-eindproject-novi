package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.model.Tafel;

import java.util.List;

public interface TafelService {

    List<Tafel> getTafel();

    List<Tafel> findTafelsByTafelNr(Long id);
//
    List <Tafel>findTafelsById(Long id);
//
    Tafel saveTafel(Tafel tafel);
//
    void deleteTafel(Long id);
//
//    void removeTafel(long id);
//
//    void updateTafel(long id, Tafel newTafel);
//
    void addTafel(Tafel tafel);
}





