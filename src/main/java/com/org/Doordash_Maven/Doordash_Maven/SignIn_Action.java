package com.org.Doordash_Maven.Doordash_Maven;


 
        import org.openqa.selenium.WebDriver;
 
        import PageObjects.HomePage;
 
        import PageObjects.LoginPage;
 
        import Utility.ExcelUtils;
 
    // Now this method does not need any arguments
 
    public class SignIn_Action {
 
		public static void Execute(WebDriver driver) throws Exception{
 
			//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method
 
			String sUserName = ExcelUtils.getCellData(1, 1);
 
			String sPassword = ExcelUtils.getCellData(1, 2);
 
		//	HomePage.btn_Menu(driver).click();
 
			LoginPage.txtbx_Email(driver).sendKeys(sUserName);
 
			LoginPage.txtbx_Password(driver).sendKeys(sPassword);
 
			LoginPage.Signin_Btn(driver).click();
 
        }
 
}