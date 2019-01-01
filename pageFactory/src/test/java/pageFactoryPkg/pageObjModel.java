package pageFactoryPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageObjModel {
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(className="_1q0oQo76jB7KFKWPCMPzDW")
	WebElement clkBtn;
	
	@FindBy(linkText="Home")
	WebElement loginHomeLink;
	
	@FindBy(linkText="Log In")
	WebElement loginLnk;
	
	@FindBy(linkText="Account")
	WebElement acctLink;
	
	@FindBy(xpath="//*[@id=\"react_root\"]/div/main/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/div/header/div/div[2]/div/div[1]/h3")
	WebElement buyingPowerValue;
	
	public pageObjModel(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String usrName) {
		uname.sendKeys("faiz1985@gmail.com");
	}
	
	public void setPwd(String passwd) {
		pwd.sendKeys("Novem*2018");
	}
	
	public void clickLoginBtn() {
		clkBtn.click();
	}
		
	public void loginHomeValidate() {
		if (loginHomeLink.isDisplayed()) {
			System.out.println("Log in Successful");
		}
	}
	
	public void loginClk() {
		if (loginLnk.isDisplayed()) {
			loginLnk.click();
		}
	}
	
	public void findBuyingPower() throws InterruptedException {
		acctLink.click();
		Thread.sleep(1000);
		System.out.println("OUTPUT - Current Buying Power is: " +buyingPowerValue.getText());
	}
}
