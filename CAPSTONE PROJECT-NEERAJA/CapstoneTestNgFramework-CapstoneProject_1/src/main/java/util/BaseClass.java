package util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    public static  WebDriver driver;
    public static WebDriverWait wait;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    public static WebDriver init_driver(String browser) throws Exception {

		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver","C:\\Softwares\\chromedriver-win64\\chromedriver.exe");
			driver=new ChromeDriver(options);
		} 
		
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		} 
		
		else if (browser.equals("safari")) {
			driver = new SafariDriver();

		} 
		
		else {
			System.out.println("Please pass a proper browser value: " + browser);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		return driver;

	}

}
