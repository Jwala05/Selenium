package JLearnPOM;
import org.openqa.selenium.WebDriver;
public class ContactUsPage 
{
	private WebDriver driver;
	private CommonMethods commonMethods;
	public ContactUsPage(WebDriver driver,CommonMethods commonMethods)
	{
		this.driver = driver;
		this.commonMethods = commonMethods;
	}
	public void clickContactUs()
	{
		driver.findElement(Locators.contactUs).click();				
	}
	public void waitForSubmitButton()
	{
		commonMethods.waitForElementToVisible(Locators.submitBtn);
	}
	public void scrollToSubmit()
	{
		commonMethods.scrollDown(Locators.submitBtn);
	}
	public boolean contactUsEnable()
	{
		return driver.findElement(Locators.submitBtn).isEnabled();
	}
	

}
