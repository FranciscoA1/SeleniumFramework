package automation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestPage;
import utilities.BaseTest;


public class AutomaTests extends BaseTest {

    private final TestPage testPage = new TestPage();


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFLows.goToUrl();
    }

    @Test(groups = {regression})
    public void primerTest() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("standard_usersx", "https://www.saucedemo.com/");

        
    }

    @Test(groups = {smoke, regression})
    public void validarPage() {
        testPage.verifyPage();
    }
}
