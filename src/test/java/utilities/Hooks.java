package utilities;

import io.cucumber.java.*;

public class Hooks {

    @BeforeAll
    public static void setup() {
        System.out.println("Before all scenarios");
        PlaywrightFactory.init();  // single browser for all scenarios
    }

    @AfterAll
    public static void teardown() {
        System.out.println("After all scenarios");
        PlaywrightFactory.tearDown();
    }
}
