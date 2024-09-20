package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
	
	public Logger logger;
	public static WebDriver driver;
	public Properties pro;
	
	@Parameters({"os", "browser"})
	@BeforeClass(groups= {"sanity","regression","master"})
	public void setUp(String os, String br) throws IOException
	{
		switch(br.toLowerCase())
		{
		case "chrome"  :driver= new ChromeDriver();break;
		case "edge"	   :driver=new EdgeDriver();break;
		case "firefox" : driver= new FirefoxDriver();break;
		default:System.out.println("Invalid Browse");return;
		}
		
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\config.properties");
		pro=new Properties();
		pro.load(file);
		driver.get(pro.getProperty("url"));
		
		logger=LogManager.getLogger(this.getClass()); //log4j

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	
	}
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}

	public String randomNumber()
	{
		String generateNumber=RandomStringUtils.randomNumeric(5);
		return generateNumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generateAlphanumeric=RandomStringUtils.randomAlphanumeric(6);
		return (generateAlphanumeric+"@#");
	}
	
	public String captureScreen(String tname)
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
		File sourcefile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetfilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile = new File(targetfilePath);
		sourcefile.renameTo(targetFile);
		return targetfilePath;
		
	}
}
