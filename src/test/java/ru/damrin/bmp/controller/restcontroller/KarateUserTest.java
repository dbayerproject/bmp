package ru.damrin.bmp.controller.restcontroller;

import com.intuit.karate.junit5.Karate;

public class KarateUserTest {
    @Karate.Test
    Karate testCategories() {

        return Karate.run("classpath:examples/user.feature").relativeTo(getClass());
    }
}
