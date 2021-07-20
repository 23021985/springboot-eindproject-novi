package com.novi.eindproject.idrunk.version.july.service;
import com.novi.eindproject.idrunk.version.july.model.Tafel;
import java.util.List;

public interface TafelService {

    List<Tafel> getTafel();

    Tafel getTafel(Long id);

    Tafel saveTafel(Tafel tafel);

    void removeTafel(Long id);
}



