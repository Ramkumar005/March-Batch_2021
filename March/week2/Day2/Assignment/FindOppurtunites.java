package week2_Day2.Assignment;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindOppurtunites {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		
		driver.findElement(By.xpath("//a[text()='Find Opportunities']")).click();
		
		List<WebElement> opportunityIdList = driver.findElements(By.xpath("//div[contains(@class,'salesOpportunityId')]/a[contains(@href,'salesOpportunityId')]"));
		for (WebElement opportunityId : opportunityIdList) {
			System.out.println(opportunityId.getText());
		}
		
		if (driver.getTitle().contentEquals("Find Opportunities | opentaps CRM")) {
			System.out.println("Title verified: "+driver.getTitle());
		}

	}

}
