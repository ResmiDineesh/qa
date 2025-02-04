package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page.AmazonPage;

public class AmazonTest {
	WebDriver driver;
	

	@BeforeTest
	public void setup()
	{
		 driver = new ChromeDriver();
		 
	}

	@BeforeMethod
	public void URLLoadind()
	{
		 driver.get("https://www.amazon.in/");
	}
	@Test
	public void test() throws Throwable
	{
		AmazonPage ob = new AmazonPage(driver);
		ob.TitleCHK();
		ob.login();
		ob.LinkVerify();
		ob.windowHandling();
		
	}
}
