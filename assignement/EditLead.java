package week6.day2.assignement;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends BaseClass {
	@BeforeTest
	public void SetExcelfile() {
		filename="EditLead";
	}
	

	
@Test(dataProvider="Fetchvalues")
	public  void runEditLead(String PhoneNo,String CompanyName) throws InterruptedException {
		System.out.println("EditLead");
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(PhoneNo);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(CompanyName);
		driver.findElement(By.name("submitButton")).click();
		
}
}

