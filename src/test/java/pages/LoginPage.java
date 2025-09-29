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
			System.out.println("properties loaded");
			fis.close();
		}catch(Exception e) { 
			e.printStackTrace();
			throw new RuntimeException("Could not load login.properties", e);
			}
	}
	
	public void goToUrl() {
		String url =  property.getProperty("url");
		loginpage.navigate(url);
		System.out.println("url passed");
	}
	public void enterUsername(String username) {
		String usernamepath = property.getProperty("username");
		loginpage.locator(usernamepath).pressSequentially(username);	
		System.out.println("enter username");
	}
	
	public void enterPassword(String password) {
		String passwordpath =property.getProperty("password");
		loginpage.locator(passwordpath).pressSequentially(password);
		System.out.println("clicked enter password");
	}
	
	public void clickLoginButton() {
		String loginbutton = property.getProperty("loginbutton");
		loginpage.locator(loginbutton).click();
		System.out.println("clicked login button ");
	}
	
	public void clickForgotPassword() {
		String forgotpassword = property.getProperty("forgotPassword");
		loginpage.locator(forgotpassword).click();
		System.out.println("clicked forgot password");
	}
	
	

}
