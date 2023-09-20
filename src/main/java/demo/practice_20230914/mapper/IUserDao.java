package demo.practice_20230914.mapper;

import demo.practice_20230914.models.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IUserDao {
    @Select("select * from users;")
    List<User> getUsers();
    @Select("select * from users where email = #{email};")
    User getUserByEmail(String email);
    @Insert("insert into users(email, username, password) value (#{email}, #{username}, #{password})")
    void createUser(CreateUser user);
    @Update("UPDATE users SET username = #{username}, password = #{password} WHERE email = #{email}")
    void putUser(PutUser user);
    @Update("UPDATE users SET password = #{password} WHERE email = #{email}")
    void patchUser(PatchUser user);
    @Delete("DELETE FROM users WHERE email = #{email}")
    void deleteUser(String email);
}


