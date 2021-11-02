package ru.damrin.bmp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.damrin.bmp.domain.User;
import ru.damrin.bmp.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private final User user = new User("admin", "admin", "admin@admin.com", "Admin", "Adminov", "88002005555");

    @Mock
    private UserRepository userRepository;



    @InjectMocks
    private UserServiceImpl userService;


    @Test
    void testFindAllDto() {
        this.userService.findAllDto();
        verify(this.userRepository).findAll();
    }

    @Test
    void testFindById() {
        user.setId(1);
        Optional<User> res = Optional.of(user);
        when(this.userRepository.findById(anyInt())).thenReturn(res);
        User actualRes = this.userService.findById(1);
        assertEquals(1, actualRes.getId());
        assertEquals("admin", actualRes.getUsername());
        assertEquals("admin", actualRes.getPassword());
        assertEquals("admin@admin.com", actualRes.getEmail());
        assertEquals("Admin", actualRes.getFirstName());
        assertEquals("Adminov", actualRes.getLastName());
        assertEquals("88002005555", actualRes.getTelephone());
        verify(this.userRepository).findById(anyInt());

    }

    @Test
    void findBiUsername() {
        user.setId(1);
        when(this.userRepository.findByUsername(any())).thenReturn(user);
        User actualRes = this.userService.findByUsername("admin");
        assertEquals(1, actualRes.getId());
        assertEquals("admin", actualRes.getUsername());
        assertEquals("admin", actualRes.getPassword());
        assertEquals("admin@admin.com", actualRes.getEmail());
        assertEquals("Admin", actualRes.getFirstName());
        assertEquals("Adminov", actualRes.getLastName());
        assertEquals("88002005555", actualRes.getTelephone());
        verify(this.userRepository).findByUsername(any());
    }


    @Test
    void saveUser() {
        when(this.userRepository.save(any())).thenReturn(user);
        User actualRes = this.userService.saveUser(user);
        assertEquals("admin", actualRes.getUsername());
        assertEquals("admin", actualRes.getPassword());
        assertEquals("admin@admin.com", actualRes.getEmail());
        assertEquals("Admin", actualRes.getFirstName());
        assertEquals("Adminov", actualRes.getLastName());
        assertEquals("88002005555", actualRes.getTelephone());
        verify(this.userRepository).save(any());

    }

    @Test
    void deleteUser() {
        this.userService.deleteUser(1);
        verify(this.userRepository).deleteById(any());
        assertTrue(this.userRepository.findAll().isEmpty());
    }
}