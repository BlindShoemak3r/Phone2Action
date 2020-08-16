package BenJerry.Phone2Action;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Facebook {
	
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
	}
	
	//The purpose of these test cases are to test the Facebook text link, as well as the Facebook buttons after both types
	//of forms have been submitted
	
	@Test	//Test and verify the Facebook button after completing and email form
	public void facebookButtonTest() throws InterruptedException {
		driver.get("https://action.benjerry.com/lh92ba9");
		formCompleteEmail();
		
		WebElement facebookButton = wait.until(ExpectedConditions.
		visibilityOfElementLocated(By.xpath("//*[@id='p2a-campaign-container']/div/main/section[2]/div/div[2]/a[2]")));
		facebookButton.click();
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("facebook"));
		driver.close();
		driver.switchTo().window(tabs.get(0));
		
		driver.navigate().refresh();
	}
	
	@Test	//Test and verify the Facebook link near the bottom of the page
	public void facebookLinkTest() {
		driver.get("https://action.benjerry.com/lh92ba9");
		
		WebElement facebookLink = driver.findElement(By.xpath("//span[contains(text(),'Facebook')]"));
		facebookLink.click();
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("facebook"));
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}
	
	@Test	//Test and verify the Facebook button after completing and call form
	public void facebookPhoneButtonTest() throws InterruptedException {
		WebElement callButton = driver.findElement(By.xpath("//li[@class='call-nav-list-item']"));
		callButton.click();
		Thread.sleep(2000);
		
		formCompleteCall();
		
		WebElement facebookButton = wait.until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//*[@id='p2a-campaign-container']/div/main/section[2]/div/div[2]/a[2]")));
		facebookButton.click();
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("facebook"));
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}
	
	@AfterClass
	public void closeWindow() {
		driver.close();
	}
	
	public void formCompleteEmail() throws InterruptedException {
		WebElement titles = driver.findElement(By.id("input-title"));
		WebElement name = driver.findElement(By.name("fullName"));
		WebElement address1 = driver.findElement(By.id("input-address1"));
		WebElement phone = driver.findElement(By.id("input-phone"));
		WebElement email = driver.findElement(By.id("input-email"));
		WebElement sendEmail = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		Select s = new Select(titles);
		s.selectByIndex(i);
		i++;
		
		name.sendKeys("Geroge Testerly");
		
		address1.sendKeys("123" + i);
		i++;
		Thread.sleep(1000);
		address1.sendKeys(Keys.DOWN);
		address1.sendKeys(Keys.RETURN);
		
		phone.sendKeys("2366547890");
		
		email.sendKeys("test" + i + "@gmail.com");
		i++;
		System.out.println(email);
		
		sendEmail.click();
		
		try {
			WebElement unavailable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("p2a-restricted-error")));
			Assert.assertTrue(unavailable.isDisplayed());
		} catch (Exception e) {
			sendEmail.click();
			WebElement unavailable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("p2a-restricted-error")));
			Assert.assertTrue(unavailable.isDisplayed());
		}
	}
	
	public void formCompleteCall() throws InterruptedException {
		WebElement address1 = driver.findElement(By.id("input-address1"));
		WebElement phone = driver.findElement(By.id("input-phone"));
		WebElement findLeg = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		address1.sendKeys("321");
		Thread.sleep(1000);
		address1.sendKeys(Keys.DOWN);
		address1.sendKeys(Keys.RETURN);
		
		phone.sendKeys("1234567890");
		
		findLeg.click();
		
		try {
			WebElement unavailable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("p2a-restricted-error")));
			Assert.assertTrue(unavailable.isDisplayed());
		} catch (Exception e) {
			findLeg.click();
			WebElement unavailable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("p2a-restricted-error")));
			Assert.assertTrue(unavailable.isDisplayed());
		}
	}
}
