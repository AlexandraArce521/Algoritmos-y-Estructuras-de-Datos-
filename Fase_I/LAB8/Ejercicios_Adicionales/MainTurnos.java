package EjerciciosExtras;


public class MainTurnos {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE TURNOS - CLÍNICA AVL        ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        GestorTurnos gestor = new GestorTurnos();

        System.out.println("[ 1 ] Registrando turnos del día...");
        int[] turnos = {10, 20, 30, 5, 15, 25, 35};
        for (int turno : turnos) {
            gestor.registrarTurno(turno);
        }

        System.out.println("\n  Intentando registrar turno duplicado (20):");
        gestor.registrarTurno(20);

        System.out.println("\n[ 2 ] Turnos pendientes:");
        gestor.mostrarTurnosPendientes();

        System.out.println("\n[ 3 ] Estructura del árbol de turnos:");
        gestor.mostrarArbol();

        System.out.println("\n[ 4 ] Búsqueda de turnos:");
        gestor.buscarTurno(15);   
        gestor.buscarTurno(99);    

        System.out.println("\n[ 5 ] Atendiendo pacientes...");
        gestor.atenderTurno(10); 
        gestor.atenderTurno(5);   
        gestor.atenderTurno(30);  

        System.out.println("\n  Turnos restantes tras atenciones:");
        gestor.mostrarTurnosPendientes();

        System.out.println("\n[ 6 ] Árbol actualizado:");
        gestor.mostrarArbol();

        System.out.println("\n[ 7 ] Estadísticas del sistema:");
        gestor.mostrarEstadisticas();

        System.out.println("\n[ 8 ] Recorrido por niveles:");
        gestor.mostrarPorNiveles();

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║   FIN DEL SISTEMA DE TURNOS               ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }
}
