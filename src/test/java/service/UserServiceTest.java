package service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.damrin.bmp.domain.User;
import ru.damrin.bmp.repository.UserRepository;
import ru.damrin.bmp.service.UserServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void findUserByIdTest() {
        User user = new User();
        user.setId(1);
        Optional<User> result = Optional.of(user);
        when(this.userRepository.findById(anyInt())).thenReturn(result);
        User anotherUser = this.userService.findById(1);
        assertEquals(1, anotherUser.getId());
        verify(this.userRepository).findById(anyInt());
    }

    @Test
    void getUserNameTest() {
        User user = new User();
        user.setUsername("username");
        user.setId(1);
        Optional <User> userOptional = Optional.of(user);
        when(this.userRepository.findById(anyInt())).thenReturn(userOptional);
        User result = this.userService.findById(1);
        assertEquals("username", result.getUsername());
    }

    @Test
    void updateUsernameTest(){
        User user = new User();
        user.setUsername("username");
        String username = user.getUsername();
        when(this.userRepository.findByName(any())).thenReturn(user);
        User result = this.userRepository.findByName(username);
        assertEquals("username", result.getUsername());
        user.setUsername("another name");
        assertEquals("another name", result.getUsername());
    }

    @Test
    void getUserPasswordTest() {
        User user = new User();
        user.setId(1);
        user.setPassword("123");
        Optional<User> optionalUser = Optional.of(user);
        when(this.userRepository.findById(anyInt())).thenReturn(optionalUser);
        User result = this.userService.findById(1);
        assertEquals("123", result.getPassword());
    }

    @Test
    void updateUserPasswordTest() {
        User user = new User();
        user.setId(1);
        user.setPassword("password");
        Optional<User> optionalUser = Optional.of(user);
        when(this.userRepository.findById(anyInt())).thenReturn(optionalUser);
        User result = this.userService.findById(1);
        assertEquals("password", result.getPassword());
        user.setPassword("another_password");
        assertEquals("another_password", result.getPassword());
    }

    @Test
    void getUserLastNameTest() {
        User user = new User();
        user.setId(1);
        user.setLastName("last_name");
        Optional<User> optionalUser = Optional.of(user);
        when(this.userRepository.findById(anyInt())).thenReturn(optionalUser);
        User result = this.userService.findById(1);
        assertEquals("last_name", result.getLastName());
    }

    @Test
    void updateUserLastNameTest() {
        User user = new User();
        user.setId(1);
        user.setLastName("last_name");
        Optional<User> optionalUser = Optional.of(user);
        when(this.userRepository.findById(anyInt())).thenReturn(optionalUser);
        User result = this.userService.findById(1);
        assertEquals("last_name", result.getLastName());
        user.setLastName("another_last_name");
        assertEquals("another_last_name", result.getLastName());
    }

    @Test
    void getUserTelephoneTest() {
        User user = new User();
        user.setId(1);
        user.setTelephone(12345);
        Optional<User> optionalUser = Optional.of(user);
        when(this.userRepository.findById(anyInt())).thenReturn(optionalUser);
        User result = this.userService.findById(1);
        assertEquals(12345, result.getTelephone());
    }

    @Test
    void updateUserTelephoneTest() {
        User user = new User();
        user.setId(1);
        user.setTelephone(12345);
        Optional<User> optionalUser = Optional.of(user);
        when(this.userRepository.findById(anyInt())).thenReturn(optionalUser);
        User result = this.userService.findById(1);
        assertEquals(12345, result.getTelephone());
        user.setTelephone(54321);
        assertEquals(54321, result.getTelephone());
    }
}
