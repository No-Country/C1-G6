package io.orderup.controllers;

import io.orderup.models.Order;
import io.orderup.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderservice;

    @GetMapping("/orders")
    public List<Order> getOrders(@RequestParam(required = false) String name){
        return orderservice.getAllOrders();
    }

    @RequestMapping("/orders/{id}")
    public Optional<Order> getOrder(@PathVariable long id){
        return orderservice.getOrder(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/orders")
    public void addOrder(@ModelAttribute Order order) throws IOException {
        orderservice.addOrder(order);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orders/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateOrder(@PathVariable long id, @ModelAttribute Order order) throws IOException {
        orderservice.updateOrder(id, order);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{id}")
    public void deleteOrder(@PathVariable long id){
        orderservice.deleteOrder(id);
    }
}
