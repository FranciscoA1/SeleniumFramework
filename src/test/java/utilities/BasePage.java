package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    private final static int defaultTimeout = 12;
    private final int TIMEOUT;
    protected final SoftAssert softAssert;

    public BasePage(int TIMEOUT) {
        this.TIMEOUT = TIMEOUT;
        softAssert = new SoftAssert();
    }
    public BasePage() {
        this(defaultTimeout);
    }

    protected WebDriver getDriver() {
        return new WebDriverProvider().get();
    }

    protected void waitPage(By locator,String pageName) {
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT));
        Logs.info("Esperando que la pagina %s cargue...", pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Logs.info("Pagina %s cargada correctamente", pageName);
    }

    protected WebElement find(By locator) {
        return getDriver().findElement(locator);
    }
    protected List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }


    public abstract void waitPageLoad();
    public abstract void verifyPage();

}