package Module.CSoftAS;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resource.CSoftAS.Base;

public class LoginTest extends Base {
public static Logger log=LogManager.getLogger(LoginTest.class.getName());
	@BeforeMethod
	public void driverInitialize() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		}
	
	@Test
	public void Possitive_Login() {
		
		//driver.findElement(By.xpath("//*[@id='login']/div[1]/button")).click();
		loginPage lp=new loginPage(driver);
		log.info("for possitive login test");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(lp.getPartnerLogin()));
		lp.getPartnerLogin().click();
		log.debug("partner button clicked");
		lp.getUserName().sendKeys("dipankar@csoftindia.net");
		log.debug("username button is passed keys");
		lp.getPassword().sendKeys("1234");
		log.debug("password button is passed keys");
		lp.getSubmit().click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver=null;
	}
	
}
