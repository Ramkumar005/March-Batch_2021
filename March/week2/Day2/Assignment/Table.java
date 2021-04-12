package week2_Day2.Assignment;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.leafground.com/");

		driver.findElementByXPath("//a[@href='pages/table.html']").click();

		List<WebElement> th_list = driver.findElementsByXPath("(//table[@id='table_id'])//tr/th");
		System.out.println(th_list.size());

		List<WebElement> tr_list = driver.findElementsByTagName("tr");
		System.out.println(tr_list.size());

		WebElement percentage = driver
				.findElementByXPath("//td[normalize-space()='Learn to interact with Elements']//following::td[1]");
		String percent = percentage.getText();
		System.out.println(percent);

		List<WebElement> progress = driver.findElementsByXPath("//td[2]");

		List<Integer> numbers = new ArrayList<Integer>();

		for (WebElement webElement : progress) {
			String individual = webElement.getText();
			individual = individual.replaceAll("%", "");
			numbers.add(Integer.parseInt(individual));
		}
		System.out.println(numbers);
		int smallvalue = Collections.min(numbers);
		System.out.println(smallvalue);

		String smallvalue1 = Integer.toString(smallvalue);

		System.out.println(smallvalue1);

		List<WebElement> txt = driver.findElementsByXPath("//table[@id='table_id']//tr/td[1]");
		int size = txt.size();
		System.out.println(size);

		for (WebElement str : txt) {
			System.out.println(str.getText());
		}
		List<WebElement> All = driver.findElementsByXPath("//table[@id='table_id']//tr/td");
		for (WebElement str1 : All) {
			System.out.println(str1.getText());
		}

//		List<WebElement> crow = driver.findElementsByXPath("//table[@id='table_id']//tr");
//		int rcount = crow.size();
//		
//		for (int i = 2; i <= rcount; i++) {
//			List<WebElement> lsRows = driver.findElementsByXPath("//table[@id='table_id']//tr["+i+"]/td");
//			int dcount = lsRows.size();
//			for (int j = 1; j <= dcount; j++) {
//				String dcount1 = driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]/td["+j+"]").getText();
//			System.out.println(dcount1);
//				
//			}

	}

}
