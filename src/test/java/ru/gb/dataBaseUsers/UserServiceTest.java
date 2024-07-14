package ru.gb.dataBaseUsers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllUsersTest() {
        User user = new User();
        user.setName("Test Name");
        user.setEmail("Test Email");
        user.setProfession("Test Profession");

        List<User> expectedUsers = Collections.singletonList(user);
        when(userRepository.findAll()).thenReturn(expectedUsers);
        List<User> actualUser = userService.getAllUsers();
        assertEquals(expectedUsers, actualUser);
    }
}
