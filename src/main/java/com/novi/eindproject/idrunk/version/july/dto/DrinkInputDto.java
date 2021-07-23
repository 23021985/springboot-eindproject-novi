package com.novi.eindproject.idrunk.version.july.dto;
import com.novi.eindproject.idrunk.version.july.model.Drink;

public class DrinkInputDto {

    public Long id;

    public String name;

    public double price;

    public int amount;

    public Drink toDrink() {
        var drink = new Drink();
        drink.setId(id);
        drink.setName(name);
        drink.setPrice(price);
        drink.setAmount(amount);
        return drink;
    }
}
