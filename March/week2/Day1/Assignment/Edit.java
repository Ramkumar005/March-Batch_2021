package week2_Day1.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Edit {

	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver_86.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://leafground.com/");
		
		driver.findElementByXPath("//ul[@class='wp-categories-list']/li[1]").click();
		
		driver.findElementByXPath("//input[@id='email']").sendKeys("ramramiah102@gmail.com",Keys.TAB);
		Thread.sleep(2000);
		
		driver.findElementByXPath("//input[@value='Append ']").sendKeys("RamKumar", Keys.TAB);
		Thread.sleep(2000);
		
		String Text = driver.findElementByXPath("//input[@value='TestLeaf']").getAttribute("value");
		System.out.println(Text);
		
		driver.findElementByXPath("//input[@value='Clear me!!']").clear();
		
		WebElement check_enable = driver.findElementByXPath("(//div[@class='large-6 small-12 columns'])[5]");
		boolean enabled = check_enable.isEnabled();
		System.out.println(enabled);
		
	
//    	if (check_enable.isEnabled()) {
//			System.out.println("It's Enabled");
//		}
//			else {
//				System.out.println("It's Disabled");
//					
//		}   
		
	}

}
