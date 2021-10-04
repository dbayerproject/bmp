package ru.damrin.bmp.service;

import org.springframework.stereotype.Service;
import ru.damrin.bmp.model.User;


@Service
public interface UserService {
    User findByEmail(String email);



    void updateUser(User user);

    void updateUserPassword(User user, String password); 
    
    void  updateUserFirstName(User user, String firsName);
    void  updateUserLastName(User user, String lastName);
    void  updateUserTelephone(User user, Integer telephone);



}
