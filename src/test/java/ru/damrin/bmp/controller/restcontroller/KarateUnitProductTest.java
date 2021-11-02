package ru.damrin.bmp.controller.restcontroller;

import com.intuit.karate.junit5.Karate;

public class KarateUnitProductTest {

    @Karate.Test
    Karate testCategories() {
        return Karate.run("classpath:examples/productTest.feature").relativeTo(getClass());
    }
}
