package pageFactoryPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class pageFactoryClass {
  public pageObjModel pom;
  WebDriver driver;
  
  @BeforeClass
  @Parameters({"ChromeDriverPath", "URL"})
  public void initializeBrowser(String chromeDriverPath, String loginURL) throws InterruptedException {
	  System.out.println("INFO - Initializing Browser...");
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(loginURL);
		pom = new pageObjModel(driver);
		System.out.println("INFO - Initializing Browser Completed!");
  }
  
  @Test
  @Parameters({"loginURL", "uname", "password"})
  public void login(String loginURLValidate, String usrName, String pwd) throws InterruptedException {
	  System.out.println("INFO - Login In Progress...");

	    pom.loginClk();
		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals(loginURLValidate)) {
			Thread.sleep(500);
			pom.setUserName(usrName);
			pom.setPwd(pwd);
			pom.clickLoginBtn();
		}
			Thread.sleep(2000);
			pom.loginHomeValidate();
			System.out.println("INFO - Login Completed!");
	}
  
  @Test(dependsOnMethods="login", priority=1)
  public void findBuyingPower() throws InterruptedException {
		//Thread.sleep(2000);

	  pom.findBuyingPower();
  }
  
  @Test(dependsOnMethods="login", priority=2)
  public void closeBrowser() {
	  driver.close();
	  System.out.println("INFO - Browser Closed, Test Suite Complete!");
  }
}
