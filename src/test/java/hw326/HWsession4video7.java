package hw326;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class HWsession4video7 {
	WebDriver driver;

	By username = By.xpath("//input[@id='username']");
	By password = By.xpath("//input[@id='password']");
	By signin = By.xpath("//button[contains(text(),'Sign in')]");
	By customers = By.xpath("//span[contains(text(),'Customers')]");
	By addcustomer = By.xpath("//a[contains(text(),'Add Customer')]");
	By fullname = By.xpath("//input[@id='account']");
	By companyname = By.xpath("//select[@id='cid']");
	By country = By.xpath("//select[@id='country']]");
	By currency = By.xpath("//select[@id='currency']");
	By submitbutton = By.xpath("//button[@id='submit']");
	By listcustomer = By.xpath("//a[contains(text(),'List Customers')]");
	By searchcustomername=By.xpath("//input[@id='foo_filter']");

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//	@Test
	public void logintest() {
		driver.findElement(username).sendKeys("demo@techfios.com");
		driver.findElement(password).sendKeys("abc123");
		driver.findElement(signin).click();
	}

	@Test
	public void addcustomer() {
		logintest();
		driver.findElement(customers).click();
		driver.findElement(addcustomer).click();
		driver.findElement(fullname).sendKeys("malak ali");
		Select sel = new Select(driver.findElement(companyname));
		sel.selectByVisibleText("Uber");

//		Select sel2 = new Select(driver.findElement(country));
//		sel2.selectByVisibleText("United States");

		Select sel1 = new Select(driver.findElement(currency));
		sel1.selectByVisibleText("USD");
		driver.findElement(submitbutton).click();
		driver.navigate().back();
		driver.findElement(customers).click();
		driver.findElement(listcustomer).click();
		driver.findElement(searchcustomername).sendKeys("malak ali");
		driver.findElement(searchcustomername).click();
		
//		Assert.assertEquals("malak ali", driver.findElement(By.xpath("//a[contains(text(),'malak ali')]")));
		
	}
}
