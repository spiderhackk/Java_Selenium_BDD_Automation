import org.example.BaseApp;
import org.example.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseApp {


    BaseApp base = new BaseApp();
    WebDriver driver = base.setUp();
    @BeforeTest
    public void launchTheBrowser() {
        base.setUp();
    }

    @Test
    public void navigateToBookPage() {
        DashboardPage dpage = new DashboardPage(driver);
        dpage.navigateToBookStore();

    }

    @AfterTest
    public void closeBrowser() {
        base.tearDown();
    }
}
