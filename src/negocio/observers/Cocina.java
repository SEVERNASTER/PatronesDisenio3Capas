package negocio.observers;



public class Cocina implements Observador {
    @Override
    public void notificar(String mensaje) {
        System.out.println("  [COCINA] " + mensaje);
    }
}