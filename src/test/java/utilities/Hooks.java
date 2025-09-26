package utilities;

import io.cucumber.java.*;

public class Hooks {
	
	@Before
	public static void setup() {
		System.out.println("Before all");
		
	}
	
	@After
	public static void teardown() {
		System.out.println("After all");
		
	}

}
