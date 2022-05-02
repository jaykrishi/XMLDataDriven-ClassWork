package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ProfilePage extends BasePage {
	WebDriver driver;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")
	WebElement SUMMARY_ON_PROFILE_ELEMENT;
	
	public void verifyProfilePage() {
		waitForElement(driver, 3, SUMMARY_ON_PROFILE_ELEMENT);
		Assert.assertEquals(SUMMARY_ON_PROFILE_ELEMENT.getText(), "Summary", "Wrong Page!!");
	}

}
