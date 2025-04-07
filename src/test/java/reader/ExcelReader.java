package reader;

import com.poiji.bind.Poiji;
import models.Producto;

import java.io.File;
import java.util.List;

public class ExcelReader {

    private final static String excelPath = "src/test/resources/data/dataExcel.xlsx";

    public static List<Producto> obtenerListaProductos() {
        return Poiji.fromExcel(new File(excelPath), Producto.class);
    }

}
