package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAndValidateTitleOfPage extends BaseTest {


    public LoginAndValidateTitleOfPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Test
    public void successfulLogin() throws InterruptedException {
        driver.get(URL);
        homePage.loginToWebsite("Login positive");
        homePage.validatePageTitle();
//        
//        homePage.clickCloseIcon();
//        homePage.enterSearchTexbox("Macbook air m2");
//        homePage.clickSearchIcon();
//        searchResultsPage.selectFirstProduct();
//        productDetailspage.clickAddToCartButton();
//        productDetailspage.clickCartIcon();
//        cartPage.verifyProduct();

    }

    @Test
    public void unsuccessfulLogin() {
    	
    	driver.get(URL);
    	homePage.unsucessfulLogin("Login negative");
    	homePage.verifyErrorMessage();
    	
    	
    }


}
