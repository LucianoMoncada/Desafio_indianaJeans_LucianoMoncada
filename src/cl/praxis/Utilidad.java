package cl.praxis;

public class Utilidad {
    public static void limpiarPantalla() {
        // Esto funciona solo en sistemas basados en Unix/Linux
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}