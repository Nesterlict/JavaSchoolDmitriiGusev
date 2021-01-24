import ecare.MVC.entities.User;
import ecare.config.PersistenceJPAConfig;
import ecare.services.api.GenericService;
import ecare.services.api.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class UserTests {

    @Autowired
    private UserService userService;
    //private static ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
    //private static UserService userService = (UserService) context.getBean("userService");

    private static User user1, user2, user3;
    @BeforeClass
    public void beforeClass(){
        user1 = new User();
    }

    @Test
    @Transactional
    public void ultimateTest(){
        Assert.assertEquals(userService.getUserByEMAil("NAsales@tesla.com").getUserId(),1);
    }


}
