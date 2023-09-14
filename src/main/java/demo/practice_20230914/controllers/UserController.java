package demo.practice_20230914.controllers;

import demo.practice_20230914.models.PatchUserNameRequest;
import demo.practice_20230914.models.PutUserRequest;
import demo.practice_20230914.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController{
    List<User> users = new ArrayList<User>();

    @GetMapping
    public List<User> GetUser(){
        System.out.println("test2");
        return users;
    }

    @PostMapping
    public List<User> AddUser(@RequestBody User user){
        users.add(user);
        return users;
    }

    @PutMapping("/update/{email}")
    public List<User> PutUser(@PathVariable String email, @RequestBody PutUserRequest putUserRequest){
        users.forEach(user -> {
            if(user.getEmail().equals(email)){
                user.setUserName(putUserRequest.getUserName());
                user.setJob(putUserRequest.getJob());
            }
        });
        return users;
    }

    @PatchMapping("/rename/{email}")
    public List<User> PatchUserName(@PathVariable String email, @RequestBody PatchUserNameRequest patchUserNameRequest){
        users.forEach(user -> {
            if(user.getEmail().equals(email)){
                user.setUserName(patchUserNameRequest.getUserName());
            }
        });
        return users;
    }

    @DeleteMapping("/{email}")
    public List<User> DeleteUser(@PathVariable String email){
        users.forEach(user -> {
            if(user.getEmail().equals(email)){
                users.remove(user);
            }
        });
        return users;
    }
}
