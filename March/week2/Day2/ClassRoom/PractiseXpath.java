package week2_Day2.ClassRoom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiseXpath {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.xpath("//label[@for='username']/following-sibling::input"));
		
		driver.findElement(By.xpath("//label[@for='password']/following-sibling::input"));
		
		driver.findElement(By.xpath("//input[@value='Login' and @class='decorativeSubmit']"));
		
		driver.findElement(By.xpath("//div[@id='label']/a"));
		
		driver.findElement(By.xpath("//a[text()='Leads']"));
		
		driver.findElement(By.xpath("//ul[@class='shortcuts']/li[4]/a"));
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]"));

	}

}
