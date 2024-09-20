package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
@FindBy(xpath="//input[@id='input-firstname']") 
WebElement txtfirstName;

@FindBy(xpath="//input[@id='input-lastname']") 
WebElement txtlastName;

@FindBy(xpath="//input[@id='input-email']") 
WebElement txteMail;

@FindBy(xpath="//input[@id='input-telephone']") 
WebElement txttelephone;

@FindBy(xpath="//input[@id='input-password']") 
WebElement txtpassword;

@FindBy(xpath="//input[@id='input-confirm']") 
WebElement txtpasswordConfirm;

@FindBy(xpath="//input[@name='agree']")
WebElement chkdPrivacyPolicy;

@FindBy(xpath="//input[@value='Continue']") 
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void setFirstName(String fname)
{
	txtfirstName.sendKeys(fname);
}

public void setLastName(String lname)
{
	txtlastName.sendKeys(lname);
}

public void setEmail(String email)
{
	txteMail.sendKeys(email);
}


public void setTelephone(String tphone)
{
	txttelephone.sendKeys(tphone);
}


public void setPassword(String pwd)
{
	txtpassword.sendKeys(pwd);
}

public void setConfirmPassword(String pwd)
{
	txtpasswordConfirm.sendKeys(pwd);
}

public void clickPolicy()
{
	chkdPrivacyPolicy.click();
}

public void clickContinue()
{
	btnContinue.click();
}

public String getConfirmation()
{
	try {
		return(msgConfirmation.getText());
	}catch(Exception e)
	{
		return(e.getMessage());
	}
}

}