package utilities;

import io.cucumber.java.*;

public class Hooks {
	
	@BeforeAll
	public static void setup() {
		System.out.println("Beforeall");
		PlaywrightFactory.init();
	}
	
//	@AfterAll
//	public static void teardown() {
//		System.out.println("After All");
//		PlaywrightFactory PF = new PlaywrightFactory();
//		PF.tearDown();
//		
//	}
//	@Before
//	public static void beforeScenario() {
//		//System.out.println("Before");
//	}
//	
//	@After
//	public static void afterScenario() {
//		//System.out.println("After");
//		
//	}

}
