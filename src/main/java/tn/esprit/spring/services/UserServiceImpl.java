package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public List<User> retrieveAllUsers() {
        List<User> users = null;
        try {
            l.info("Start retrieving all users");
            users = userRepository.findAll();
            l.info("End retrieving all users, count=" + (users != null ? users.size() : 0));
        } catch (Exception e) {
            l.error("Error in retrieveAllUsers(): " + e.getMessage(), e);
        }
        return users;
    }

    @Override
    public User addUser(User u) {
        User utilisateur = null;
        try {
            l.info("Adding user: " + u.getUsername());
            utilisateur = userRepository.save(u);
            l.info("User added with id=" + utilisateur.getId());
        } catch (Exception e) {
            l.error("Error in addUser(): " + e.getMessage(), e);
        }
        return utilisateur;
    }

    @Override
    public User updateUser(User u) {
        User userUpdated = null;
        try {
            l.info("Updating user id=" + u.getId());
            userUpdated = userRepository.save(u);
            l.info("User updated id=" + userUpdated.getId());
        } catch (Exception e) {
            l.error("Error in updateUser(): " + e.getMessage(), e);
        }
        return userUpdated;
    }

    @Override
    public void deleteUser(String id) {
        try {
            l.info("Deleting user id=" + id);
            userRepository.deleteById(Long.parseLong(id));
            l.info("User deleted id=" + id);
        } catch (Exception e) {
            l.error("Error in deleteUser(): " + e.getMessage(), e);
        }
    }

    @Override
    public User retrieveUser(String id) {
        User u = null;
        try {
            l.info("Retrieving user id=" + id);
            Optional<User> opt = userRepository.findById(Long.parseLong(id));
            u = opt.orElse(null);
            if (u != null) {
                l.info("User found: " + u.getUsername());
            } else {
                l.warn("User not found id=" + id);
            }
        } catch (Exception e) {
            l.error("Error in retrieveUser(): " + e.getMessage(), e);
        }
        return u;
    }
}