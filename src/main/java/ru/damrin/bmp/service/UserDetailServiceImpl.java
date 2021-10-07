package ru.damrin.bmp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.damrin.bmp.domain.User;
import ru.damrin.bmp.repository.UserRepository;


public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) {

        User user = userRepository.findByUsername(s);

        if(user==null) {
            try {
                throw new Exception("Username not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
