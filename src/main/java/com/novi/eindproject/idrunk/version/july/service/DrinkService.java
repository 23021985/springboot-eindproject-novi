package com.novi.eindproject.idrunk.version.july.service;
import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import java.util.List;

public interface DrinkService {

    List<Drink> getDrinks();

    Drink getDrink(long id) throws RecordNotFoundException;

    Drink saveDrink(Drink drink);

    void updateDrink(long id, Drink drink) throws RecordNotFoundException;

    void deleteDrink(Long id);
}