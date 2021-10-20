package service;


import com.intuit.karate.junit5.Karate;

public class KarateUnitTests {

    @Karate.Test
    Karate UserTests() {
        return Karate.run("classpath:examples/user.feature").relativeTo(getClass());
    }
}
