package BenJerry.Phone2Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class FormFieldValidate {
	public WebDriver driver;
	public WebDriverWait wait;
	public int i = 2;
	String home = System.getProperty("user.dir");
	String exe = "\\chromedriver.exe";
	String filePath = home + exe;
	
	
	//declare and initialize new ChromeDriver and WebDriver wait
	@BeforeSuite
	public void initializeDrivers() {
		System.setProperty("webdriver.chrome.driver", filePath);
		driver = new ChromeDriver();
		wait = new WebDriverWait (driver, 10);
		
		System.out.println(System.getProperty("user.dir"));
	}
	
	//The purpose of these test cases are to verify that all of the expected input fields are present
	
	@Test 
	public void validateAllEmailFieldsTest() {
		driver.get("https://action.benjerry.com/lh92ba9");
		
		WebElement titles = driver.findElement(By.id("input-title"));
		WebElement name = driver.findElement(By.name("fullName"));
		WebElement address1 = driver.findElement(By.id("input-address1"));
		WebElement zip = driver.findElement(By.id("input-zip5"));
		WebElement phone = driver.findElement(By.id("input-phone"));
		WebElement email = driver.findElement(By.id("input-email"));
		WebElement sendEmail = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		WebElement emailCheckBox = driver.findElement(By.id("subscribeEmail"));
		WebElement smsCheckBox = driver.findElement(By.id("subscribeSms"));
		
		Assert.assertTrue(titles.isDisplayed());
		Assert.assertTrue(name.isDisplayed());
		Assert.assertTrue(address1.isDisplayed());
		Assert.assertTrue(zip.isDisplayed());
		Assert.assertTrue(phone.isDisplayed());
		Assert.assertTrue(email.isDisplayed());
		Assert.assertTrue(sendEmail.isDisplayed());
		Assert.assertTrue(emailCheckBox.isDisplayed());
		Assert.assertTrue(smsCheckBox.isDisplayed());
	}
	
	
	@Test
	public void validateCallFieldsTest() throws InterruptedException {
		driver.get("https://action.benjerry.com/lh92ba9");
		
		WebElement callButton = driver.findElement(By.xpath("//*[@class='call-nav-list-item']"));
		callButton.click();
		Thread.sleep(1000);
		
		WebElement address = driver.findElement(By.id("input-address1"));
		WebElement zip = driver.findElement(By.id("input-zip5"));
		WebElement phone = driver.findElement(By.id("input-phone"));
		WebElement findLeg = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		WebElement emailCheckBox = driver.findElement(By.id("subscribeEmail"));
		WebElement smsCheckBox = driver.findElement(By.id("subscribeSms"));
		
		Assert.assertTrue(address.isDisplayed());
		Assert.assertTrue(zip.isDisplayed());
		Assert.assertTrue(phone.isDisplayed());
		Assert.assertTrue(findLeg.isDisplayed());
		Assert.assertTrue(emailCheckBox.isDisplayed());
		Assert.assertTrue(smsCheckBox.isDisplayed());
	}
	
	@AfterClass
	public void closeWindow() {
		driver.close();
	}
	
}
