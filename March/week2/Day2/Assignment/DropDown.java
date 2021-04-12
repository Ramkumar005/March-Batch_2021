package week2_Day2.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.leafground.com/pages/Dropdown.html");

		WebElement drop1 = driver.findElementById("dropdown1");
		Select dd1 = new Select(drop1);
		dd1.selectByIndex(1);

		WebElement drop2 = driver.findElementByName("dropdown2");
		Select dd2 = new Select(drop2);
		dd2.selectByVisibleText("Appium");

		WebElement drop3 = driver.findElementById("dropdown3");
		Select dd3 = new Select(drop3);
		dd3.selectByValue("1");

		List<WebElement> dd4 = driver.findElementsByXPath("//select[@class='dropdown']/option");
		System.out.println(dd4.size());

		driver.findElementByXPath("//div[@id='contentblock']/section[1]/div[5]/select[1]").sendKeys("Selenium");

		WebElement dd5 = driver.findElementByXPath("//div[@class='example'])[5]");
		WebElement dd6 = driver.findElementByXPath("(//div[@class='example'])[6]");

		Actions builder = new Actions(driver);
		builder.dragAndDrop(dd5, dd6).perform();

	}

}
