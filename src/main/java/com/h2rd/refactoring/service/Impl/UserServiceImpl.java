package com.h2rd.refactoring.service.Impl;

import com.h2rd.refactoring.service.UserService;
import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    public UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User insertNewUser(String name, String email, List<String> roles) {
        if (userDao.findUserByEmail(email) == null && roles.size() >= 1){
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setRoles(roles);
            userDao.saveUser(user);
            return user;
        } else {
            return null;
        }

    }

    public User updateUser(String name, String email, List<String> roles) {

        User user = userDao.findUserByEmail(email);
        if (user == null || roles.size() < 1 ){
            return null;
        } else {
            user.setName(name);
            user.setEmail(email);
            user.setRoles(roles);
            userDao.updateUser(user);
            return user;
        }
    }

    public User deleteUser(String namel, String email, List<String> roles) {
        User user = userDao.findUserByEmail(email);
        if (user == null){
            return null;
        } else {
            userDao.deleteUser(user);
            return user;
        }
    }

    public List<User> getUsers() {
        List<User> users = userDao.getUsers();
        if (users == null){
            return null;
        }else {
            return users;
        }
    }

    public User findUserByEmail(String email) {
        User user = userDao.findUserByEmail(email);
        if (user == null){
            return null;
        }else {
            return user;
        }
    }
}
