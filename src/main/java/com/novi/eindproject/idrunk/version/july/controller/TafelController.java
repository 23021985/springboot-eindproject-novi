package com.novi.eindproject.idrunk.version.july.controller;
import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Tafel;
import com.novi.eindproject.idrunk.version.july.service.TafelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/tafels")
public class TafelController {

    @Autowired
    private final TafelService tafelService;

    public TafelController(TafelService tafelService) {
        this.tafelService = tafelService;
    }

    @GetMapping()
    public ResponseEntity<Object> getTafel(){
        return ResponseEntity.ok().body(tafelService.getTafel());
    }

    @GetMapping(value = "/id")
    public ResponseEntity<Object> getTafel(@PathVariable("id") long id) {
        Tafel tafel = tafelService.getTafel(id);
        return ResponseEntity.ok(tafel);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> addTafel(@RequestBody Tafel tafel) {
       tafelService.addTafel(tafel);
        return ResponseEntity.ok("Added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateTable(@PathVariable("id") long id, @RequestBody Tafel newTafel) {
        tafelService.updateTafel(id, newTafel);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/id")
    public ResponseEntity<Object> deleteBooking(@PathVariable("id") long id) throws RecordNotFoundException {
        tafelService.removeTafel(id);
        return ResponseEntity.noContent().build();
    }


}