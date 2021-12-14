package io.orderup.repositories;

import io.orderup.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    User findByEmail(String email);
    User findById(long id);
    @Transactional
    void deleteById(long id);
}
