package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlazeRegisterPage {
	WebDriver driver;
By BlazeName = By.name("name");
By BlazeCom = By.id("company");
By BlazeMail = By.id("email");
By BlazePassWd = By.id("password");
By BlazePWCon = By.id("password-confirm");
By Login = By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/form/div[6]/div/button");

public BlazeRegisterPage (WebDriver driver)
{
this.driver = driver;
}
public void setvalue(String Name,String Comp,String Email, String PW, String PwCon)
{
driver.findElement(BlazeName).sendKeys(Name);
driver.findElement(BlazeCom).sendKeys(Comp);
driver.findElement(BlazeMail).sendKeys(Email);
driver.findElement(BlazePassWd).sendKeys(PW);
driver.findElement(BlazePWCon).sendKeys(PwCon);
}


public void login()
{
driver.findElement(Login).click();
}

}
