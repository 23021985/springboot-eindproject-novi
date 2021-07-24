package com.novi.eindproject.idrunk.version.july.service;
import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService{

    private DrinkRepository drinkRepository;

    @Autowired
    public DrinkServiceImpl(DrinkRepository drinkRepository){
        this.drinkRepository = drinkRepository;
    }

    @Override
    public List<Drink> getDrinks() {
        return drinkRepository.findAll();
    }

    @Override
    public Drink getDrink(long id) {
        Optional<Drink> drink = drinkRepository.findById(id);
        if (drink.isPresent()) {
            return drink.get();
        } else {
            throw new RecordNotFoundException("Het drankje is niet gevonden");
        }
    }

    @Override
    public Drink saveDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    @Override
    public void updateDrink(long id, Drink drink) {
        Optional<Drink> optionalDrink = drinkRepository.findById(id);
        if (optionalDrink.isPresent()) {
            drinkRepository.deleteById(id);
            drinkRepository.save(drink);
        } else {
            throw new RecordNotFoundException("Het drankje is niet gevonden");
        }
    }

    @Override
    public void deleteDrink(Long id) {
         drinkRepository.deleteById(id);
    }
}
