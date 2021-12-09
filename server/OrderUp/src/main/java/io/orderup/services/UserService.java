package io.orderup.services;

import io.orderup.models.User;
import io.orderup.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public User getUser(long id) {
        try {
            var user = userRepository.findById(id);
            return user;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Transactional
    public User findById(long id) {
        return userRepository.findById(id);
    }
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteById(long id){
        userRepository.deleteById(id);
    }

}
