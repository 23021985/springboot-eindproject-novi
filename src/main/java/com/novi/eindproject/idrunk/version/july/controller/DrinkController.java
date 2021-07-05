package com.novi.eindproject.idrunk.version.july.controller;


import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/drink")
public class DrinkController {

    @Autowired
    private DrinkService drinkService;

    @GetMapping("")
    public ResponseEntity<Object> getDrinks() {
        return ResponseEntity.ok(drinkService.getDrinks());
    }

    @PostMapping("")
    public ResponseEntity<Object> addPerson(@RequestBody Drink drink) {
        drinkService.addDrink(drink);
        return ResponseEntity.ok("Added");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPerson(@PathVariable("id") long id) throws RecordNotFoundException {
        Drink drink = drinkService.getDrink(id);
        return ResponseEntity.ok(drink);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDrink(@PathVariable("id") long id, @RequestBody Drink newDrink) throws RecordNotFoundException {
        drinkService.updateDrink(id, newDrink);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeDrink(@PathVariable("id") long id) throws RecordNotFoundException {
        drinkService.removeDrink(id);
        return ResponseEntity.noContent().build();
    }
}
