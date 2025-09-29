package stepdefinitions;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.PlaywrightFactory;


public class LoginPageSteps {
	Page firstpage;
	Page secondpage;
	
	@When("User enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String username, String password) {
		System.out.println("Scenario User enters valid username {string} and password {string}  all");
		firstpage = PlaywrightFactory.getPage();
	    LoginPage lp = new LoginPage(firstpage);
	    System.out.println("lp object");
	    lp.goToUrl();
	    System.out.println("navigate to url");
	    lp.enterUsername(username);
	    System.out.println("enter username");
	    lp.enterPassword(password);
	    System.out.println("entered password");
	    lp.clickLoginButton();	 
	    
	}


}
