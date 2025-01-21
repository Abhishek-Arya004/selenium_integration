package testCases;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Object_files.RegisterPage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class RegisterUserTest extends  BaseClass {
	

	
	 @Test
	   public void registerUser() throws IOException {
	      logger.info("Reading values from excel from registration");
	      
	      // reading values of excel in arraylist
	      ArrayList<String> result = readExcel.readingExcel();

	      // adding implicit wait of 12 secs
	      driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	      
	      // object of RegisterPage page class
	      RegisterPage registerPage = new RegisterPage(driver);
	      logger.info("Starting registration");
	      
	      // input first and last name
	      for (int i = 0; i <result.size(); i++) {
	         String[] names = result.get(i).split(",");
	         registerPage.inputFirstname(names[0]);
	         registerPage.inputLastname(names[1]);
	      }
	      
	      // click register button
	      registerPage.clickRegister();
	      logger.info("Verification of entered values");
	      
	      // verify value input in the first name
	      if (registerPage.getFirstName().equalsIgnoreCase("Ram")){
		  
	         // assertions to test case
	    	  Assert.assertTrue(true);
	      } else {
	    	  Assert.assertTrue(false);
	      }
	      
	      // verify value input in the last name
	      if (registerPage.getLastName().equalsIgnoreCase("sharma")){
		  
	         // assertions to test case
	    	
	         Assert.assertTrue(true);
	         
	         
	      } else {
	    	  
	    	  
	    	  Assert.assertTrue(false);
	      }
	   }
	
	
	
	

}
