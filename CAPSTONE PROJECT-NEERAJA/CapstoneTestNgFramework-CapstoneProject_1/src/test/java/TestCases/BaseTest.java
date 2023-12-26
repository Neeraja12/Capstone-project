package TestCases;

import Pages.HomePage;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import util.BaseClass;
import util.utility;

import java.util.Properties;
public class BaseTest extends BaseClass{

    public BaseTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	protected HomePage homePage;

    WebDriver driver;
    Properties properties;
    static String URL;

    @BeforeSuite
    public void setUp() {
        String propertyPath = System.getProperty("user.dir") + "//src//test//resources//Env.properties";
        try {
        	
            driver = BaseClass.init_driver("chrome");
            properties = utility.loadProperties(propertyPath);
            URL = properties.getProperty("URL");
            homePage = new HomePage(driver);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterSuite
    public void destroyDriver() {
        driver.quit();
    }
}