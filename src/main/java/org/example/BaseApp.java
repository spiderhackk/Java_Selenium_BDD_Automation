package org.example;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.Utilities;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseApp {

    protected WebDriver driver;
    public WebDriver setUp() {
        String browser = Utilities.getProperty("browser");
        String url = Utilities.getProperty("baseUrl");
        switch (browser.toLowerCase()){
            case "chrome":
                System.out.println("---------- Chrome browser is starting----------");
                driver = new ChromeDriver();
                break;
            case "safari":
                System.out.println("---------- Safari browser is starting----------");
                driver = new SafariDriver();
                break;
            case "firefox":
                System.out.println("---------- Firefox browser is starting----------");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.out.println("---------- Edge browser is starting----------");
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser "+browser+" browser not found");
        }
        driver.get(url);
        driver.manage().window().fullscreen();
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        return driver;
    }
    public void tearDown(){
        driver.quit();
    }
}
