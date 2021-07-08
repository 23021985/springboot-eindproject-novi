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

//    @GetMapping
//    public List<TafelDto> getTafels(@RequestParam(value = "query", required = false, defaultValue = "") String query,
//                                  @RequestParam(value = "type", required = false) String type) {
//        var dtos = new ArrayList<TafelDto>();

//        List<Tafel> tafel;
//        if (type == null) {
//            tafel = tafelService.findTafelsByTafelNr(query);
//        } else {
//            tafel = tafelService.findTafelsByType(type);
//        }
//
//        for (Tafel tafel : tafels) {
//            dtos.add(TafelDto.fromTafel(tafel));
//        }
//
//        return dtos;
//    }

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
//
    @GetMapping()
    public ResponseEntity<Object> getTafel(){
        return ResponseEntity.ok().body(tafelService.getTafel());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getTafel(@PathVariable("id") Long id) {
        Tafel tafel = (Tafel) tafelService.getTafel();
        return ResponseEntity.ok(tafel);
    }
}
//
//    @PostMapping(value = "")
//    public ResponseEntity<Object> addTafel(@RequestBody Tafel tafel) {
//       tafelService.addTafel(tafel);
//        return ResponseEntity.ok("Added");
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Object> updateTafel(@PathVariable("id") long id, @RequestBody Tafel newTafel) {
//        tafelService.updateTafel(id, newTafel);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping(value = "/id")
//    public ResponseEntity<Object> deleteTafel(@PathVariable("id") long id) throws RecordNotFoundException {
//        tafelService.removeTafel(id);
//        return ResponseEntity.noContent().build();
//    }
//
//}