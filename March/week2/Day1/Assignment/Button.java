package week2_Day1.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Button {

	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver","./driver/chromedriver_86.exe");
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get("http://leafground.com/");
			
			driver.findElementByXPath("//ul[@class='wp-categories-list']/li[2]").click();
			Thread.sleep(2000);
			
			driver.findElementByXPath("//div[@class='large-6 small-12 columns']/button[1]").click();
			Thread.sleep(2000);
			
			driver.findElementByXPath("//ul[@class='wp-categories-list']/li[2]").click();
			
			Point location = driver.findElementByXPath("//button[@id='position']").getLocation();
			int xvalue = location.getX();
			int yvalue = location.getY();
			System.out.println("x :"+xvalue+"y :"+ yvalue);
			
			String Colour = driver.findElementByXPath("//button[@id='color']").getCssValue("background-color");
			System.out.println(Colour);
			
			Dimension size = driver.findElementByXPath("//button[@id='size']").getSize();
			System.out.println(size);
			

	}


}
