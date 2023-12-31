package demo.practice_20230914.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import demo.practice_20230914.models.*;
import demo.practice_20230914.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() throws JsonProcessingException {
        return userService.getUsers();
    }

    @GetMapping("/redis/{email}")
    public User getUserByEmail(@PathVariable("email") String email)  throws JsonProcessingException {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public void CreateUser(@RequestBody CreateUser createUser){
        userService.createUser(createUser);
    }

    @PutMapping
    public void PutUser(@RequestBody PutUser putUser){
        userService.putUser(putUser);
    }

    @PatchMapping
    public void PatchUser(@RequestBody PatchUser patchUser){
        userService.patchUser(patchUser);
    }

    @DeleteMapping
    public void DeleteUser(@RequestBody DeleteUser deleteUser){
        userService.deleteUser(deleteUser);
    }

}
