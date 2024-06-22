package org.example;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseApp {

    WebDriver driver = new ChromeDriver();
    public WebDriver setUp() {
        driver.get("https://demoqa.com/books");
        driver.manage().window().fullscreen();
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        return driver;
    }
    public void tearDown(){
        driver.quit();
    }
}
