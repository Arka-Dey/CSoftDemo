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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resource.CSoftAS.Base;

public class LoginNegativeTest extends Base {
	public static Logger log=LogManager.getLogger(LoginTest.class.getName());
	@BeforeMethod
	public void driverInitialize() throws IOException {
		driver=initializeDriver();
		
		driver.manage().window().maximize();
		
		}
	
	@Test(dataProvider="getData")
	public void Negative_Login(String Uname, String Pwd) {
		
		driver.get(prop.getProperty("url"));
		log.info("for Negative login test");
		//driver.findElement(By.xpath("//*[@id='login']/div[1]/button")).click();
		loginPage lp=new loginPage(driver);
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(lp.getPartnerLogin()));
		lp.getPartnerLogin().click();
		log.debug("partner button clicked");
		lp.getUserName().sendKeys(Uname);
		log.debug("username button is passed keys");
		lp.getPassword().sendKeys(Pwd);
		log.debug("password button is passed keys");
		lp.getSubmit().click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver=null;
	}
	
	@DataProvider(name="getData")
	public Object[][] getData(){
		
		Object[][] data=new Object[4][2];
		
		data[0][0]="abc";
		data[0][1]="123";
		
		data[1][0]="A ";
		data[1][1]=" B";
		
		data[2][0]="'";
		data[2][1]="'";
		
		data[3][0]="arka@csoftindia.net";
		data[3][1]="12323543645756867978907896785467245624353454354353453455234235235345346457657567875654654645665";
		
		return data;
	}
	
}


