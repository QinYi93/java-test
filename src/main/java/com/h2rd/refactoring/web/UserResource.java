package com.h2rd.refactoring.web;

import com.h2rd.refactoring.service.UserService;
import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Repository
@Controller
public class UserResource{

    private UserService userService;

    private UserDao userDao;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @GET
    @Path("/add")
    public Response addUser(@QueryParam("name") String name,
                            @QueryParam("email") String email,
                            @QueryParam("role") List<String> roles) {

        User user = userService.insertNewUser(name, email, roles);
        if (user == null){
            return Response.status(400).build();
        }
        return Response.ok().entity(user).build();
    }


    @GET
    @Path("/update")
    public Response updateUser(@QueryParam("name") String name,
                               @QueryParam("email") String email,
                               @QueryParam("role") List<String> roles) {

        User user = userService.updateUser(name, email, roles);
        if (user == null){
            return Response.status(400).build();
        }
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("/delete")
    public Response deleteUser(@QueryParam("name") String name,
                               @QueryParam("email") String email,
                               @QueryParam("role") List<String> roles) {
        User user = userService.deleteUser(name, email, roles);
        if (user == null){
            return Response.status(400).build();
        }
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("/find")
    public Response getUsers() {
        List<User> users = userService.getUsers();
        if (users == null){
            return Response.status(400).build();
        }
        return Response.ok().entity(users).build();
    }

    @GET
    @Path("/search")
    public Response findUser(@QueryParam("email") String email) {

        User user = userService.findUserByEmail(email);
        if (user == null){
            return Response.status(400).build();
        }
        return Response.ok().entity(user).build();
    }
}
