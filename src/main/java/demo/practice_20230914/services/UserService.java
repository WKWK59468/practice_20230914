package demo.practice_20230914.services;

import demo.practice_20230914.dao.IUserDao;
import demo.practice_20230914.models.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService{
    private final IUserDao userDao;

    @Autowired
    public UserService(IUserDao userDao){
        this.userDao = userDao;
    }
    public List<User> getUsers() {
        return userDao.getUsers();
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
