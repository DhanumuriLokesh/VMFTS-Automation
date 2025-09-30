package stepdefinitions;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.PlaywrightFactory;

public class LoginPageSteps {
	
	//Scenario
	@When("User navigates to url and enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {

		 Page firstTab = PlaywrightFactory.getPage();
		 System.out.println(firstTab);
		 LoginPage lp = new LoginPage(firstTab);
	     lp.goToUrl();
	     lp.enterUsername(username);
         lp.enterPassword(password);
         lp.clickLoginButton();
	   
	}
	
	
	//Scenario 
	@When("To Check Forgot password link")
	public void user_clicks_forgot_password() {

		Page secondTab = PlaywrightFactory.getPage();
		System.out.println(secondTab);
		LoginPage lp = new LoginPage(secondTab);
	    lp.goToUrl();
        lp.clickForgotPassword();
	    
	}
	
	//Scenario
	@When("User enter invalidusername {string} and invalidpassword {string}")
	public void user_enter_invalidusername_and_invalidpassword(String username, String password) {
		Page thirdTab = PlaywrightFactory.getPage();
		System.out.println(thirdTab);
		LoginPage lp = new LoginPage(thirdTab);
	    lp.goToUrl();
	    lp.enterUsername(username);
        lp.enterPassword(password);
        lp.clickLoginButton();
        
	}
	
	

}
