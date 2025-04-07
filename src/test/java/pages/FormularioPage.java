package pages;

import io.qameta.allure.Step;
import models.Producto;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.BasePage;
import utilities.Logs;

import static java.lang.Thread.sleep;

public class FormularioPage extends BasePage {

    private final By FormNombre = By.xpath("//*[@id=\"user-name\"]");

    @Override
    public void waitPageLoad() {

    }

    @Step("Verificando la UI de la pagina...")
    public void verifyPage() {
        Logs.info("Verificando la UI de la pagina");
    }

    @Step("Llenar formulario")
    public void llenarFormulario(Producto producto) throws InterruptedException {
        Logs.info("Llenar formulario");
        find(FormNombre).sendKeys(producto.getNombre());
        sleep(4000);

    }
}
