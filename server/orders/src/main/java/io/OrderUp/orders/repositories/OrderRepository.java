package io.OrderUp.orders.repositories;

import io.OrderUp.orders.models.Order;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, String>{
}
