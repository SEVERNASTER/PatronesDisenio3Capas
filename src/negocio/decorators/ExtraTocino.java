package negocio.decorators;

import datos.Producto;

public class ExtraTocino extends ProductoDecorator {
    public ExtraTocino(Producto producto) {
        super(producto);
    }
    
    @Override
    public String getNombre() { return producto.getNombre() + " + Tocino"; }
    
    @Override
    public double getPrecio() { return producto.getPrecio() + 3.00; }
}
