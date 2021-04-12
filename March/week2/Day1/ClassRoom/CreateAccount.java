package week2_Day1.ClassRoom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa", Keys.ENTER);
		driver.findElementById("label").click();

		driver.findElementByXPath("//a[text()='Create Account']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='accountName']").sendKeys("Ramkumar");
		driver.findElementByXPath("//input[@id='groupNameLocal']").sendKeys("Ramiah");
		driver.findElementByXPath("//input[@id='annualRevenue']").sendKeys("200000");

		WebElement eleSel = driver.findElementByName("industryEnumId");
		Select dd1 = new Select(eleSel);
		dd1.selectByVisibleText("Computer Software");

		WebElement eleSel1 = driver.findElementByName("ownershipEnumId");
		Select dd2 = new Select(eleSel1);
		dd2.selectByIndex(2);

		driver.findElementById("sicCode").sendKeys("4171");

		WebElement eleSel2 = driver.findElementByName("dataSourceId");
		Select dd3 = new Select(eleSel2);
		dd3.selectByValue("LEAD_EMPLOYEE");

		driver.findElementByXPath("//option[@value='DemoSalesTeam1']").click();

		driver.findElementByXPath("//textarea[@name='description']").sendKeys("March intern");
		driver.findElementByXPath("//textarea[@name='importantNote']").sendKeys("6 months intern period");

		driver.findElementByXPath("//input[@name='parentPartyId']").sendKeys("democlass1");

		driver.findElementById("officeSiteName").sendKeys("interns");

		WebElement eleSel3 = driver.findElementByName("currencyUomId");
		Select dd4 = new Select(eleSel3);
		dd4.selectByIndex(2);

		driver.findElementById("numberEmployees").sendKeys("50");

		driver.findElementById("tickerSymbol").sendKeys("s");

		WebElement eleSel4 = driver.findElementByName("currencyUomId");
		Select dd5 = new Select(eleSel4);
		dd5.selectByIndex(2);

		driver.findElementById("primaryPhoneNumber").sendKeys("9750249477");
		driver.findElementById("primaryEmail").sendKeys("ramramiah102@gmail.com");

		driver.findElementById("generalCity").sendKeys("Madurai");

		driver.findElementByXPath("//input[@type='submit']").click();
		String title = driver.getTitle();
		System.out.println(title);
		
		if (title.contains("Create Account")) {
			System.out.println("Title verified");
		}else {
			System.out.println("Title not verified");
		}

	}

}
