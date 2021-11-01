
package ru.damrin.bmp.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(int id) {
        super("Could not find user with the id " + id);
    }

}