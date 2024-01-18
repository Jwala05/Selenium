package JLearnPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest 
{
	WebDriver driver;
	//private - Package level access; protected - class level access; public - project level access
	private ContactUsPage contactUsPage;
	private CommonMethods commonMethods;
	private IndustryPage industryPage;
	@BeforeClass
	public void setUp()
	{
		driver = new ChromeDriver();
		commonMethods = new CommonMethods(driver);
		contactUsPage = new ContactUsPage(driver, commonMethods);
		industryPage = new IndustryPage(driver,commonMethods);
		commonMethods.navigateUrl(TestData.url);
	}
	
	@Test
	public void contactUsTest()
	{
		contactUsPage.clickContactUs();
		commonMethods.waitForElementToVisible(Locators.submitBtn);
		commonMethods.scrollDown(Locators.submitBtn);
		boolean isContactEnable = contactUsPage.contactUsEnable();
		Assert.assertTrue(isContactEnable,"The submit button in contact us page is not enabled");		
	}
	@Test
	public void industryTest()
	{
		commonMethods.waitForElementToVisible(Locators.industryLink);
		industryPage.clickIndustry();
		String industryAct = commonMethods.getBrowserTitle();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(industryAct);
		Assert.assertTrue(industryAct.contains(TestData.industry),"The industry page is not opened correctly");
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
