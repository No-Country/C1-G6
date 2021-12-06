package io.orderup.repositories;

import io.orderup.models.Order;
import io.orderup.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    Optional<User> findById(long id);
}
