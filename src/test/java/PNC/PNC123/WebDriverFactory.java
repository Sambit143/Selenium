package PNC.PNC123;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

	public static WebDriver createDriver(){
		String webdriver = System.getProperty("browser","ie");

		switch(webdriver){
		case "ie":
			System.setProperty("webdriver.ie.driver","C:\\Users\\pdc4-training.pdc4\\Desktop\\Selenium Driver\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		case "FireFox":
			System.setProperty("webdriver.gecho.driver","C:\\Users\\pdc4-training.pdc4\\Desktop\\Selenium Driver\\geckodriver.exe");
			return new FirefoxDriver();
		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:\\Users\\pdc4-training.pdc4\\Desktop\\Selenium Driver\\chromedriver.exe");
			return new ChromeDriver();

		default:
			throw new RuntimeException("Unsupported erbdriver" + webdriver);
		}
	}

}
