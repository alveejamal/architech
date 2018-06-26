package com.architech.demo.service;

import com.architech.demo.Dao.UserDao;
import com.architech.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String createUser(User user) {
        Iterable<User> userList = userDao.findAll();

        for (User usr : userList) {
            if (usr.getUsername().equals(user.getUsername())) {
                return "user with same id exists already";
            }
        }
        userDao.save(user);
        return "user created";
    }
}
