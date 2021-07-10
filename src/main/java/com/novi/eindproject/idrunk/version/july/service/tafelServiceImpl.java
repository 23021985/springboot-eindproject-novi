package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.model.Tafel;
import com.novi.eindproject.idrunk.version.july.repository.TafelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Tafel> findTafelsByTafelNr(Long id) {
        return repository.findAll();
    }

    @Override
    public List<Tafel> findTafelsById(Long id) {
        return repository.findAll();    }


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
    @Override
    public void addTafel(Tafel tafel) {

    }
}
