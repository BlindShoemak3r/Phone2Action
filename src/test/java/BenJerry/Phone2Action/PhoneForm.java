package BenJerry.Phone2Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class PhoneForm {
	public WebDriver driver;
	public WebDriverWait wait;
	public String selectAll = Keys.chord(Keys.CONTROL, "a");
	String home = System.getProperty("user.dir");
	String exe = "\\chromedriver.exe";
	String filePath = home + exe;
	
	//declare and initialize new ChromeDriver and WebDriver wait
	@BeforeSuite
	public void initializeDrivers() {
		System.setProperty("webdriver.chrome.driver", filePath);
		driver = new ChromeDriver();
		wait = new WebDriverWait (driver, 10);
	}
	
	@Test
	public void addressOnlyTest() throws InterruptedException {
		driver.get("https://action.benjerry.com/lh92ba9");
		WebElement callButton = driver.findElement(By.xpath("//li[@class='call-nav-list-item']"));
		callButton.click();
		Thread.sleep(2000);
		
		WebElement address = driver.findElement(By.xpath("//*[@id='input-address1']"));
		WebElement findLeg = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		address.sendKeys("321");
		Thread.sleep(1000);
		address.sendKeys(Keys.DOWN);
		address.sendKeys(Keys.RETURN);
		
		findLeg.click();
		
		WebElement phoneError = driver.findElement(By.xpath("//*[@id='call-panel']/div[1]/fieldset[10]/span"));
		Assert.assertTrue(phoneError.isDisplayed());
	}
	
	@Test
	public void zipOnlyTest() {
		WebElement address = driver.findElement(By.xpath("//*[@id='input-address1']"));
		WebElement zip = driver.findElement(By.id("input-zip5"));
		WebElement findLeg = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		address.sendKeys(selectAll);
		address.sendKeys(Keys.DELETE);
		
		zip.sendKeys("78945");
		
		findLeg.click();
		
		WebElement phoneError = driver.findElement(By.xpath("//*[@id='call-panel']/div[1]/fieldset[10]/span"));
		Assert.assertTrue(phoneError.isDisplayed());
	}
	
	@Test (priority = 3)
	public void phoneOnlyTest() {
		WebElement zip = driver.findElement(By.id("input-zip5"));
		WebElement phone = driver.findElement(By.id("input-phone"));
		WebElement findLeg = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		zip.sendKeys(selectAll);
		zip.sendKeys(Keys.DELETE);
		
		phone.sendKeys("7539519713");
		findLeg.click();
		
		WebElement addressError = driver.findElement(By.xpath("//*[@id='call-panel']/div[1]/fieldset[7]/span"));
		WebElement zipError = driver.findElement(By.xpath("//*[@id='call-panel']/div[1]/fieldset[9]/span[2]"));
		
		Assert.assertTrue(addressError.isDisplayed());
		Assert.assertTrue(zipError.isDisplayed());
	}
	
	@Test (priority = 4)
	public void completeFormTest() throws InterruptedException {
		WebElement address = driver.findElement(By.xpath("//*[@id='input-address1']"));
		WebElement zip = driver.findElement(By.id("input-zip5"));
		WebElement findLeg = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		address.sendKeys("258");
		Thread.sleep(1000);
		address.sendKeys(Keys.DOWN);
		address.sendKeys(Keys.RETURN);
		
		zip.sendKeys("54987");
		
		findLeg.click();
		
		WebElement unavailable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("p2a-restricted-error")));
		
		Assert.assertTrue(unavailable.isDisplayed());
	}
	
	@AfterClass
	public void closeWindow() {
		driver.close();
	}
}
