package ru.damrin.bmp.controller.restcontroller;

import com.intuit.karate.junit5.Karate;

public class KarateUnitTests {

    @Karate.Test
    Karate testCategories() {

        return Karate.run("classpath:examples/category.feature").relativeTo(getClass());
    }
}
