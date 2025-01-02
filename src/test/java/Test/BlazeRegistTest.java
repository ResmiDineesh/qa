package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page.BlazeRegisterPage;


public class BlazeRegistTest {
	WebDriver driver;

	@BeforeTest
	public void setup()
	{
		 driver = new ChromeDriver();
		 
	}

	@BeforeMethod
	public void URLLoadind()
	{
		 driver.get("https://blazedemo.com/register");
	}
	@Test
	public void test()
	{
	BlazeRegisterPage ob =  new BlazeRegisterPage(driver);
	ob.setvalue("Resmi", "Lumi", "abc@gmail", "bmbm", "jh");
	ob.login();

	}

}
