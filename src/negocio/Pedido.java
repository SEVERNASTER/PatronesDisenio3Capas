package negocio;


import datos.Producto;
import negocio.observers.Observador;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Producto> productos = new ArrayList<>();
    private List<Observador> observadores = new ArrayList<>();
    private String estado = "NUEVO";
    
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }
    
    private void notificarTodos(String mensaje) {
        for (Observador o : observadores) {
            o.notificar(mensaje);
        }
    }
    
    public void agregarProducto(Producto p) {
        productos.add(p);
    }
    
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarTodos("Pedido cambió a: " + estado);
    }
    
    public double getTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }
    
    public void mostrarPedidoDetallado() {
        System.out.println("\n--- PEDIDO (" + estado + ") ---");
        for (Producto p : productos) {
            System.out.printf("  %-35s $%.2f%n", p.getNombre(), p.getPrecio());
        }
        System.out.printf("  TOTAL:                              $%.2f%n", getTotal());
    }
}