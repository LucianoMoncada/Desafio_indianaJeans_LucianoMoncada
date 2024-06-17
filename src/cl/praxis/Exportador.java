package cl.praxis;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Exportador {
    public abstract void exportar(ArrayList<Producto> listaProductos, String archivo) throws IOException;
}
