package pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FundPage {
	Page fundPage;
	Properties property;
	
	public FundPage(Page page) {
		this.fundPage = page;
		this.property = new Properties();
		loadproperties();
	}
	
	public void loadproperties() {
		try {
			File file = new File("src/test/resources/properties/fund.properties");
			FileInputStream fis = new FileInputStream(file);
			property.load(fis);
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Could not load login.properties", e);
		}
	}
	
	public void clickFund() {
		String fund = property.getProperty("fund");
		fundPage.locator(fund).click();
	}
	
	public void clickFundCreate() {
		String fundCreateButton = property.getProperty("fundcreatebutton");
		fundPage.locator(fundCreateButton).click();
	}
	
	public void clickCreatedFund() {
		String fundid = property.getProperty("Fund");
		fundPage.getByText(fundid).click();
	}
	
	public void enterProjectName() {
		String projectName = property.getProperty("projectName");
		String project = property.getProperty("project");
		fundPage.locator(projectName).pressSequentially(project);
	}
	
	public void enterFundNumber() {

		String fundNumber = property.getProperty("fundNumber");
		String Fund = property.getProperty("Fund");
		fundPage.locator(fundNumber).pressSequentially(Fund);
	}
	
	public void selectFundIssueDate() {
		 fundPage.locator("mat-form-field").filter(new Locator.FilterOptions().setHasText("Fund Issue Date *")).getByLabel("Open calendar").click();
		 String FundIssueDate = property.getProperty("FundIssueDate");
		 fundPage.getByLabel(FundIssueDate).click(); 
	}
	
	public void selectProjectCompletionDate() {
		fundPage.locator("mat-form-field").filter(new Locator.FilterOptions().setHasText("Project Completion Date *")).getByLabel("Open calendar").click();
		fundPage.getByLabel("Next month").click();
		fundPage.getByLabel("Next month").click();
		String ProjectCompletionDate = property.getProperty("ProjectCompletionDate");
		fundPage.getByLabel(ProjectCompletionDate).click();
	}
	
	public void selectScheme() {

		String selectScheme = property.getProperty("selectScheme");
		String schemeOption = property.getProperty("schemeOption");
		fundPage.locator(selectScheme).selectOption(schemeOption);
	}
	
	public void selectFY() {
		String FYoption = property.getProperty("selectFY");
		String FY = property.getProperty("FY");
		fundPage.locator(FYoption).selectOption(FY);
	}
	
	public void selectExpenseCode() {

		String expenseCode = property.getProperty("expenseCode");
		String expenseCodeOption = property.getProperty("expenseCodeOption");
		fundPage.locator(expenseCode).selectOption(expenseCodeOption);
	}
	
	public void enterAmount() {
		String enterAmount = property.getProperty("amount");
		String AmountAssign = property.getProperty("AmountAssign");
		fundPage.locator(enterAmount).pressSequentially(AmountAssign);
	}
	
	public void selectDesignation() {
		String selectDesignation = property.getProperty("selectDesignation");
		String MakerDesignation = property.getProperty("MakerDesignation");
		fundPage.locator(selectDesignation).click(); //.pressSequentially(MakerDesignation);
		fundPage.getByText(MakerDesignation).click();
	}
 
	public void selectEmployee() {
		String selectEmployee = property.getProperty("selectEmployee");
		String Employee =property.getProperty("Employee");
		fundPage.locator(selectEmployee).click(); // .pressSequentially(Employee);
		fundPage.getByText(Employee).click();
	}
	
	public void noteFile() {
		String noteFile = property.getProperty("noteFile");
		String notefiletext = property.getProperty("notefiletext");
		fundPage.locator(noteFile).pressSequentially(notefiletext);
		
	}
	
	public void resetButton() {}
	
	public void saveButton() {
		String saveButton = property.getProperty("save");
		fundPage.locator(saveButton).click();
	}
	
	
	
	public void selectApporveRadioButton() {
		String apporveRadioButton = property.getProperty("apporveRadioButton");
		fundPage.locator(apporveRadioButton).click();
	}
	
	public void selectRejectRadioButton() {
		String rejectRadioButton = property.getProperty("rejectRadioButton");
		fundPage.locator(rejectRadioButton).click();
	}
	
	public void clickOkToReject() {
		String rejectOkButton = property.getProperty("rejectOkButton");
		fundPage.locator(rejectOkButton).click();
	}

	
	public void clickApprove() {
		String apporveButton = property.getProperty("apporveButton");
		fundPage.locator(apporveButton).click();
	}
	
	public void scrollDwon() {
		fundPage.evaluate("window.scrollTo(0, document.body.scrollHeight)");
		fundPage.waitForTimeout(1000);
	}
	
}
