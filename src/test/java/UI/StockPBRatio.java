package UI;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StockPBRatio {

	public static void main(String[] args) throws InterruptedException {

		String tickerSymbol = "";
		String isinId = "";
		String pbRatio = "";
		String company = "";
		int j = 0;
		Map<String, String> stock = new HashMap<String, String>();
		Map<String, String> stockPB = new HashMap<String, String>();
		String pathString = "C:\\Users\\nayin\\Downloads\\ind_nifty50list.csv";

		try {
			Stock stockClass = new Stock(pathString);
			stock = stockClass.extractStocks();
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		for (Map.Entry<String, String> e : stock.entrySet()) {
			tickerSymbol = e.getKey();
			isinId = e.getValue();
			driver.navigate().to("https://www.moneycontrol.com/");
			WebElement element = driver.findElement(By.id("search_str"));
			element.sendKeys(tickerSymbol + " " + isinId);
			Thread.sleep(2000);
			try {
				element.findElement(By.xpath("//*[@id='autosuggestlist']/ul/li[1]/a")).click();
				company = driver.findElement(By.xpath("//*[@id='stockName']/h1")).getText();
				pbRatio = driver.findElement(By.xpath("//span[@class='nsepb bsepb']")).getText();
			} catch (Exception NoSuchElementException) {
				pbRatio = null;
				company = null;
			}
			System.out.println(++j + " " + e.getKey() + " " + pbRatio + " " + company);
			stockPB.put(e.getKey(), pbRatio);

		}

		driver.close();

		for (Map.Entry<String, String> e : stockPB.entrySet()) {
			// Printing key-value pairs
			System.out.println(e.getKey() + " " + e.getValue());
		}

	}

}
