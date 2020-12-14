package DriverWrapper;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    private static WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");
        driver = new ChromeDriver();
//        driver.get("https://www.facebook.com/");
        driver.get("http://www.hotels.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void quitDriver() { driver.quit(); }

    public static WebDriver getDriver() {
        return driver;
    }
}
