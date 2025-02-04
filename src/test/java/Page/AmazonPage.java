package Page;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonPage 
{
 


WebDriver driver;

By Reg = By.id("nav-link-accountList-nav-line-1");
By NewAcc = By.id("createAccountSubmit");
By name =  By.id("ap_customer_name");
By Phone = By.id("ap_phone_number");
By PW = By.id("ap_password");
By Sub = By.id("continue");
By Search = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
By CL = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
By NV = By.xpath("//*[@id=\"nav-search-submit-button\"]");
By NW = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/a/h2/span");

By AddCart = By.xpath("/html/body/div[2]/div/div/div[5]/div[1]/div[4]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[37]/div[1]/span/span/span/input");

By ViewCart = By.xpath("/html/body/div[8]/div[3]/div[3]/div/div[1]/div[3]/div[1]/div[2]/div[3]/form/span/span/input");
By help = By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[7]/ul/li[6]/a");
public AmazonPage (WebDriver driver)
{
this.driver = driver;
}

public void login()
{
	driver.findElement(Reg).click();
	driver.findElement(NewAcc).click();
	driver.findElement(name).sendKeys("res");
	driver.findElement(Phone).sendKeys("56677");
	driver.findElement(PW).sendKeys("ttgvv");;
	driver.findElement(Sub).click();
	driver.navigate().back();
	driver.navigate().back();
	
}

public void TitleCHK()
{
	String actualtitle = driver.getTitle();
	System.out.println(actualtitle);
	String expectedtitle = "Amazon.com";
	if (actualtitle.equals(expectedtitle))
			{
		System.out.println("pass");
			}
	else
	{
		System.out.println("fail");
	}
	
	String SourceCD= driver.getPageSource();
	if(SourceCD.contains("Sell"))
	{
		System.out.println("pass source code");
	}
	else
	{
		System.out.println("fail Source code");
	}
}



public void LinkVerify() throws Throwable
{

	
		URL ob = new URL("https://www.amazon.in/");
		HttpURLConnection con = (HttpURLConnection)ob.openConnection();
		con.connect();
		int response = con.getResponseCode();
		System.out.println(response);
		
		//if (response ==200)
		if(con.getResponseCode()==200)
		{
			System.out.println("valid");
		}
			
		else
		{
			System.out.println("invalid");
		}
		
}

public void windowHandling()
{
	driver.manage().window().maximize();
	driver.findElement(Search).sendKeys("mobile phones");
	driver.findElement(CL).click();
	driver.findElement(NV).click();
	String actual = driver.getTitle();
	System.out.println(actual);
	
String expected = "Amazon.in : mobile phones ";
	if(actual.equals(expected))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	
	
	String parentwindow = driver.getWindowHandle();

	driver.findElement(NW).click();
	
	
	Set<String> allwindowhandles = driver.getWindowHandles();
	
	
	for(String handle: allwindowhandles) 
	{
		System.out.println(handle);
		
		if(!handle.equalsIgnoreCase(parentwindow)) 
				{
			
			driver.switchTo().window(handle); 
			
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[5]/div[1]/div[4]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[37]/div[1]/span/span/span/input")));
			
			driver.findElement(AddCart).click();
			
			WebDriverWait W =new WebDriverWait(driver,Duration.ofSeconds(30));
			W.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div[3]/div[3]/div/div[1]/div[3]/div[1]/div[2]/div[3]/form/span/span/input")));
			
			driver.findElement(ViewCart).click();
			
			driver.close();
			
			
				}
		
		driver.switchTo().window(parentwindow);
		
}

}
public void scrolldown()
{
	JavascriptExecutor Js= (JavascriptExecutor)driver;
	Js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	driver.findElement(help).click();
	
}

}





