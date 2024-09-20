package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDDT extends BaseClass{

	@Test(dataProvider ="LoginData", dataProviderClass = DataProviders.class, groups="datadriven")
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp = new LoginPage(driver);
		
		lp.Email(email);
		
		lp.Password(pwd);
		
		lp.clickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
				
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		
		
		
	}	



	


