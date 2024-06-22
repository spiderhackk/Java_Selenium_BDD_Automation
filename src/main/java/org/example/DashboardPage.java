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
    private By inputSearchBox = By.xpath("//input[@id='searchBox']");
    private By searchButton = By.xpath("//span[@id='basic-addon2']");
    private By resultList = By.xpath("//div[@class='rt-tr-group']//a");
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


    public void validateTheSearchBox(String searchItemName){
        driver.findElement(inputSearchBox).sendKeys(searchItemName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(searchButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> element = driver.findElements(resultList);
        int elementsCount = element.size();
        for (int i =1;i<=elementsCount;i++){
            WebElement getBookName = driver.findElement(By.xpath("(//div[@class='rt-tr-group']//a)["+ i +"]"));
            String bookName =getBookName.getText();
            if (bookName.equals(searchItemName)){
                System.out.println("Book name matched");
            }
            else{
                System.out.println("Result not found");
            }

        }

    }
}
