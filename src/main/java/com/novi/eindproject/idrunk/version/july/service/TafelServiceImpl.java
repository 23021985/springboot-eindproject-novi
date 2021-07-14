package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.model.Tafel;
import com.novi.eindproject.idrunk.version.july.repository.TafelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TafelServiceImpl implements TafelService {

    private TafelRepository repository;

    @Autowired
    public TafelServiceImpl(TafelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tafel> getTafel() { return repository.findAll(); }

    @Override
    public Tafel getTafels(long id) { return repository.getById(id); }

    @Override
    public Tafel addTafel(Tafel tafel) { return repository.save(tafel); }

    @Override
    public void removeTafel(long id) { repository.deleteById(id); }

    @Override
    public void updateTafel(long id, Tafel tafel) {}



}