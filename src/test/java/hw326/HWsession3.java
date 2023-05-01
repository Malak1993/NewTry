package hw326;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWsession3 {
	WebDriver driver;
	@Before
	public void init() {
		
		System.setProperty("webdriver,chrome,driver", "chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	
	public void loginTest() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
//		driver.findElement(By.xpath("//span[@class='nav-label']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
//		driver.findElement(By.linkText("Bank & Cash")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
	
		
	}
	@Test
	public void addaccount() {
	
		loginTest();
		driver.findElement(By.linkText("Bank & Cash")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Malak");
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("new bank account");
		driver.findElement(By.xpath("//input[@id='balance']")).sendKeys("200");
		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='contact_person']")).sendKeys("Abdel");
		driver.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("1478963");
		driver.findElement(By.xpath("//input[@id='ib_url']")).sendKeys("abcd");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	}
	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
