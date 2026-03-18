package ___Ejer_Corregido;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese una esquina del 1er rectángulo: ");
        double a1 = sc.nextDouble();
        double a2 = sc.nextDouble();
        System.out.print("Ingrese la esquina opuesta del 1er rectángulo: ");
        double a3 = sc.nextDouble();
        double a4 = sc.nextDouble();
        
        Coordenada c1 = new Coordenada(a1, a2);
        Coordenada c2 = new Coordenada(a3, a4);
        Rectangulo A = new Rectangulo(c1, c2);

        System.out.print("Ingrese una esquina del 2do rectángulo: ");
        double b1 = sc.nextDouble();
        double b2 = sc.nextDouble();
        System.out.print("Ingrese la esquina opuesta del 2do rectángulo: ");
        double b3 = sc.nextDouble();
        double b4 = sc.nextDouble();
        
        Coordenada c3 = new Coordenada(b1, b2);
        Coordenada c4 = new Coordenada(b3, b4);
        Rectangulo B = new Rectangulo(c3, c4);

        mostrarRectangulo(A, "A");
        mostrarRectangulo(B, "B");

        if (Verificador.esSobrePos(A, B)) {
            System.out.println("Rectangulos A y B se sobreponen");
            Rectangulo sobre = rectanguloSobre(A, B);
            System.out.println("Area de sobreposicion = " + sobre.calculoArea());
        } else if (Verificador.esJunto(A, B)) {
            System.out.println("Rectangulos A y B se juntan");
        } else {
            System.out.println("Rectangulos A y B son disjuntos");
        }

        sc.close();
    }

    public static void mostrarRectangulo(Rectangulo r, String nombre) {
        System.out.println("Rectangulo " + nombre + " = " + r);
    }

    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
    	double x1;
    	if (r1.getEsquina1().getX() > r2.getEsquina1().getX()) {
            x1 = r1.getEsquina1().getX(); 
        } else {
            x1 = r2.getEsquina1().getX(); 
        }
    	
    	double y1;
    	if (r1.getEsquina1().getY() > r2.getEsquina1().getY()) {
            y1 = r1.getEsquina1().getY();
        } else {
            y1 = r2.getEsquina1().getY(); 
        }
    	
    	double x2;
    	if (r1.getEsquina2().getX() < r2.getEsquina2().getX()) {
            x2 = r1.getEsquina2().getX();  
        } else {
            x2 = r2.getEsquina2().getX(); 
        }
    	
    	double y2;
    	if (r1.getEsquina2().getY() < r2.getEsquina2().getY()) {
            y2 = r1.getEsquina2().getY();  
        } else {
            y2 = r2.getEsquina2().getY(); 
        }
    	
    	Coordenada ca = new Coordenada(x1, y1);
        Coordenada cb = new Coordenada(x2, y2);
        return new Rectangulo(ca, cb);
    }
}