package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DashboardPage {

    private WebDriver driver;
    private By ListOfHeaderName = By.xpath("//div[@class='rt-table']/div[@class='rt-thead -header']/div/div");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToBookStore() {
        WebElement element = driver.findElement(By.xpath("//div[@class='rt-table']"));
        boolean is_visible = element.isDisplayed();

        if (is_visible){
            System.out.println("Element is displayed");
        }
        else{
            System.out.println("Element not displayed");
        }


    }

    public void compareTableData(String[] expectedHeaderList){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> header_name = driver.findElements(ListOfHeaderName);
        int i = 0;
        for (WebElement val : header_name) {
            String get_header_name = val.getText();
            if (get_header_name.equals(expectedHeaderList[i])) {
                System.out.println("Header's matched successfully");
            } else {
                System.out.println("Header's is not mactched");
            }
            i++;
        }
    }
}
