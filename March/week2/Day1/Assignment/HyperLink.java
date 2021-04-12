package week2_Day1.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HyperLink {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver_86.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.navigate().to("http://leafground.com/home.html");

		driver.findElementByXPath("(//ul[@class='wp-categories-list'])/li[3]").click();
		Thread.sleep(2000);

		driver.findElementByLinkText("Go to Home Page").click();
		Thread.sleep(2000);

		driver.navigate().back();

		String redirect_pg = driver.findElementByPartialLinkText("supposed to go without").getAttribute("href");
		System.out.println(redirect_pg);

		driver.findElementByLinkText("Verify am I broken?").click();
		String title = driver.getTitle();
		if  (title.contains("HTTP Status 404 – Not Found"))
		{ System.err.println("Page is Error");
		}
		else {
			System.out.println("Page is Not Error");
		}

		driver.navigate().back();
		
		driver.findElementByLinkText("Go to Home Page").click();
		
		driver.navigate().back();
		
		List<WebElement> TotalLinks = driver.findElementsByTagName("a");
		System.out.println(TotalLinks.size());


	}
}


