package ru.gb.dataBaseUsers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void getAllUsersIntegrationTest() {
        User user = new User();
        user.setName("Integration Test Name");
        user.setEmail("Integration Test Email");
        user.setProfession("Integration Test Profession");

        userRepository.save(user);

        List<User> users = userService.getAllUsers();
        assertTrue(users.size() > 0);
        assertEquals(user.getName(), users.get(0).getName());
    }
}
