package com.novi.eindproject.idrunk.version.july.service;


import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.model.Order;

import java.util.List;

public interface DrinkService {

    List<Drink> getDrinks();

    Drink getDrink(long id) throws RecordNotFoundException;

    Drink addDrink(Drink drink);
    void removeDrink(long id) throws RecordNotFoundException;
    void updateDrink(long id, Drink drink) throws RecordNotFoundException;


    Drink deleteDrink(Long id);

//    Drink editDrink(Long id, Drink fromDrink);


}