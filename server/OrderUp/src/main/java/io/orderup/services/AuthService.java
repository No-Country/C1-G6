package io.orderup.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.orderup.models.User;
import io.orderup.repositories.UserRepository;
import io.orderup.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Service
public class AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        ObjectMapper mapper = new ObjectMapper();
        String json="";

        try {
            json = mapper.writeValueAsString(user);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //return "The user: \n Name: " + user.getUsername() + "\n Email: " + user.getEmail() + "\n was successfully registered";
        return  "The user \n" + json + "\n has been successfully registered";
    }

    public void changeData(long id, User user){
        userRepository.save(user);
    }

    public String Object (HttpServletRequest httpServletRequest){
        Principal principal = httpServletRequest.getUserPrincipal();
        return principal.getName();
    }
}

