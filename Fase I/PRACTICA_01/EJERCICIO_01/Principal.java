package ___Ejerciio1_algoritmia;

import java.util.Scanner;

public class Principal {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("Ingrese la cantidad de rectangulos a almacenar: ");
		 int n = sc.nextInt();

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
		 
		 ContainerRect contenedor = new ContainerRect(n);
		 
		 contenedor.addRectangulo(A);
		 contenedor.addRectangulo(B);
		 
	     System.out.println("\nRectangulos: ");
	     System.out.print(contenedor);
	
	 }
}
