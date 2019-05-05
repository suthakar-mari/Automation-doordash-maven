package com.org.Doordash_Maven.Doordash_Maven;



import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.HomePage;
import Utility.Constants;
import Utility.ExcelUtils;
import Utility.Log;
import com.org.Doordash_Maven.Doordash_Maven.SignIn_Action;

public class SingleOrder {

	
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
        HomePage.txtbx_Search(driver).sendKeys("Denny\n");
        
        Log.info("Search box found and parameter is provided");
                
        
        driver.findElement(By.xpath("//*[@id='ConsumerApp']/div/div[4]/div/div/div/div/div/div/a/div/div")).click();
        Log.info("Search result selected");
      
        driver.findElement(By.xpath("//*[contains(text(),'Milk Shake')]")).click();
        Log.info("Milk Shake selected and clicked in the menu");
        Thread.sleep(3000);
		
        driver.findElement(By.xpath("//*[@color='red']//*[text()='Strawberry']")).click();
        Log.info("Strawberry radio button found and selected");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(@class,'BigButton_text___2Iw-G')]")).click();
        Log.info("Add to order button found and clicked");
        
        Boolean a = driver.findElement(By.xpath("//*[contains(text(),'Checkout')]")).isDisplayed(); 
        		
        		
        
        
        if(a==true){
        	ExcelUtils.setCellData("Pass", 1, 3);
        	System.out.println("Test Case Passed");
        	}
        else{
        	ExcelUtils.setCellData("Fail", 1, 3);
        	System.out.println("Test Case Failed");
        	
        }
        driver.close();
        
		}
		
		catch(Exception e){
			
			System.out.println(e);
		}
	
}
}
