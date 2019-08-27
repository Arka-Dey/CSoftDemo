package Module.CSoftAS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	private WebDriver driver;
	
	private By PartnerLogin=By.xpath("//*[@id='login']/div[1]/button");
	private By UserName=By.id("username1"); 
	private By Password=By.id("password1"); 
	private By Submit=By.id("loginsubmit"); 
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getPartnerLogin() {
		return driver.findElement(PartnerLogin);
	}
	public WebElement getUserName() {
		return driver.findElement(UserName);
	}
	
	public WebElement getPassword() {
		return driver.findElement(Password);
	}
	
	public WebElement getSubmit() {
		return driver.findElement(Submit);
	}
	
	
	
}
