package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.BrowserFactory;

public class ListCustomersPage extends BasePage{
	WebDriver driver;
	//findElement
	@FindBy(how = How.XPATH, using = "//div[@class='panel-body']/a[contains(text(),'Add Customer')]")
	WebElement LIST_CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='foo_filter']")
	WebElement SEARCH_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary btn-xs']")
	WebElement SEARCH_ICON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]")
	WebElement ADD_CUSTOMER_ON_LIST_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]")
	WebElement SEARCH_ON_LIST_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using="//button[@class='btn btn-primary']") 
	WebElement DELETE_BUTTON;
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary']")
	WebElement IMPORT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-info']")
	WebElement EXPORT_ELEMENT;
	
	public ListCustomersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Initializes WebElements declared in this class using driver instance
	}
	
	// Methods/Actions on your webelements
	
		public void verifyListCustomersPage(){
			waitForElement(driver, 5, LIST_CUSTOMER_HEADER_ELEMENT);
			Assert.assertEquals(LIST_CUSTOMER_HEADER_ELEMENT.getText(), "Add Customer", "Wrong page!!!");
		}
		
		public void searchName(String name) {
			
			SEARCH_ELEMENT.sendKeys(name);
		}
		
		public void searchIcon() {
			waitForElement(driver,5,SEARCH_ICON_ELEMENT);
			SEARCH_ICON_ELEMENT.click();
		}
		
		
		
				
		public void clickAddCustomerOnListCusomer() {
			ADD_CUSTOMER_ON_LIST_CUSTOMER_ELEMENT.click();
		}
		public void insertSearchBarOnListCusomer(String insertedName) {
			SEARCH_ON_LIST_CUSTOMER_ELEMENT.sendKeys(insertedName);
		}
		
		public void verifyEnteredNameOnSearchAndProfile(String insertedName) {
			for(int i = 1; i <= 5; i++) {
				String searchedName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
				if(searchedName.contains(insertedName)) {
					System.out.println("Inserted name exist.");
					driver.findElement(By.xpath(before_xpath + i + after_xpath_profile)).click();
					break;
				}
				
			}
		}
		
	
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";
		String after_xpath_delete = "]/td[3]/following-sibling::td[4]/a[2]";
		String after_xpath_profile = "]/td[3]/following-sibling::td[4]/a";

		public void verifyEnteredNameAndDelete(String insertedName) {
			// TODO Auto-generated method stub
			for (int i = 1; i <= 10; i++) {
				String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//				String name = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText();
//				System.out.println(name);
				if(name.contains(insertedName)) {
					System.out.println("Inserted name exist.");
					driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
					DELETE_BUTTON.click();
					
				}
			}
		}

		


}
