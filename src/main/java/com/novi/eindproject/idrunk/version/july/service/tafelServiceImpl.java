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
    private TafelRepository repository;

    @Autowired
    public TafelServiceImpl(TafelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tafel> getTafel() {
        return repository.findAll();
    }

    @Override
    public List<Tafel> findTafelsByTafelNr(String query) {
        return repository.findByNameContainingIgnoreCase(query);
    }

    @Override
    public List<Tafel> findTafelsByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public Tafel saveTafel(Tafel tafel) {
        return repository.save(tafel);
    }

    @Override
    public void deleteTafel(Long id) {
        repository.deleteById(id);
    }

//    @Override
//    public void removeTafel(long id) {
//
//    }
//
//    @Override
//    public void updateTafel(long id, Tafel newTafel) {
//
//    }
//
//    @Override
//    public void addTafel(Tafel tafel) {

//    }
}
