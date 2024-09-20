package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void testLogin()
	{
		logger.info("Login Test Execution Started...");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp = new LoginPage(driver);
		
		lp.Email(pro.getProperty("email"));
		
		lp.Password(pro.getProperty("password"));
		
		lp.clickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		
		boolean targetpage=macc.isMyAccountPageExists();
		Assert.assertTrue(targetpage);
		
		logger.info("Finish Login Test Execution");
		
		
		
	}

}
