package com.novi.eindproject.idrunk.version.july.repository;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
//    Drink getById(Long id);
}
