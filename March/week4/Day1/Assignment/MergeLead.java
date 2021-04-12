package week4_Day1.Assignment;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		// 1. Launch URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// 3. Click on Login Button using Class Locator
		driver.findElementByClassName("decorativeSubmit").click();
		Thread.sleep(2000);

		// 4. Click on CRM/SFA Link
		driver.findElementByLinkText("CRM/SFA").click();
		Thread.sleep(2000);

		// 5. click Lead link
		driver.findElementByXPath("//a[text()='Leads']").click();
		Thread.sleep(2000);

		// 6. click Merge Link
		driver.findElementByXPath("//a[text()='Merge Leads']").click();
		String first = driver.getWindowHandle();

		// 7. click the icon near from Lead
		driver.findElementByXPath("//span[text()='From Lead']/following::img").click();

		// 8. Move to new window
		Set<String> allwindows = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(allwindows);
		driver.switchTo().window(winList.get(1));

		// 10. Enter Lead ID
		WebElement LeadId = driver.findElementByXPath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[3]");
		String text = LeadId.getText();
		driver.findElementByXPath("//input[@name='id']").sendKeys(text);
		Thread.sleep(2000);

		// 11. Click Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);

		// 12. Click First Resulting lead
		WebElement linkText = driver
				.findElementByXPath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]");
		linkText.click();
		Thread.sleep(2000);
		// wait.until(ExpectedConditions.visibilityOf(linkText));

		// 13. Switch back to primary window
		driver.switchTo().window(first);

		// 14. Click on Icon near To Lead
		driver.findElementByXPath("//span[text()='To Lead']/following::img").click();

		// Move to new window
		allwindows = driver.getWindowHandles();
		winList = new ArrayList<String>(allwindows);
		driver.switchTo().window(winList.get(1));
		// 10. Enter Lead ID
		WebElement LeadId2 = driver.findElementByXPath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[4]");
		String text2 = LeadId2.getText();
		driver.findElementByXPath("//input[@name='id']").sendKeys(text2);

		// 11. Click Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(2000);
		linkText = driver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]");
		linkText.click();

		// 13. Switch back to primary window
		driver.switchTo().window(first);

		// 20. Click Merge
		driver.findElementByClassName("buttonDangerous").click();
		// 21. Accept Alert
		driver.switchTo().alert().accept();
		// 22. Click Find Leads link
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		// 23. Enter From Lead ID
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input")).sendKeys(text);
		// 24. Click Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		// 25. Verify message "No records to display" in the Lead List. This message
		// confirms that the successful merge of leads
		WebElement info = driver.findElementByXPath("//div[@class='x-panel-bbar']/div/table/following-sibling::div");
		System.out.println(info.getText());
		driver.quit();

	}

}
