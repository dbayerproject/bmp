package ru.damrin.bmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.damrin.bmp.model.User;
import ru.damrin.bmp.repository.UserRepository;

@Service
public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return repository.findByEmail(s);
    }

    @Override
    public void updateUser(User user) {
        repository.save(user);
    }

    @Override
    public void updateUserPassword(User user, String newPassword) {
        user.setPassword(newPassword);
        repository.save(user);
    }

    @Override
    public void updateUserFirstName(User user, String newFirstName) {
        user.setFirstName(newFirstName);
        repository.save(user);
    }

    @Override
    public void updateUserLastName(User user, String newLastName) {
        user.setLastName(newLastName);
        repository.save(user);
    }

    @Override
    public void updateUserTelephone(User user, Integer newTelephoneNumber) {
        user.setTelephone(newTelephoneNumber);
        repository.save(user);
    }
}
