package demo.practice_20230914.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.practice_20230914.dao.IUserDao;
import demo.practice_20230914.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserService{
    private final IUserDao userDao;

    private final StringRedisTemplate stringRedisTemplate;

    private final ObjectMapper objectMapper;

    @Autowired
    public UserService(IUserDao userDao, StringRedisTemplate stringRedisTemplate, ObjectMapper objectMapper){
        this.userDao = userDao;
        this.stringRedisTemplate = stringRedisTemplate;
        this.objectMapper = objectMapper;
    }
    public List<User> getUsers() throws JsonProcessingException {
        List<User> users;

        String usersObj= stringRedisTemplate.opsForValue().get("getUsers");

        if (usersObj != null) {
            // 如果在 Redis 中找到了用户列表的 JSON 字符串，解析为 List<User>
            users = objectMapper.readValue(usersObj, new TypeReference<List<User>>() {});
            System.out.println(stringRedisTemplate.getExpire("getUsers"));
        } else {
            users = userDao.getUsers();
            if (!users.isEmpty()) {
                // 将用户列表序列化为 JSON 字符串并存入 Redis
                usersObj = objectMapper.writeValueAsString(users);
                stringRedisTemplate.opsForValue().set("getUsers", usersObj);
                stringRedisTemplate.expire("getUsers", 10, TimeUnit.SECONDS);
            }
        }

        return users;
    }

    public User getUserByEmail(String email)  throws JsonProcessingException {
        User user;

        String userObj = stringRedisTemplate.opsForValue().get(email);

        if (userObj != null) {
            user = objectMapper.readValue(userObj,User.class);
            System.out.println(stringRedisTemplate.getExpire(email));
        } else {
            user = userDao.getUserByEmail(email);
            if (user != null) {
                String json = objectMapper.writeValueAsString(user);
                stringRedisTemplate.opsForValue().set(email, json);
                stringRedisTemplate.expire(email,10,TimeUnit.SECONDS);
            }
        }

        return user;
    }

    public void createUser(CreateUser createUser){
        userDao.createUser(createUser);
    }

    public void putUser(PutUser putUser){
        userDao.putUser(putUser);
    }

    public void patchUser(PatchUser patchUser){
        userDao.patchUser(patchUser);
    }

    public void deleteUser(DeleteUser deleteUser){
        userDao.deleteUser(deleteUser.getEmail());
    }
}
