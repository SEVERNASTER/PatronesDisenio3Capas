package negocio.decorators;

import datos.Producto;

public class ExtraQueso extends ProductoDecorator {
    public ExtraQueso(Producto producto) {
        super(producto);
    }
    
    @Override
    public String getNombre() { return producto.getNombre() + " + Queso"; }
    
    @Override
    public double getPrecio() { return producto.getPrecio() + 2.00; }
}
