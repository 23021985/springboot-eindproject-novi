package com.novi.eindproject.idrunk.version.july.dto;

import com.novi.eindproject.idrunk.version.july.model.Drink;
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

    public static DrinkDto from(Drink drink){
        DrinkDto drinkDto = new DrinkDto();
//        DrinkDto.setName(drink.getName());
        drinkDto.setId(drink.getId());
        drinkDto.setAmount(drink.getAmount());
        drinkDto.setCount(drink.getCount());

        if(Objects.nonNull(drink.getOrder())){
            drinkDto.setPlainOrderDto(PlainOrderDto.from(drink.getOrder()));
        }
        return drinkDto;
    }

}
