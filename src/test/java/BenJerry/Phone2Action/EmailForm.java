package BenJerry.Phone2Action;

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


public class EmailForm {
	public WebDriver driver;
	public WebDriverWait wait;
	public String selectAll = Keys.chord(Keys.CONTROL, "a");
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
	
	//The purpose of these test cases are to go through the email form, with negative scenarios first, concluded with a
	//positive test to successfully submit the form
	
	@Test (priority = 1)	//test only sending a title & verify all other error messages display upon submission
	public void titleOnlyTest() {
		driver.get("https://action.benjerry.com/lh92ba9");
		
		WebElement titles = driver.findElement(By.id("input-title"));
		WebElement sendEmail = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		Select s = new Select(titles);
		s.selectByIndex(i);
		i++;
		
		sendEmail.click();
		
		WebElement nameError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[4]/span"));
		WebElement addressError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[7]/span"));
		WebElement zipError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[9]/span[2]"));
		WebElement phoneError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[10]/span"));
		WebElement emailError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[11]/span"));
		
		Assert.assertTrue(nameError.isDisplayed());
		Assert.assertTrue(addressError.isDisplayed());
		Assert.assertTrue(zipError.isDisplayed());
		Assert.assertTrue(phoneError.isDisplayed());
		Assert.assertTrue(emailError.isDisplayed());
	}
	
	@Test (priority = 2)	//test only sending a name & verify all other error messages display upon submission
	public void nameOnlyTest () {
		WebElement titles = driver.findElement(By.id("input-title"));
		WebElement name = driver.findElement(By.name("fullName"));
		WebElement sendEmail = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		Select s = new Select(titles);
		s.selectByIndex(0);
		
		name.sendKeys("Geroge Testerman");
		
		sendEmail.click();
		
		WebElement titleError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[3]/span"));
		WebElement addressError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[7]/span"));
		WebElement zipError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[9]/span[2]"));
		WebElement phoneError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[10]/span"));
		WebElement emailError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[11]/span"));
		
		Assert.assertTrue(titleError.isDisplayed());
		Assert.assertTrue(addressError.isDisplayed());
		Assert.assertTrue(zipError.isDisplayed());
		Assert.assertTrue(phoneError.isDisplayed());
		Assert.assertTrue(emailError.isDisplayed());
	}
	
	@Test (priority = 3)	//test only sending an address & verify all other error messages display upon submission
	public void addressOnlyTest () throws InterruptedException {
		WebElement name = driver.findElement(By.name("fullName"));
		WebElement address1 = driver.findElement(By.id("input-address1"));
		WebElement sendEmail = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		name.sendKeys(selectAll);
		name.sendKeys(Keys.DELETE);
		
		address1.sendKeys("759");
		Thread.sleep(1000);
		address1.sendKeys(Keys.DOWN);
		address1.sendKeys(Keys.RETURN);
		
		sendEmail.click();
		
		WebElement titleError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[3]/span"));
		WebElement nameError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[4]/span"));
		WebElement phoneError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[10]/span"));
		WebElement emailError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[11]/span"));
		
		Assert.assertTrue(titleError.isDisplayed());
		Assert.assertTrue(nameError.isDisplayed());
		Assert.assertTrue(phoneError.isDisplayed());
		Assert.assertTrue(emailError.isDisplayed());
	}
	
	@Test (priority = 4)	//test only sending a zip code & verify all other error messages display upon submission
	public void zipOnlyTest() {
		WebElement address1 = driver.findElement(By.id("input-address1"));
		WebElement sendEmail = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		address1.sendKeys(selectAll);
		address1.sendKeys(Keys.DELETE);
		
		sendEmail.click();
		
		WebElement titleError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[3]/span"));
		WebElement nameError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[4]/span"));
		WebElement addressError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[7]/span"));
		WebElement phoneError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[10]/span"));
		WebElement emailError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[11]/span"));
		
		Assert.assertTrue(titleError.isDisplayed());
		Assert.assertTrue(nameError.isDisplayed());
		Assert.assertTrue(addressError.isDisplayed());
		Assert.assertTrue(phoneError.isDisplayed());
		Assert.assertTrue(emailError.isDisplayed());
	}
	
