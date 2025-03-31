package utilities;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {

    protected final CommonFLows commonFLows = new CommonFLows();
    protected final String regression = "regression";
    protected final String smoke = "smoke";

    private final DriverManager driverManager = new DriverManager();

    @BeforeMethod(alwaysRun = true)
    public void MasterSetUP() {
        driverManager.buildDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void MasterTearDown() {
        driverManager.killDriver();
    }
}
