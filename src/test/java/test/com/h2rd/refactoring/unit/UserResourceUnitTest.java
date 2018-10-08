package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.service.Impl.UserServiceImpl;
import com.h2rd.refactoring.service.UserService;
import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;
import com.h2rd.refactoring.web.UserResource;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserResourceUnitTest {

    private UserDao userDao = new UserDao();
    private UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void getUsersTest() {
        userService.setUserDao(userDao);
        User user = new User();
        user.setName("fake user");
        user.setEmail("fake@user.com");
        List<String> roles = new ArrayList<String>();
        roles.add("actor");
        user.setRoles(roles);
        userService.insertNewUser("fake user","fake@user.com",roles);

        List<User> users = userService.getUsers();
        Assert.assertEquals(users.get(0).getEmail(), user.getEmail());
        Assert.assertEquals(users.get(0).getName(), user.getName());
        Assert.assertEquals(users.get(0).getRoles(), user.getRoles());
    }
}
