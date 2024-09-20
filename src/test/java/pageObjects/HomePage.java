package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	


@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement lnkmyAccount;

@FindBy(xpath="//a[normalize-space()='Register']") 
WebElement lnkregister;

@FindBy(xpath="//li//a[text()='Login']")
WebElement lnkLogin;
	

public void clickMyAccount()
{
	lnkmyAccount.click();
}

public void clickRegister()
{
	lnkregister.click();
}

public void clickLogin()
{
	lnkLogin.click();
}
}
