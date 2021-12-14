package io.orderup.services;

import io.orderup.models.User;
import io.orderup.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OUUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException{
        return userRepository.findByEmail(email);
    }
}
