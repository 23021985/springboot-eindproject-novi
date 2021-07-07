package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import com.novi.eindproject.idrunk.version.july.model.Tafel;
import com.novi.eindproject.idrunk.version.july.repository.BookingRepository;
import com.novi.eindproject.idrunk.version.july.repository.TafelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class TafelServiceImpl implements TafelService {

    @Autowired
    TafelRepository tafelRepository;

    @Override
    public List<Tafel> getTafel() {
       return tafelRepository.findAll();
    }

    @Override
    public Tafel getTafel(long id) throws RecordNotFoundException {
       return tafelRepository.getById(id);
    }

    @Override
    public Tafel addTafel(Tafel tafel) {
        return tafelRepository.save(tafel);
    }

    @Override
    public void removeTafel(long id) throws RecordNotFoundException {
    return ;
    }

    @Override
    public void updateTafel(long id, Tafel tafel) throws RecordNotFoundException {

    }

//    @Override
//    public String createTafel(Tafel tafel) {
//        return null;
//    }
}