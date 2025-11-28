package presentacion;

import datos.Producto;
import negocio.Pedido;
import negocio.decorators.ExtraQueso;
import negocio.decorators.ExtraTocino;
import negocio.factories.BebidaFactory;
import negocio.factories.PlatoFactory;
import negocio.factories.ProductoFactory;
import negocio.observers.Caja;
import negocio.observers.Cocina;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE RESTAURANTE (Arquitectura 3 Capas) ===\n");
        
        // 1. CAPA NEGOCIO (Factories): Crear productos
        System.out.println("1. FACTORY METHOD - Creando productos:");
        ProductoFactory fabricaBebidas = new BebidaFactory();
        ProductoFactory fabricaPlatos = new PlatoFactory();
        
        Producto coca = fabricaBebidas.crearProducto("COCA");
        Producto hamburguesa = fabricaPlatos.crearProducto("HAMBURGUESA");
        
        System.out.println("   Creado: " + coca.getNombre() + " - $" + coca.getPrecio());
        System.out.println("   Creado: " + hamburguesa.getNombre() + " - $" + hamburguesa.getPrecio());
        
        // 2. CAPA NEGOCIO (Decorators): Agregando extras
        System.out.println("\n2. DECORATOR - Agregando extras:");
        Producto hamburguesaCompleta = new ExtraTocino(new ExtraQueso(hamburguesa));
        
        System.out.println("   Original: " + hamburguesa.getNombre() + " - $" + hamburguesa.getPrecio());
        System.out.println("   Decorada: " + hamburguesaCompleta.getNombre() + " - $" + hamburguesaCompleta.getPrecio());
        
        // 3. CAPA NEGOCIO
        System.out.println("\n3. OBSERVER - Gestion del Pedido:");
        Pedido pedido = new Pedido();
        
        // Suscribir observadores
        pedido.agregarObservador(new Cocina());
        pedido.agregarObservador(new Caja());
        
        // Construir pedido
        pedido.agregarProducto(hamburguesaCompleta);
        pedido.agregarProducto(coca);
        
        // Cambios de estado
        pedido.cambiarEstado("EN PREPARACION");
        pedido.cambiarEstado("LISTO");
        pedido.cambiarEstado("ENTREGADO");
        
        pedido.mostrarPedidoDetallado();        
    }
}