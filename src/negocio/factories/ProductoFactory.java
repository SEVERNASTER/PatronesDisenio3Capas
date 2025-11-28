package negocio.factories;
import datos.Producto;

public abstract class ProductoFactory {
    public abstract Producto crearProducto(String tipo);
}
