package demo.practice_20230914.dao;

import demo.practice_20230914.models.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserDao {

    List<User> getUsers();
    User getUserByEmail(String email);
    void createUser(CreateUser user);
    void putUser(PutUser user);
    void patchUser(PatchUser user);
    void deleteUser(String email);
}


