package demo.practice_20230914.controllers;

import demo.practice_20230914.models.DeleteUserRequest;
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
        System.out.println("merge test2");
        System.out.println("test2");
        return users;
    }

    @PostMapping
    public List<User> AddUser(@RequestBody User user){
        users.add(user);
        return users;
    }

    @PutMapping("/{email}")
    public List<User> PutUser(@PathVariable String email, @RequestBody PutUserRequest putUserRequest){
        users.forEach(user -> {
            if(user.getEmail().equals(email)){
                user.setUserName(putUserRequest.getUserName());
                user.setJob(putUserRequest.getJob());
            }
        });
        return users;
    }

    @PatchMapping("/{email}")
    public List<User> PatchUserName(@PathVariable String email, @RequestBody PatchUserNameRequest patchUserNameRequest){
        users.forEach(user -> {
            if(user.getEmail().equals(email)){
                user.setUserName(patchUserNameRequest.getUserName());
            }
        });
        return users;
    }

    @DeleteMapping
    public List<User> DeleteUser(@RequestBody DeleteUserRequest deleteUserRequest){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User element = iterator.next();
            if(element.getEmail().equals(deleteUserRequest.getEmail())){
                iterator.remove();
            }
        }
        return users;
    }
}
