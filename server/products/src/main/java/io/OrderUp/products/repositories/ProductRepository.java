package io.OrderUp.products.repositories;

import io.OrderUp.products.models.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String>{
}
