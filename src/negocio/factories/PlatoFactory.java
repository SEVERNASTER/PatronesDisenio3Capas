package negocio.factories;

import datos.Producto;
import datos.PlatoFuerte;

public class PlatoFactory extends ProductoFactory {
    @Override
    public Producto crearProducto(String tipo) {
        switch (tipo) {
            case "HAMBURGUESA": return new PlatoFuerte("Hamburguesa", 12.00);
            case "PIZZA": return new PlatoFuerte("Pizza", 15.00);
            default: return new PlatoFuerte("Ensalada", 8.00);
        }
    }
}