package week4_Day1.ClassRoom;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {

		// TO OPEN CHROME
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// TO MAXIMIZE BROWSER
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// TO OPEN URL
		driver.get("http://www.leafground.com/");

		driver.findElementByXPath("//ul[@class='wp-categories-list']/li[11]").click();

		driver.findElementById("home").click();
		
		String parentwindow = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		System.out.println(windowHandles.size());
		
		for (String cwindow : windowHandles) {
			driver.switchTo().window(cwindow);
		}
		driver.findElementByXPath("(//li[@class='col-lg-3 col-md-3 col-sm-3'])[1]/a").click();
		driver.close();

		driver.switchTo().window(parentwindow);
		Thread.sleep(2000);

	}
}
