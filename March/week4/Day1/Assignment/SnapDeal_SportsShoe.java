package week4_Day1.Assignment;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal_SportsShoe {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.snapdeal.com/");
		
		// CLick on Men's Fashion
		WebElement mensFash = driver.findElement(By.xpath("(//li[@class='navlink lnHeight'])[1]"));

		// Mouse Hover action
		Actions builder = new Actions(driver);
		builder.moveToElement(mensFash).perform();

		// Go to Sports Shoes

		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();

		// Get the count of the sports shoes
		String SportShoes = driver.findElement(By.xpath("//span[@class = 'category-count']")).getText();
		int ssCount = Integer.parseInt(SportShoes.replaceAll("\\D", ""));
		System.out.println("Sport Shoes Count:" + ssCount);

		// Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		// Sort by Low to High

		Thread.sleep(2000);

		driver.findElement(By.className("sort-selected")).click();

		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();

		// Check if the items displayed are sorted correctly
		List<WebElement> prodList = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

		
		for (WebElement AllList : prodList) {
			String price = AllList.getText();
			int shoePrice = Integer.parseInt(price.replaceAll("\\D", ""));
			System.out.println(shoePrice);
		}
		
		Thread.sleep(2000);
		WebElement ViewMore = driver.findElement(By.xpath("(//button[text()='View More '])[1]"));
		ViewMore.click();

		Thread.sleep(2000);
		WebElement Puma = driver.findElement(By.xpath("//label[@for= 'Brand-Puma']"));
		Puma.click();
		
		Thread.sleep(2000);
		WebElement Apply = driver.findElementByXPath("//div[text()='APPLY']");
		Apply.click();

	   //WebElement close = driver.findElement(By.xpath("//span[@class='sd-icon close-adv sd-icon-delete-sign']"));
       // close.click();
		
		WebElement pumaShoes = driver.findElement(By.xpath("(//img[@title='Puma Blue Training Shoes'])[1]"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(pumaShoes).perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])[2]")).click();

		// Actual Price of the shoes
		String actPrice = driver.findElement(By.xpath("//span[@class = 'strikee ']")).getText();
		int intActPrice = Integer.parseInt(actPrice.replaceAll("\\D", ""));
		System.out.println("Actual Price:" + intActPrice);

		// Discount Price of the shoes
		String disPrice = driver.findElement(By.xpath("//span[@class = 'payBlkBig']")).getText();
		int intDisPrice = Integer.parseInt(disPrice.replaceAll("\\D", ""));
		System.out.println("Discount Price:" + intDisPrice);

		// Discount Percent of the shoes
		String disPercent = driver.findElement(By.xpath("//span[@class = 'percent-desc ']")).getText();
		int intdisPercent = Integer.parseInt(disPercent.replaceAll("\\D", ""));
		System.out.println("Discount Percent:" + intdisPercent);

		// Snapshot of the shoes
		File memory = driver.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(memory, new File("./snaps.jpg"));

		// Close the current window
		driver.close();
		
	}

}
