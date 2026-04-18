package tn.esprit.spring.control;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

// userRestControl
@RestController
@RequestMapping("/user")
public class UserRestControl {

    private final IUserService userService;

public UserRestControl(IUserService userService) {
    this.userService = userService;
}

    // Récupérer tous les utilisateurs
    @GetMapping("/retrieve-all-users")
    public List<User> retrieveAllUsers() {
        return userService.retrieveAllUsers();
    }

    // Récupérer un utilisateur par ID (JSON complet sauf mot de passe)
    @GetMapping("/retrieve-user/{user-id}")
    public User retrieveUser(@PathVariable("user-id") String userId) {
        User user = userService.retrieveUser(userId);
        if(user != null) {
            // On cache le mot de passe avant d’envoyer le JSON
            user.setPassword(null);
        }
        return user;
    }

    // Ajouter un utilisateur
    @PostMapping("/add-user")
    public User addUser(@RequestBody User u) {
        User user = userService.addUser(u); 
        user.setPassword(null); // on ne renvoie pas le mot de passe
        return user;
    }

    // Supprimer un utilisateur
    @DeleteMapping("/remove-user/{user-id}") 
    public void removeUser(@PathVariable("user-id") String userId) { 
        userService.deleteUser(userId);
    } 

    // Modifier un utilisateur
    @PutMapping("/modify-user") 
    public User updateUser(@RequestBody User user) {
        User updated = userService.updateUser(user);
        if(updated != null) {
            updated.setPassword(null);
        }
        return updated;
    }
}
