package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomersPage;
import page.LoginPage;
import page.ProfilePage;
import util.BrowserFactory;

public class ListCustomersTest {
	WebDriver driver;
	@Test
	@Parameters({"UserName", "Password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip",  "Country"})
	public void validUserShouldBeAbleToAddCustomerFromListCustomer(String userName, String password, String fullName, String company, String email, String phone, String address, String city, String state, String zip, String country) {
		driver = BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(userName);
		login.insertPassword(password);
		login.clickSininButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickListCustomerMenuButton();
		
		ListCustomersPage listcustomersPage = PageFactory.initElements(driver,ListCustomersPage.class);
		listcustomersPage.clickAddCustomerOnListCusomer();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddContactPage();
		String insertedName = addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropdown(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.selectCountryFromDropdown(country);
		addCustomerPage.insertZip(zip);
		addCustomerPage.clickSubmitButton();
		
		ProfilePage profilePage = PageFactory.initElements(driver,ProfilePage.class);
		profilePage.verifyProfilePage();
		dashboardPage.clickListCustomerMenuButton();
		
		listcustomersPage.insertSearchBarOnListCusomer(insertedName);
		listcustomersPage.verifyEnteredNameOnSearchAndProfile(insertedName);
		
		
	}

}
