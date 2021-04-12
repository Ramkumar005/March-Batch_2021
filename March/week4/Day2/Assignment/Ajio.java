package week4_Day2.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.ajio.com/shop/sale ");
		
		driver.findElementByXPath("//input[@type='text']").sendKeys("Bags");
		driver.findElementByXPath("//button[@type='submit']/span").click();
		
		WebElement women = driver.findElementByXPath("//label[@for='Women']");
		women.click();
		
		WebElement fiveGrid = driver.findElementByXPath("//div[@class='five-grid']");
		fiveGrid.click();
		
		WebElement sortBy = driver.findElementByXPath("//div[@class='filter-dropdown']/select");
		Select select = new Select(sortBy);
		select.selectByIndex(3);
		
		WebElement price = driver.findElementByXPath("//span[text()='price']");
		price.click();
		driver.findElementByXPath("//input[@id='minPrice']").sendKeys("3000");
		driver.findElementByXPath("//input[@id='maxPrice']").sendKeys("5000");
		driver.findElementByXPath("(//button[@type='submit'])[2]").click();
		
		WebElement firstItem = driver.findElementByXPath("(//div[@class='imgHolder'])[1]");
		firstItem.click();
		
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		driver.switchTo().window(winList.get(1));
		
		WebElement actualPrice = driver.findElementByXPath("//div[@class='prod-sp']");
		String text = actualPrice.getText();
		String replaceAll = text.replaceAll("\\D", "");
		int rate = Integer.parseInt(replaceAll);
		System.out.println("Actual Price :-" +rate);
		
		String disPrice = driver.findElementByXPath("//div[@class='promo-discounted-price']").getText();
		String replace = disPrice.replaceAll("\\D", "");
		int discountPrice = Integer.parseInt(replace);
		System.out.println("Discount price = " + discountPrice);
		
		String code = driver.findElementByXPath("//div[@class='promo-title']").getText();
		String[] codeCoup = code.split("Code");
		String couponCode = codeCoup[codeCoup.length-1].replaceAll("[^a-zA-Z]", "");
	    System.out.println(couponCode);
	    
	    driver.findElementByXPath("//span[text()='Enter Pin-code To Know Estimated Delivery Date']").click();
	    driver.findElementByXPath("//input[@name='pincode']").sendKeys("625016", Keys.ENTER);
	    String deliveryDate = driver.findElementByXPath("//li[text()='Expected Delivery: ']").getText();
		System.out.println(deliveryDate);
		
		driver.findElementByXPath("//div[@class='other-info-toggle']").click();
		String customCare = driver.findElementByXPath("//div[text()='Customer Care Address']/following::div[2]")
				.getText();
		System.out.println(customCare);
		
		driver.findElementByXPath("//div[@class='btn-gold']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='popup-blk cart-blk']").click();
		String total= driver.findElementByXPath("//section[@id='orderTotal']/span[2]").getText();
		String substr = total.substring(4, 9);
		String replaceAll3 = substr.replaceAll("\\D", "");
		int orderTotal = Integer.parseInt(replaceAll3);
		System.out.println(orderTotal);
		
		if (rate == orderTotal) {
			System.out.println("Order Total is matching");
		} else {
			System.out.println("Order Total is not matching");
		}
		
		
		driver.findElementByXPath("//input[@id='couponCodeInput']").sendKeys(couponCode);

		driver.findElementByXPath("//button[text()='Apply']").click();
		
		String bill = driver.findElementByXPath("//span[@class='price-value bold-font']").getText();
		String substring = bill.substring(4, 9);
		String billAmount = substring.replaceAll("\\D", "");
		int totalBill = Integer.parseInt(billAmount);
		System.out.println(totalBill);
		
		if (totalBill==discountPrice) {
			System.out.println("The bill amount is matching ");
		}else {
			System.out.println("The bill amount is not matching ");	
		}
		
		Thread.sleep(2000);
		driver.findElementByXPath("//div[text()='Delete']").click();
		
		Thread.sleep(2000);
		driver.findElementByXPath("//div[text()='DELETE']").click();
		
		driver.quit();
		
	}

}
