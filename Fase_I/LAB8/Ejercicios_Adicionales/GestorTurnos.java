package EjerciciosExtras;
import AVLTREE.*;
import Exceptions.*;

public class GestorTurnos {
    private AVLTree<Integer> arbolTurnos;

    private int turnosAtendidos;

    public GestorTurnos() {
        this.arbolTurnos = new AVLTree<>();
        this.turnosAtendidos = 0;
    }

    public AVLTree<Integer> getArbolTurnos() {
        return arbolTurnos;
    }

    public int getTurnosAtendidos() {
        return turnosAtendidos;
    }

    //=============================================
    public void registrarTurno(int turno) {
        try {
            arbolTurnos.insert(turno);
            System.out.println("  ✔ Turno [" + turno + "] registrado.");
        } catch (ItemDuplicated e) {
            System.out.println("  ✘ El turno [" + turno + "] ya está registrado.");
        }
    }

    //=======================================
    public boolean buscarTurno(int turno) {
        try {
            arbolTurnos.search(turno);
            System.out.println("  ✔ Turno [" + turno + "] está pendiente de atención.");
            return true;
        } catch (ItemNoFound e) {
            System.out.println("  ✘ Turno [" + turno + "] no encontrado (ya atendido o no existe).");
            return false;
        }
    }

    //=========================
    public void atenderTurno(int turno) {
        try {
            arbolTurnos.delete(turno);
            turnosAtendidos++;
            System.out.println("  ✔ Turno [" + turno + "] atendido y retirado del sistema.");
        } catch (ExceptionIsEmpty e) {
            System.out.println("  ✘ No hay turnos en el sistema.");
        }
    }

    //========================================
    public void mostrarTurnosPendientes() {
        System.out.println("  Turnos pendientes (InOrden): " + arbolTurnos.getInOrder());
    }

    //=========================
    public void mostrarArbol() {
        System.out.println("  Estructura del árbol de turnos:");
        arbolTurnos.drawBST();
    }

    //====================================================
    public void mostrarPorNiveles() {
        System.out.print("  Recorrido por niveles: ");
        arbolTurnos.recorridoPorAmplitudRecursivo();
    }

    //========================
    public void mostrarEstadisticas() {
        System.out.println("  Turnos pendientes en sistema: " + arbolTurnos.countAllNodes());
        System.out.println("  Turnos ya atendidos:          " + turnosAtendidos);
        if (arbolTurnos.getRoot() != null) {
            System.out.println("  Altura actual del árbol:      " + arbolTurnos.height(arbolTurnos.getRoot().data));
            System.out.println("  Raíz actual del árbol:        " + arbolTurnos.getRoot().data);
        }
    }
}
