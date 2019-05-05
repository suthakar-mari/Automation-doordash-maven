package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	
	private static WebElement element = null;
	
	public static WebElement txtbx_Search(WebDriver driver){
		
		element = driver.findElement(By.xpath(".//*[@id='ConsumerApp']/div/header/div[3]/div[1]/div/div/input"));
		
		
		return element;
	}
	
	
	
	public static WebElement btn_Menu(WebDriver driver){
		
		element = driver.findElement(By.xpath(".//*[@id='ConsumerApp']/div/header/div[1]/div[1]/button"));
		
		
		return element;
	}
	
	public static WebElement btn_Address(WebDriver driver){
		
		element = driver.findElement(By.xpath(".//*[@id='ConsumerApp']/div/header/div[1]/div[2]/button[2]"));
		
		
		return element;
	}
	
	
	public static WebElement btn_Cart(WebDriver driver){
		
		element = driver.findElement(By.xpath(".//*[@id='ConsumerApp']/div/header/div[3]/div[2]/button/svg/path[1]"));
		
		
		return element;
	}
	
	
	
	
	
	
	
	
	
}
