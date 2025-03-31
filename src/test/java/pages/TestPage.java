package pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.Logs;
import io.qameta.allure.Step;

public class TestPage extends BasePage {
    private final By headerContainer = By.cssSelector("#root > div > div.login_logo");

    @Override
    @Step("Esperando que la pagina cargue...")
    public void waitPageLoad() {
        waitPage(headerContainer, this.getClass().getSimpleName());
    }

    @Override
    @Step("Verificando la UI de la pagina...")
    public void verifyPage() {
        Logs.info("Verificando la UI de la pagina");
        softAssert.assertTrue(find(headerContainer).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Clic en el boton de logout")
    public void logOut() {
        find(By.className("bm-burger-button")).click();
        find(By.className("bm-cross-button")).click();
    }
}
