package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	private static WebElement element = null;
	
	
	
	
	
	public static WebElement txtbx_Email(WebDriver driver){
		
		element = driver.findElement(By.xpath(".//*[@id='login-form']/label[1]/input"));
		
		
		return element;
		
		
	}
	
	public static WebElement txtbx_Password(WebDriver driver){
		
		element = driver.findElement(By.xpath(".//*[@id='login-form']/label[2]/div[3]/input"));
		
		
		return element;
		
		
	}
	

	public static WebElement Signin_Btn(WebDriver driver){
		
		element = driver.findElement(By.xpath(".//*[@id='login-form']/button/span[1]"));
		
		
		return element;
		
		
	}
	
	
	
}
