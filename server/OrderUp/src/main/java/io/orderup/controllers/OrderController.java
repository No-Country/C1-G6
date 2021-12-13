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
        Order oldOrder = getOrder(id).get();
        if (order.getUser() == null){
            order.setUser(oldOrder.getUser());
        }
        if (order.getTable() == null){
            order.setTable(oldOrder.getTable());
        }
        if (order.getTotal() == 0){
            order.setTotal(oldOrder.getTotal());
        }
        if (order.getComments() == null){
            order.setComments(oldOrder.getComments());
        }
        if (order.getProductlist() == null){
            order.setProductlist(oldOrder.getProductlist());
        }
        orderservice.updateOrder(id, order);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{id}")
    public void deleteOrder(@PathVariable long id){
        orderservice.deleteOrder(id);
    }
}
