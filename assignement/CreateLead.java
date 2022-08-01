package week6.day2.assignement;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CreateLead extends BaseClass {
	
	@BeforeTest
	public void SetExcelfile() {
		filename="CreateLead";
	}
	
	@Test(dataProvider="Fetchvalues")
	public  void runCreateLead(String CompanyName,String FirstName,String LastName,String PhoneNo){
		System.out.println("Create Lead");
		System.out.println("runCreateLead : "+driver);
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(CompanyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FirstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LastName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(PhoneNo);
		driver.findElement(By.name("submitButton")).click();
	}
	
	
	}
	
