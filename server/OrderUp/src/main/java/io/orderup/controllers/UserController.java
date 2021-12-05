package io.orderup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public Users getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }

    @PostMapping("/guardar")
    public <exception> String guardar(RedirectAttributes redirectAt,
                                      @RequestParam String name, @RequestParam String surname,
                                      @RequestParam String password, @RequestParam String phone, @RequestParam String email) {
        try {
            amigoService.save(name, surname, password, phone, email);
            return "redirect:/";
        } catch (Error e) {
            redirectAt.addFlashAttribute("error", e.getMessage());
            return "redirect:/user/registroUser";
        }
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam String id) {
        userService.eliminarUser(id);
        return "redirect:/user/listaUser";
    }
}




   

    