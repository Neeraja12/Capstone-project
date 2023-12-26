package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import util.ExcelParser;

import util.BaseClass;

public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
   ExcelParser excelparser=new ExcelParser();

    @FindBy(xpath = "//*[@placeholder='Username']")
    WebElement username;

    
    @FindBy(xpath = "//*[@placeholder='Password']")
    WebElement password;
    

    @FindBy(xpath = "//input[@type='submit']")
    WebElement login;
    
    @FindBy(xpath ="//h3[@data-test='error']")
    WebElement errorMessage;
    
    public void loginToWebsite(String credentials)
    {
    
    	username.sendKeys(excelparser.getData(credentials).get(0));
    	password.sendKeys(excelparser.getData(credentials).get(1));
    	login.click();
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
    	
    	
    }
    public void validatePageTitle()
    {

    	Assert.assertEquals(driver.getTitle(), "Swag Labs", "Title Matched");
    }
    
    public void unsucessfulLogin(String credentialsLogin)
    {
    	username.sendKeys(excelparser.getData(credentialsLogin).get(0));
    	password.sendKeys(excelparser.getData(credentialsLogin).get(1));
    	login.click();
    	
    	
    }
    
    public void verifyErrorMessage()
    {
    	String actualMessage=errorMessage.getText();
    	String expectedMessage="Epic sadface: Username and password do not match any user in this service";
    	
    	Assert.assertEquals(actualMessage, expectedMessage, "Error message text matches");
    	
    }
    
    
    
//    
//    public void enterSearchTexbox(String product)
//    {
//    	searchTextbox.sendKeys(product);
//    }
//    
//    public void clickSearchIcon()
//    {
//    	searchIcon.click();
//    }
//    
//    public void clickCloseIcon()
//    {
//    	closeIcon.click();
//    }
//


}
