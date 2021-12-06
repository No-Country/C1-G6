package io.orderup.controllers;

import io.orderup.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public Optional<io.orderup.models.User> getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }

    @PostMapping("/saveUser")
    public <exception> String saveUser (RedirectAttributes redirectAt,
                                        @RequestParam String name, @RequestParam String surname,
                                        @RequestParam String password, @RequestParam Long phone, @RequestParam String email) {
        try {
            userService.save(name, surname, password, phone, email);
            return "redirect:/";
        } catch (Error e) {
            redirectAt.addFlashAttribute("error", e.getMessage());
            return "redirect:/user/registerUser";
        }
    }

    @GetMapping("/removeUser")
    public String removeUser(@RequestParam Long id) {
        userService.removeUser(id);
        return "redirect:/user/listUser";
    }
}




   

    