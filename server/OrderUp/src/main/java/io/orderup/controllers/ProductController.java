package io.orderup.controllers;

import io.orderup.models.Product;
import io.orderup.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(required = false) String name){
            return productService.getAllProducts();
    }

    @RequestMapping("/products/{id}")
    public Optional<Product> getProduct(@PathVariable long id){
        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public void addProduct(@ModelAttribute Product product) throws IOException {
        productService.addProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public void updateProduct(@PathVariable long id, @ModelAttribute Product product) throws IOException {
        Product oldProduct = getProduct(id).get();
        if (product.getName() == null){
            product.setName(oldProduct.getName());
        }
        if (product.getPrice() == null){
            product.setPrice(oldProduct.getPrice());
        }
        if (product.getStock() == null){
            product.setStock(oldProduct.getStock());
        }
        if (product.getDescription() == null){
            product.setDescription(oldProduct.getDescription());
        }
        if (product.getCategory() == null){
            product.setCategory(oldProduct.getCategory());
        }
        productService.updateProduct(id, product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
    public void deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
    }
}
