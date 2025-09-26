package pages;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Page;

public class LoginPage {
	Page loginpage;
	Properties property;
	
	public LoginPage(Page page){
		this.loginpage = page;
		this.property = new Properties();
		loadproperties();
		
	}
	
	
	void loadproperties() {
		try {
			File file = new File("src/test/resources/properties/login.properties");
		    FileInputStream fis = new FileInputStream(file);
			property.load(fis);
			fis.close();
		}catch(Exception e) { 
			e.printStackTrace();
			throw new RuntimeException("Could not load login.properties", e);
			}
	}
	
	public void goToUrl() {
		String url =  property.getProperty("url");
		loginpage.navigate(url);
	}
	public void enterUsername(String username) {
		String usernamepath = property.getProperty("username");
		loginpage.locator(usernamepath).pressSequentially(username);	
	}
	
	public void enterPassword(String password) {
		String passwordpath =property.getProperty("password");
		loginpage.locator(passwordpath).pressSequentially(password);
	}
	
	public void clickLoginButton() {
		String loginbutton = property.getProperty("loginbutton");
		loginpage.locator(loginbutton).click();
	}
	
	public void clickForgotPassword() {
		String forgotpassword = property.getProperty("forgotPassword");
		loginpage.locator(forgotpassword).click();
	}
	
	

}
