package stepdefinitions;

import com.microsoft.playwright.Page;

import io.cucumber.java.en.*;
import pages.FundPage;
import pages.LoginPage;
import utilities.PlaywrightFactory;

public class FundPageSteps {
	
	Page firstTab;
	Page secondTab ;
	
	//Scenario : Positive FLow
	@When("State Maker Login {string} and {string}")
	public void stateMakerLogin(String username, String password) {
	 	firstTab = PlaywrightFactory.getPage();
		LoginPage lp = new LoginPage(firstTab);
	    lp.goToUrl();
	    lp.enterUsername(username);
	    lp.enterPassword(password);
	    lp.clickLoginButton();
	}
	
	@And("Create a Fund and send to checker")
	public void createFund() {
		FundPage fp = new FundPage(firstTab);
		fp.clickFund();
		fp.clickFundCreate();
		fp.enterProjectName();
		fp.enterFundNumber();
		fp.selectFundIssueDate();
		fp.selectProjectCompletionDate();
		fp.selectScheme();
		fp.selectFY();
		fp.scrollDwon();
		fp.selectExpenseCode();
		fp.enterAmount();
		fp.selectDesignation();
		fp.selectEmployee();
		fp.noteFile();
		fp.saveButton();
	}
	
	@And("State checker Login {string} and {string}")
	public void stateCheckerLogin(String username, String password) {
		secondTab = PlaywrightFactory.getPage();
		LoginPage lp = new LoginPage(secondTab);
	    lp.goToUrl();
	    lp.enterUsername(username);
	    lp.enterPassword(password);
	    lp.clickLoginButton();
	}
	
	@And("Approve the fund id")
	public void approveFundId() {
		FundPage fp = new FundPage(secondTab);
		fp.clickFund();
		fp.clickCreatedFund();
		fp.selectApporveRadioButton();
		fp.clickApprove();
	}
	
	
    @And("Reject the fund id")
    public void rejectFundId() {
    	FundPage fp = new FundPage(secondTab);
		fp.clickFund();
		fp.clickCreatedFund();
		fp.selectRejectRadioButton();
		fp.clickOkToReject();
		fp.clickApprove();
        
    }
}
