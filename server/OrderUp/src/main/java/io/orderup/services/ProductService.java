package io.orderup.services;

import io.orderup.models.Product;
import io.orderup.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll()
                .forEach(products::add);
        return products;
    }

    public Optional<Product> getProduct(long id){
        return productRepository.findById(id);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(long id, Product product){
        productRepository.save(product);
    }

    public void deleteProduct(long id){
        productRepository.deleteById(id);
    }

}
