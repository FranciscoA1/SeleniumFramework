package data;


import org.testng.annotations.DataProvider;
import reader.ExcelReader;

public class CustomData {
    public static final String DP_NAME = "Data Ejemplo";

    @DataProvider(name = DP_NAME)
    public static Object[][] dataProvider() {

        final var listaProductos = ExcelReader.obtenerListaProductos();

        final var n = listaProductos.size();
        final var object =  new Object[n][];

        for (var i = 0; i < n; i++) {
            object[i] = new Object[]{listaProductos.get(i)};
        }

        return object;
    }
}
