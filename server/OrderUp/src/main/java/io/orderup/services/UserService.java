package io.orderup.services;

import io.orderup.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<io.orderup.models.User> getUser(long id) {
        try {
            var user = userRepository.findById(id);
            return user;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Transactional
    public Optional<io.orderup.models.User> findById(String id) {

        return userRepository.findById(id);
    }

    public void deleteUser(long id) {
    }

    public void save(String name, String surname, String password, Long phone, String email) {
        userRepository.save(user);
    }

    public void removeUser(Long id) {
        userRepository.deleteForId(id);
    }
}
