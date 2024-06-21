package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;
    private By bookStoreTabElement = By.xpath("//div[text()='Book Store Application']");


    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToBookStore(){
        driver.findElement(bookStoreTabElement).click();
    }
}
