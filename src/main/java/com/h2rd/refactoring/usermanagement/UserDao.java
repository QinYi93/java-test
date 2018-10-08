package com.h2rd.refactoring.usermanagement;

import java.util.ArrayList;

public class UserDao {

    public ArrayList<User> users = new ArrayList<User>();

    public static UserDao userDao;

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public void saveUser(User user) {
        if (users == null) {
            users = new ArrayList<User>();
        }

        users.add(user);
    }

    public ArrayList<User> getUsers() {
        try {
            return users;
        } catch (Throwable e) {
            System.out.println("error");
            return null;
        }
    }

    public void deleteUser(User userToDelete) {
        try {
            for (User user : users) {
                if (user.getEmail().equals(userToDelete.getEmail())) {
                    users.remove(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User userToUpdate) {
        try {
            for (User user : users) {
                if (user.getEmail().equals(userToUpdate.getEmail())) {
                    user.setName(userToUpdate.getName());
                    user.setRoles(userToUpdate.getRoles());
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public User findUserByName(String name) {
        try {
            for (User user : users) {
                if (user.getName().equals(name)) {
                    return user;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User findUserByEmail(String email) {
        try {
            for (User user : users) {
                if (user.getEmail().equals(email)) {
                    return user;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
