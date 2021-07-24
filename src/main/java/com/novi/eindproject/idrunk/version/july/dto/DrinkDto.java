package com.novi.eindproject.idrunk.version.july.dto;

import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.repository.DrinkRepository;
import lombok.Data;

import java.util.Objects;

@Data
public class DrinkDto {

    private Long id;

    public double price;

    public String name;

    public int amount;


    public static DrinkDto fromDrink(Drink drinkList){
        DrinkDto drinkDto = new DrinkDto();
        drinkDto.setName(drinkList.getName());
        drinkDto.setId(drinkList.getId());
        drinkDto.setAmount(drinkList.getAmount());

        return drinkDto;
    }
}
