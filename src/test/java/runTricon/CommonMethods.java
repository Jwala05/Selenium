package JLearnPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods 
{
	private WebDriver driver;

	public CommonMethods(WebDriver driver)
	{
		this.driver = driver;
	}
	public void navigateUrl(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	public void waitForElementToVisible(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void scrollDown(By scollToElement)
	{
		//WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(scollToElement)).perform();
		
	}
	public String getBrowserTitle()
	{
		return driver.getTitle();
	}
	
}
