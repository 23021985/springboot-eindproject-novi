package com.novi.eindproject.idrunk.version.july.controller;
import com.novi.eindproject.idrunk.version.july.dto.DrinkDto;
import com.novi.eindproject.idrunk.version.july.dto.DrinkInputDto;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/drink")
public class DrinkController {

    private final DrinkService drinkService;

    @Autowired
    private DrinkController(DrinkService drinkService){
        this.drinkService = drinkService;
    }

    @GetMapping
    public List<DrinkDto>getDrinks() {
        var dtos = new ArrayList<DrinkDto>();
        var drinks = drinkService.getDrinks();

        for (Drink drink:drinks) {
            dtos.add(DrinkDto.fromDrink(drink));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public DrinkDto getDrink(@PathVariable("id") Long id) {
        var drink = drinkService.getDrink(id);
        return DrinkDto.fromDrink(drink);
    }

    @PostMapping
    public DrinkDto saveDrink(@RequestBody DrinkInputDto dto) {
        var drink = drinkService.saveDrink(dto.toDrink());
        return DrinkDto.fromDrink(drink);
    }

    @DeleteMapping("/{id}")
    public void deleteDrink(@PathVariable("id") Long id) {
        drinkService.deleteDrink(id);
    }

    @PutMapping("/{id}")
    public void updateDrink(@PathVariable("id") Long id,
                         @RequestBody Drink drink) {
        drinkService.updateDrink(id, drink);
    }
}
