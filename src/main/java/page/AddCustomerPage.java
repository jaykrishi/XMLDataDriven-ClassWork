package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5") WebElement ADD_CONTACT_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SUBMIT_BUTTON_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"application_ajaxrender\"]/a")
	WebElement PROFILE_CUSTOMER_ELEMENT;
	
	
	public void verifyAddContactPage(){
		waitForElement(driver, 5, ADD_CONTACT_HEADER_ELEMENT);
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), "Add Contact", "Wrong page!!!");
	}
	
	String insertedName; 
	public String insertFullName(String fullName) {
		insertedName = fullName + generateRandom(999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
		return insertedName;
	}

	public void selectCompanyDropdown(String company) {
		selectFromDropdown(COMPANY_ELEMENT, company);
	}

	public void insertEmail(String email) {
		String insertedEmail = generateRandom(999) + email;
		EMAIL_ELEMENT.sendKeys(insertedEmail);
		
	}
	
	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + generateRandom(999));
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
		
	}

	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}

	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}

	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}

	public void selectCountryFromDropdown(String country) {
		selectFromDropdown(COUNTRY_ELEMENT, country);
	}

	public void clickSubmitButton() {
		SUBMIT_BUTTON_ELEMENT.click();
	}
	
	
	
	
	
	
	
}
