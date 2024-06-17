package cl.praxis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExportadorTxt extends Exportador {
    @Override
    public void exportar(ArrayList<Producto> listaProductos, String archivo) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
        for (Producto producto : listaProductos) {
            writer.write(producto.toString());
            writer.newLine();
        }
        writer.close();
    }
}
