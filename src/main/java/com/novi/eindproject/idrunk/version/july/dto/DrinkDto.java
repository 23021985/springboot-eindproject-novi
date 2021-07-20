package com.novi.eindproject.idrunk.version.july.dto;

import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.repository.DrinkRepository;
import lombok.Data;

import java.util.Objects;

@Data
public class DrinkDto {

    private Long id;

    public int count;

    public double price;

    public String name;

    public int amount;

    private PlainOrderDto plainOrderDto;


    public static DrinkDto fromDrink(Drink drink){
        DrinkDto drinkDto = new DrinkDto();
        drinkDto.setName(drink.getName());
        drinkDto.setId(drink.getId());
        drinkDto.setAmount(drink.getAmount());
        drinkDto.setCount(drink.getCount());

        return drinkDto;
    }
}
