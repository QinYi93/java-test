package test.com.h2rd.refactoring.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import com.h2rd.refactoring.service.UserService;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.web.UserResource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserIntegrationTest {

    private ApplicationContext context;
    private UserResource userResource;

    @Before
    public void init () {
         context = new ClassPathXmlApplicationContext("application-config.xml");
    }

	@Test
	public void createUserTest() {

        userResource = (UserResource) context.getBean("userResource");
		User integration = new User();
        integration.setName("integration");
        integration.setEmail("initial@integration.com");
        integration.setRoles(new ArrayList<String>());

        List<String> roles = Arrays.asList("actor");
        integration.setRoles(roles);

        Response response = userResource.addUser(integration.getName(), integration.getEmail(), integration.getRoles());
        Assert.assertEquals(200, response.getStatus());
	}

	@Test
	public void updateUserTest() {
        userResource = (UserResource) context.getBean("userResource");

        User updated = new User();
        updated.setName("integration");
        updated.setEmail("updated@integration.com");
        updated.setRoles(Arrays.asList("actor","manager"));

		Response response = userResource.addUser(updated.getName(),updated.getEmail(),updated.getRoles());
        Assert.assertEquals(200, response.getStatus());

        
        Response response2 = userResource.updateUser(updated.getName(), updated.getEmail(), updated.getRoles());
        Assert.assertEquals(200, response.getStatus());
	}
}
