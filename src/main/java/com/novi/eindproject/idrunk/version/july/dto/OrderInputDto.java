package com.novi.eindproject.idrunk.version.july.dto;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.model.Order;
import com.novi.eindproject.idrunk.version.july.model.User;

public class OrderInputDto {

    public User user;

    public Drink drinkList;

    public Long id;

    public int count;

    public Order toOrder(){
       var order = new Order();
       order.setId(id);
       order.setCount(count);
//       order.setUser(user);

       return order;
    }
}
