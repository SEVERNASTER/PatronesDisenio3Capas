package negocio.factories;

import datos.Bebida;
import datos.Producto;


public class BebidaFactory extends ProductoFactory {
    @Override
    public Producto crearProducto(String tipo) {
        switch (tipo) {
            case "COCA": return new Bebida("Coca-Cola", 3.00);
            case "JUGO": return new Bebida("Jugo Natural", 4.00);
            default: return new Bebida("Agua", 2.00);
        }
    }
}