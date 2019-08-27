package Resource.CSoftAS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\arka\\CSoftASproject\\src\\main\\java\\Resource\\CSoftAS\\Data.properties");
		prop.load(fis);
		String browserName= prop.getProperty("Browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\arka\\CSoftASproject\\src\\main\\java\\Resource\\CSoftAS\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\arka\\CSoftASproject\\src\\main\\java\\Resource\\CSoftAS\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			// Invoking IE Browser
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}

}
