package PNC.PNC123;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class Login {

	private WebDriver driver;

	/*@Test (description="This Test Case Will Test The Login Feature")
	public void login(String username ,String pas) throws InterruptedException {
		//		driver.findElement(By.name("userName")).clear();
		//		driver.findElement(By.name("userName")).sendKeys("invalidUN");
		//		driver.findElement(By.name("password")).clear();
		//		driver.findElement(By.name("password")).sendKeys("invalidPW");
		//		driver.findElement(By.name("login")).click();
		//		driver.findElement(By.xpath("//a[@href='mercurywelcome.php']")).click();

		driver.findElement(By.linkText("REGISTER")).click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstName")));
		// Thread.sleep(6000);

		driver.findElement(By.name("firstName")).sendKeys("Submit");

		LoginPage.uname.sendKeys("Pani");
		LoginPage.pass.sendKeys("asd");
		LoginPage.login_button.click();

		driver.findElement(By.name("lastName")).sendKeys("Pani");
		driver.findElement(By.id("email")).sendKeys("Sambit");
		driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("Fursungi");
		Select count = new Select(driver.findElement(By.name("country")));
		count.selectByVisibleText("INDIA");


	}*/
	@BeforeTest
	public void beforeTest() {
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\pdc4-training.pdc4\\Desktop\\Selenium Driver\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver=WebDriverFactory.createDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		PageFactory.initElements(driver, LoginPage.class);

	}

	@Test (dataProvider="Usernameandpassword",description="This test case will take you to login")
	public void login1(String username,String password){
		// driver.findElement(By.linkText(" sign-in ")).click();
		/*driver.findElement(By.name("userName")).sendKeys("Sambit");
		driver.findElement(By.name("password")).sendKeys("asd");
		driver.findElement(By.name("login")).click();*/
		// driver.navigate().back();
		LoginPage.uname.sendKeys(username);
		LoginPage.pass.sendKeys(password);
		LoginPage.login_button.click();
		//Assert.assertEquals("Find a Flight", driver.getTitle());

	}
	@DataProvider(name="Usernameandpassword")
	public String[][] credentials(){
		return new String[][]{
			new String[] {"invalidUN" ,"invalidPW"},
			new String[] {"username1" ,"password1"}
			};
			}



	
		@AfterTest
		public void afterTest() {
			driver.close();
		}

	}
