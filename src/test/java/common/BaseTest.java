package common;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	private FileInputStream fis;
	private Properties prop;
	protected WebDriver driver;
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		fis=new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		
		prop=new Properties();
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//libs//chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		
		WindowsUtils.killByName("chromedriver.exe");
	}	
}
