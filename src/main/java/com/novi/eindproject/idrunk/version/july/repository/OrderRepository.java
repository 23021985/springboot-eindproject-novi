package com.novi.eindproject.idrunk.version.july.repository;
import com.novi.eindproject.idrunk.version.july.model.Order;
import com.novi.eindproject.idrunk.version.july.model.Tafel;
import com.novi.eindproject.idrunk.version.july.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByTafel(Tafel tafel);

    List<Order> findByUser(User user);

}
