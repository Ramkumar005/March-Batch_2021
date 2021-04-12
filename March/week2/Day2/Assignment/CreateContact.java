package week2_Day2.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

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
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.linkText("Create Contact")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("Ramkumar");
		driver.findElement(By.id("lastNameField")).sendKeys("Ramiah");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Ramkumar");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Ramiah");
		driver.findElement(By.name("departmentName")).sendKeys("Testing");
		driver.findElement(By.tagName("textarea")).sendKeys("TestLeaf");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("ramramiah102@gmail.com");
		
		Select state = new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		state.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.tagName("textarea")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Sample account created for parctise");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println("Page Title: "+driver.getTitle());
		
		driver.close();

	}

}
