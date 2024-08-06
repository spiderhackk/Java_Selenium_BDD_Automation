package definations;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.BaseApp;
import org.example.DashboardPage;
import org.openqa.selenium.WebDriver;

public class DashboardTest extends BaseApp {


    BaseApp base = new BaseApp();
    WebDriver driver;
    DashboardPage dpage;
    String[] expectedHeaderNames = {"Image", "Title", "Author", "Publisher"};
    String bookName="Git Pocket Guide";


    @Given("Launch the browser")
    public void launch_the_browser() {
        driver = base.setUp();
        dpage = new DashboardPage(driver);
    }

    @When("User navigate to the book store page")
    public void user_navigate_to_the_book_store_page() {
        dpage.navigateToBookStore();

    }
    @Then("Validate the table data displayed correctly")
    public void validate_the_table_data_displayed_correctly(){
        dpage.compareTableData(expectedHeaderNames);
    }

    @Then("Validate the search option")
    public void validate_the_search_option(){
        dpage.validateTheSearchBox(bookName);
    }

    @After
    public void closeBrowser() {
        base.tearDown();
    }


}
