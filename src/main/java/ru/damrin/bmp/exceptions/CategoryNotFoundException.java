package ru.damrin.bmp.exceptions;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(int id) {
        super("Could not find category with the id " + id);
    }
}
