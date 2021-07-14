package com.novi.eindproject.idrunk.version.july.controller;
import com.novi.eindproject.idrunk.version.july.dto.TafelDto;
import com.novi.eindproject.idrunk.version.july.dto.TafelInputDto;
import com.novi.eindproject.idrunk.version.july.model.Tafel;
import com.novi.eindproject.idrunk.version.july.service.TafelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tafels")
public class TafelController {

    private final TafelService tafelService;

    public TafelController(TafelService tafelService) {
        this.tafelService = tafelService;
    }


    @GetMapping("")
    public ResponseEntity<Object> getTafel() {return ResponseEntity.ok(tafelService.getTafel());}

//    @PostMapping("")
//    public ResponseEntity<Object> addBike(@RequestBody Bike bike) {
//        bikeService.addBike(bike);
//        return ResponseEntity.ok("added");
//    }

    @PostMapping
    public TafelDto saveTafel(@RequestBody TafelInputDto dto) {
        var tafel = tafelService.addTafel(dto.toTafel());
        return TafelDto.fromTafel(tafel);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getTafels(@PathVariable("id") long id) {
        Tafel tafel = (Tafel) tafelService.getTafels(id);
        return ResponseEntity.ok(tafel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> removeTafel(@PathVariable("id") long id) {
        tafelService.removeTafel(id);
        return ResponseEntity.noContent().build();
    }

}



