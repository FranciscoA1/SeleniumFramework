package parser;

import models.Producto;
import reader.ExcelReader;

import java.util.HashMap;
import java.util.Map;

public class ProductoParser {
    public static Map<String, Producto> getMapProductos() {
        final var listaProductos = ExcelReader.obtenerListaProductos();

        final var mapProductos = new HashMap<String, Producto>();

        for (var producto : listaProductos) {
            mapProductos.put(producto.getNombre(), producto);
        }
        return mapProductos;
    }
}
