package io.orderup.services;

import io.orderup.models.User;
import io.orderup.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public abstract class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final io.orderup.models.User user;
    private long id;

    protected UserService(UserRepository userRepository, io.orderup.models.User user) {
        this.userRepository = userRepository;
        this.user = user;
    }
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().
                forEach(users::add);
        return users;

    }

    public Object getUser(long id) {
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
        this.id = id;
    }
    
    public void removeUser(Long id) {
        userRepository.deleteById(String.valueOf(id));
    }

    public void save(String name, String surname, String password, Long phone, String email) {
        userRepository.save(user);
    }


}
