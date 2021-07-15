package com.novi.eindproject.idrunk.version.july.controller;


import com.novi.eindproject.idrunk.version.july.dto.DrinkDto;
import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/drink")
public class DrinkController {

    private final DrinkService drinkService;

    @Autowired
    private DrinkController(DrinkService drinkService){
        this.drinkService = drinkService;
    }

    @PostMapping("")
    public ResponseEntity<DrinkDto> addDrink(@RequestBody final DrinkDto drinkDto) {
        Drink drink = drinkService.addDrink(Drink.from(drinkDto));
        return new ResponseEntity<>(DrinkDto.from(drink), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DrinkDto>> getDrinks(){
        List<Drink> drinks = drinkService.getDrinks();
        List<DrinkDto> drinksDto = drinks.stream().map(DrinkDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(drinksDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<DrinkDto> getDrink(@PathVariable final Long id){
        Drink drink = drinkService.getDrink(id);
        return new ResponseEntity<>(DrinkDto.from(drink), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<DrinkDto> deleteDrink(@PathVariable final Long id){
        Drink drink = drinkService.deleteDrink(id);
        return new ResponseEntity<>(DrinkDto.from(drink), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<DrinkDto> editDrink(@PathVariable final Long id,
                                              @RequestBody final DrinkDto drinkDto){
        Drink editedDrink = drinkService.editDrink(id, Drink.from(drinkDto));
        return new ResponseEntity<>(DrinkDto.from(editedDrink), HttpStatus.OK);
    }

//    @PostMapping("")
//    public ResponseEntity<Object> addDrink(@RequestBody Drink drink) {
//        drinkService.addDrink(drink);
//        return ResponseEntity.ok("Added");
//    }

    //    @GetMapping("")
//    public ResponseEntity<Object> getDrinks() {
//        return ResponseEntity.ok(drinkService.getDrinks());
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getDrink(@PathVariable("id") long id) throws RecordNotFoundException {
//        Drink drink = drinkService.getDrink(id);
//        return ResponseEntity.ok(drink);
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateDrink(@PathVariable("id") long id, @RequestBody Drink newDrink) throws RecordNotFoundException {
//        drinkService.updateDrink(id, newDrink);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> removeDrink(@PathVariable("id") long id) throws RecordNotFoundException {
//        drinkService.removeDrink(id);
//        return ResponseEntity.noContent().build();
//    }
}
