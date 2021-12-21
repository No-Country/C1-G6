package io.orderup.services;

import io.orderup.models.Order;
import io.orderup.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository OrderRepository;

    public List<Order> getAllOrders(){
        List<Order> orders = new ArrayList<>();
        OrderRepository.findAll()
                .forEach(orders::add);
        return orders;
    }

    public Optional<Order> getOrder(long id){
        return OrderRepository.findById(id);
    }


    public void addOrder(Order order){
        OrderRepository.save(order);
    }

    public void updateOrder(long id, Order order){
        OrderRepository.save(order);
    }
    public void deleteOrder(long id){
        String sid = String.valueOf(id);
        OrderRepository.deleteById(sid);
    }

}
