package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.ReadExcelFile;
import utilities.ReadingConfigValues;

public class BaseClass {
	
	
	 // reading values from external files
	   ReadingConfigValues readingConfigValues = new ReadingConfigValues();
	   ReadExcelFile readExcel = new ReadExcelFile();
	   public String baseUrl = readingConfigValues.getURL();
	   public static WebDriver driver;
	   public static Logger logger;
	   
	   @BeforeClass
	  @Parameters("browser")
	   public void setup(String browser){
	      logger = LogManager.getLogger(BaseClass.class);
	      logger.info("Application Launched");
	      
	      // Initiate browser driver as per browser value
	      
	      switch(browser.toLowerCase()){
	    	  
	    	  case "chrome" : driver = new ChromeDriver(); break;
	    	  case "firefox" : driver = new FirefoxDriver(); break;
	    	  case "edge" : driver = new EdgeDriver(); break;
	    	  default:  logger.info("invalid browser"); return;  
			   
	    	  
	      }
//	      if (browser.equalsIgnoreCase("Chrome")) {
//	         driver = new ChromeDriver();
//	         System.out.println("Browser opened in Chrome");
//	      } else if (browser.equalsIgnoreCase("Edge")) {
//	         driver = new EdgeDriver();
//	         System.out.println("Browser opened in Edge");
//	      }
		  
	      // launch application
	      driver.get(baseUrl);
	   }
	   
	   @Test
	   void testbase() {
		   
		   logger.info("BaseClass run successfully");   
		   
	   }
	   @AfterClass
	   public void tearDown(){
	   
	      // quitting browser
	      driver.quit();
	   }

}
