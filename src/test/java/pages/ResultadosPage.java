package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class ResultadosPage extends BasePage {

    private final By tituloResultadosBusqueda = By.xpath("//*[@id=\"app\"]/div/div[3]/h2");
    private final By listaCanciones = By.xpath("//*[@id=\"app\"]/div/div[3]/table/tbody/tr/td[1]");
    private final By listaFavoritos = By.xpath("//*[@id=\"app\"]/div/div[4]/table/tbody/tr/td[1]");

    private final By totalAlbunes = By.xpath("//*[@id=\"app\"]/div/div[2]/p[1]");
    private final By totalCanciones = By.xpath("//*[@id=\"app\"]/div/div[2]/p[2]");
    private final By buttonAgregarFavorito = By.xpath("//*[@id=\"app\"]/div/div[3]/table/tbody/tr[1]/td[6]/button");

    @Override
    public void waitPageLoad() {
        waitPage(tituloResultadosBusqueda, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertEquals(find(tituloResultadosBusqueda).getText(), "Resultados de Búsqueda");
        softAssert.assertTrue(find(listaCanciones).isDisplayed());
        softAssert.assertTrue(find(totalAlbunes).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Agregar cancion a favoritos")
    public void agregarCancionAFavoritos() {
        final var totalFavoritas = findAll(listaFavoritos).size();
        Logs.debug("Total de canciones favoritas: %s", totalFavoritas);

        find(buttonAgregarFavorito).click();


        final var newTotalFavoritas = findAll(listaFavoritos).size();
        Logs.debug("Total de canciones favoritas: %s", newTotalFavoritas);

        softAssert.assertTrue(newTotalFavoritas > totalFavoritas);

    }

    @Step("Obtener el total de canciones")
    public void validarTotalCanciones() {
        final var total =find(totalCanciones).getText();
        final var totalNum = total.replaceAll("[^0-9]", "");
        Logs.debug("Total de canciones: %s", totalNum);
        softAssert.assertTrue(Integer.parseInt(totalNum) <= 25);
        softAssert.assertAll();
    }


}
