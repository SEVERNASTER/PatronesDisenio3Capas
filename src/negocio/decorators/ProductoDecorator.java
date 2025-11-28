package negocio.decorators;

import datos.Producto;

public abstract class ProductoDecorator implements Producto {
    protected Producto producto;
    
    public ProductoDecorator(Producto producto) {
        this.producto = producto;
    }
}
