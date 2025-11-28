package negocio.observers;



public class Caja implements Observador {
    @Override
    public void notificar(String mensaje) {
        System.out.println("  [CAJA] " + mensaje);
    }
}