package automation;

import data.CustomData;
import models.Producto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormularioPage;
import utilities.BaseTest;

public class FormularioTests extends BaseTest {

    FormularioPage formularioPage = new FormularioPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFLows.goToUrl();
    }

    @Test(
            groups = {regression},
            dataProvider = CustomData.DP_NAME,
            dataProviderClass = CustomData.class
    )
    public void llenarFormulario(Producto producto) throws InterruptedException {
        formularioPage.llenarFormulario(producto);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("standard_user", "https://www.saucedemo.com/");
        softAssert.assertAll();
    }
}