	@Test (priority = 5)	//test only sending a phone number & verify all other error messages display upon submission
	public void phoneOnlyTest() {
		WebElement zip = driver.findElement(By.id("input-zip5"));
		WebElement phone = driver.findElement(By.id("input-phone"));
		WebElement sendEmail = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		zip.sendKeys(selectAll);
		zip.sendKeys(Keys.DELETE);
		
		phone.sendKeys("7539519713");
		
		sendEmail.click();
		
		WebElement titleError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[3]/span"));
		WebElement nameError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[4]/span"));
		WebElement addressError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[7]/span"));
		WebElement zipError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[9]/span[2]"));
		WebElement emailError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[11]/span"));
		
		Assert.assertTrue(titleError.isDisplayed());
		Assert.assertTrue(nameError.isDisplayed());
		Assert.assertTrue(addressError.isDisplayed());
		Assert.assertTrue(zipError.isDisplayed());
		Assert.assertTrue(emailError.isDisplayed());
	}
	
	@Test (priority = 6)	//test only sending an email address & verify all other error messages display upon submission
	public void emailOnlyTest() {
		WebElement phone = driver.findElement(By.id("input-phone"));
		WebElement email = driver.findElement(By.id("input-email"));
		WebElement sendEmail = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		phone.sendKeys(selectAll);
		phone.sendKeys(Keys.DELETE);
		
		email.sendKeys("test" + i + "@gmail.com");
		
		sendEmail.click();
		
		WebElement titleError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[3]/span"));
		WebElement nameError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[4]/span"));
		WebElement addressError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[7]/span"));
		WebElement zipError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[9]/span[2]"));
		WebElement phoneError = driver.findElement(By.xpath("//*[@id='email-panel']/div[1]/fieldset[10]/span"));
		
		Assert.assertTrue(titleError.isDisplayed());
		Assert.assertTrue(nameError.isDisplayed());
		Assert.assertTrue(addressError.isDisplayed());
		Assert.assertTrue(zipError.isDisplayed());
		Assert.assertTrue(phoneError.isDisplayed());
	}
	
	@Test (priority = 7) //test sending a completed form and verifying the campaign unavailable message is displayed
	public void fullFormCompleteTest() throws InterruptedException {
		driver.navigate().refresh();
		
		WebElement titles = driver.findElement(By.id("input-title"));
		WebElement name = driver.findElement(By.name("fullName"));
		WebElement address1 = driver.findElement(By.id("input-address1"));
		WebElement phone = driver.findElement(By.id("input-phone"));
		WebElement email = driver.findElement(By.id("input-email"));
		WebElement sendEmail = driver.findElement(By.xpath("//fieldset[@class='p2a-fieldset-submit']/button"));
		
		Select s = new Select(titles);
		s.selectByValue("Senator");
		
		name.sendKeys("George Testerman");
		
		address1.sendKeys("123");
		Thread.sleep(1000);
		address1.sendKeys(Keys.DOWN);
		address1.sendKeys(Keys.RETURN);
		
		phone.sendKeys("2366547890");
		
		email.sendKeys("testacct@gmail.com");
		
		WebElement emailCheck = driver.findElement(By.id("subscribeEmail"));
		emailCheck.click();
		Assert.assertFalse(emailCheck.isSelected());
		
		WebElement textCheck = driver.findElement(By.id("subscribeSms"));
		textCheck.click();
		Assert.assertFalse(textCheck.isSelected());
		
		emailCheck.click();
		
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
	
	@AfterClass
	public void closeWindow() {
		driver.close();
	}
	
}
