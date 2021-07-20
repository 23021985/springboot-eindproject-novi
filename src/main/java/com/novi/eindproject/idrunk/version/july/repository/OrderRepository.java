package com.novi.eindproject.idrunk.version.july.repository;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> getById(Long id);

    List<Order> getByUserName(String userName);

    Order addDrinkToOrder(Order order, Long drinkId, String username);

    Object addDrinksToOrder( Order order, Long drinkId, String username);

//    Order saveOrder(Order order, Long drinkId, String username);
}
