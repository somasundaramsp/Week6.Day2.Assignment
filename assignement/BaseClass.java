package week6.day2.assignement;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public String filename;
public RemoteWebDriver driver;
 @Parameters({"browser","url","username","password",})
 @BeforeMethod
public void preConditions(String browser,String url,String username,String password) {
	 if(browser.equalsIgnoreCase("chrome")) {
	  WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 }else if(browser.equalsIgnoreCase("Edge")) {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		 }
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Leads")).click();	
}

	@AfterMethod
	public void postCondition() {
		System.out.println("postCondition : "+driver);
		driver.close();	
	}
	@DataProvider(name="Fetchvalues")
	public String[][] getData() throws IOException {
		ReadExcelData obj=new ReadExcelData();
		String[][] getData = ReadExcelData.getData(filename);
		
		return getData;
		
	}
	
	
	
}
