package com.org.Doordash_Maven.Doordash_Maven;



import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import PageObjects.HomePage;
import Utility.Constants;
import Utility.ExcelUtils;
import Utility.Log;
import com.org.Doordash_Maven.Doordash_Maven.SignIn_Action;

public class GroupOrder {

	
	private static WebDriver driver = null;
	 
	public static void main(String[] args) throws Exception {

	DOMConfigurator.configure("log4j.xml");	
	
try{
		
        ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Sheet1");
 
        
        System.setProperty("webdriver.chrome.driver", "D:\\Hp\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		   		
    	WebDriver driver = new ChromeDriver();
     
    	driver.manage().window().maximize();
    		
    		
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 
        driver.get(Constants.URL);
 
        SignIn_Action.Execute(driver);
        Thread.sleep(2000);
        HomePage.txtbx_Search(driver).sendKeys("The Cheesecake Factory\n");
        
        Log.info("Search box found and parameter is provided");
        
        
        
        
        driver.findElement(By.xpath("//*[@id='ConsumerApp']/div/div[4]/div/div/div/div/div/div/a/div/div")).click();
        Log.info("Search result selected");
      
        driver.findElement(By.xpath("//*[contains(text(),'Create Group')]")).click();
        Log.info("Create Group Option Found and Selected");
        
        driver.findElement(By.xpath("//span[text()='$10']")).click();
        Log.info("$10 Amount found and selected");
       
        driver.findElement(By.xpath(".//*[contains(@data-test-id,'menu-page-group-order-confirm-btn')]")).click();
        Log.info("Create Group Order Button Found and Clicked");
        
        
        driver.findElement(By.xpath("//*[@id='ConsumerApp']/div/div[4]/div/div/div[1]/div/div[2]/button[2]")).click();
        Log.info("Share Button found and Clicked");
        
        Thread.sleep(3000);
        String code = null;      
        
        code = driver.findElement(By.xpath("//span[@class='CopyLink_link___18AVc']")).getText();
        Log.info("Code Obtained and Printed");
        
        
        System.out.println("The code is: "+code);
        
        if(code!=null){
        	
        	ExcelUtils.setCellData("Pass", 2, 3);
        	driver.close();
        	System.out.println("Test Case Passed");
        	}
        else{
        	
        	ExcelUtils.setCellData("Pass", 2, 3);
        	System.out.println("Test Case Failed");
        	
        } 
        
        
		}
		
		catch(Exception e){
			
			System.out.println(e);
		}
	
}
}

