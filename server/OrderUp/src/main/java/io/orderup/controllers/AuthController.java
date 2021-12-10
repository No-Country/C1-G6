package io.orderup.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.MalformedJwtException;
import io.orderup.models.AuthenticationRequest;
import io.orderup.models.User;
import io.orderup.repositories.UserRepository;
import io.orderup.services.AuthService;
import io.orderup.services.OUUserDetailsService;
import io.orderup.services.UserService;
import io.orderup.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Autowired
    private OUUserDetailsService ouUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/user")
    public String getUser(HttpServletRequest httpServletRequest) {
        String json = "";
        User user;
        String jwt = null;
        final String authorizationHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        /*if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            user = xmuserDetailsService.loadUserByUsername(jwtUtil.extractEmail(jwt));
        } else {
            return "there is no logged user";
        }*/
        try {
            jwt = authorizationHeader.substring(7);
            user = ouUserDetailsService.loadUserByUsername(jwtUtil.extractEmail(jwt));
        } catch (MalformedJwtException | IllegalArgumentException e) {
            return "there is no logged user";
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
                json = mapper.writeValueAsString(user);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public String createAuthenticationToken(HttpServletRequest httpServletRequest,
            @RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        String json = "";
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                            authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final User userDetails = ouUserDetailsService
                .loadUserByUsername(authenticationRequest.getEmail());

        final String jwt = jwtUtil.generateToken(userDetails);

        Map<String,String> response = new HashMap<String,String>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String expire = dateFormat.format(jwtUtil.extractExpiration(jwt));
        response.put("access_token",jwt);
        response.put("token_type","Bearer");
        response.put("expires_at",expire);
        String token_type = "Bearer";
        Date expires_at = jwtUtil.extractExpiration(jwt);

        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(response);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String register(@RequestBody User user) {
        /*int randomNum = ThreadLocalRandom.current().nextInt(1, 2);;
        while (randomNum == 39 | randomNum == 40 | randomNum == 41 | randomNum == 42 | randomNum == 0){
            randomNum = ThreadLocalRandom.current().nextInt(1, 45);
        }
        User CUser = userService.getUser(randomNum);*/
        String randomString;
        Random random = new Random();
        char[] word = new char[ThreadLocalRandom.current().nextInt(4, 8)];
        for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
        randomString = new String(word);
        System.out.println(randomString);
        user.setPassword(user.getPassword() + randomString);
        return authService.register(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/change-data/{id}")
    public void changeData(@PathVariable String id, @RequestBody User user) {
        authService.changeData(id, user);
    }
}

