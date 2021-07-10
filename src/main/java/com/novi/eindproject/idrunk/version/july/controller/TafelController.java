package com.novi.eindproject.idrunk.version.july.controller;
import com.novi.eindproject.idrunk.version.july.dto.TafelDto;
import com.novi.eindproject.idrunk.version.july.dto.TafelInputDto;
import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Tafel;
import com.novi.eindproject.idrunk.version.july.service.FetchDataService;
import com.novi.eindproject.idrunk.version.july.service.TafelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tafels")
public class TafelController {

    private final TafelService tafelService;

    @Autowired
    public TafelController(TafelService tafelService) {
        this.tafelService = tafelService;
    }

    @GetMapping
    public List<TafelDto> getTafels(@RequestParam(value = "type", required = false) Long id) {
        var dtos = new ArrayList<TafelDto>();

        List <Tafel> tafels;
        if (id == null) {
//
            tafels = tafelService.findTafelsById(id);
            for (Tafel tafel : tafels) {
                dtos.add(TafelDto.fromTafel(tafel));
            }
//        } else {
//            for (Tafel tafel : tafels) {
//                dtos.add(TafelDto.fromTafel(tafel));
//            }
        }

        return dtos;
    }

    @PostMapping
    public TafelDto saveTafel(@RequestBody TafelInputDto dto) {
        Tafel tafel = tafelService.saveTafel(dto.toTafel());
        return TafelDto.fromTafel(tafel);
    }

    @DeleteMapping("/{id}")
    public void deleteTafel(@PathVariable("id") Long id) {
        tafelService.deleteTafel(id);
    }

//    @Autowired
//    FetchDataService fetchDataService;
//
//    @GetMapping(path = "/getdata")
//    List<Tafel> getTafels(){
//        return fetchDataService.findAll();
//    }
//
//    @Autowired
//    private final TafelService tafelService;
//
//    public TafelController(TafelService tafelService) {
//        this.tafelService = tafelService;
//    }

//    @GetMapping()
//    public ResponseEntity<Object> getTafel(){
//        return ResponseEntity.ok().body(tafelService.getTafel());
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getTafel(@PathVariable("id")Long id) {
        Tafel tafel = (Tafel) tafelService.getTafel();
        return ResponseEntity.ok(tafel);
    }


}