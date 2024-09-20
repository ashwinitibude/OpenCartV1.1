package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"sanity", "master"})
	public void verify_Account_Registration()
	{
		logger.info("Start Execution....");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		
		hp.clickRegister();
		logger.info("Clicked on Re"
				+ "gister Link");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gamil.com");
		regpage.setTelephone(randomNumber());
		
		String randompass=randomAlphaNumeric();
		regpage.setPassword(randompass);
		regpage.setConfirmPassword(randompass);
		
		regpage.clickPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message");
		
		String confmsg = regpage.getConfirmation();
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
		}
			catch(Exception e)
			{
				logger.error("Test failed:"+e.getMessage());
				Assert.fail("Test failed:"+e.getMessage());
			}
		
		finally
		{
			logger.info("Execution Finished...");
		}
		
				
	}
}
