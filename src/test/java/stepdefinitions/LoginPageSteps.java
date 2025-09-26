package stepdefinitions;

import com.microsoft.playwright.Playwright;


import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.PlaywrightFactory;


public class LoginPageSteps {
	
	@Given("user navigates to application")
	public void user_navigates_to_application() {
		System.out.println("Background all");
	    LoginPage lp = new LoginPage(PlaywrightFactory.getPage());
	    lp.goToUrl();
	}
	
	

	@When("User enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String username, String password) {
		System.out.println("Scenario User enters valid username {string} and password {string}  all");
		    LoginPage lp = new LoginPage(PlaywrightFactory.getPage());
		    lp.enterUsername(username);
		    lp.enterPassword(password);
		    lp.clickLoginButton();	   
		}
	
	
	@When("User clicks on forgot Password link")
	public void user_clicks_on_forgot_password_link()  {
		System.out.println("scenario 2 userclick ");
		LoginPage lp = new LoginPage(PlaywrightFactory.getPage());
	    lp.goToUrl();
	    lp.clickForgotPassword();
	}

}
