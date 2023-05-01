package hw326;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HwSession5 {
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver,chrome,driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() {

		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGN_IN_ELEMENT = driver
				.findElement(By.xpath("//button[@class='btn btn-success block full-width']"));

		USER_NAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGN_IN_ELEMENT.click();

		WebElement TRANSACTION_BUTTON_ELEMENT = driver.findElement(By.xpath("//span[contains(text(),'Transactions')]"));
		TRANSACTION_BUTTON_ELEMENT.click();
		WebElement NEW_DEPOSIT_ELEMENT = driver.findElement(By.xpath("//a[contains(text(),'New Deposit')]"));
		NEW_DEPOSIT_ELEMENT.click();
		WebElement ACCOUNT_DROPDOWN_ELEMENT = driver.findElement(By.xpath("//span[@id='select2-account-container']"));
		Select sel=new Select(driver.findElement(By.xpath("//span[@id='select2-account-container']")));
		sel.selectByVisibleText("Mahbuba");
		WebElement ACCOUNT_ELEMENT = driver.findElement(By.xpath("//input[@class='dz-hidden-input']"));
		
//		WebElement DESCRIPTION_ELEMENT = driver.findElement(By.xpath("//input[@id='description']"));
//		DESCRIPTION_ELEMENT.sendKeys("this is my frist bank account");

	}

}
