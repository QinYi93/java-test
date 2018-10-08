package com.h2rd.refactoring.service;

import com.h2rd.refactoring.usermanagement.User;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Service
public interface UserService {
    User insertNewUser(String name ,String email, List<String> roles );
    User updateUser(String name , String email, List<String> roles);
    User deleteUser(String namel, String email, List<String> roles);
    List<User> getUsers();
    User findUserByEmail(String email);
}
