public class Main {
	public static void main(String[] args) {
		Chocolatina c1 = new Chocolatina("milka");
		Chocolatina c2 = new Chocolatina("Carmelo");
		Chocolatina c3 = new Chocolatina("chocol");
		Chocolatina c4 = new Chocolatina("chocol");
		Chocolatina c5 = new Chocolatina("Merma");
		
		Golosina g1 = new Golosina("Sugus", 10.7);
		Golosina g2 = new Golosina("Pulparindo", 9.7);
		Golosina g3 = new Golosina("Menta", 6.7);
		Golosina g4 = new Golosina("Sugus", 10.7);
		Golosina g5 = new Golosina("Caramelo", 2.8);
		
		Caja<Golosina> cajita1 = new Caja<Golosina>("Amarillo",g1);
		Caja<Golosina> cajita2 = new Caja<Golosina>("Verde", g2);
		Caja<Golosina> cajita3 = new Caja<Golosina>("Negro",g3);
		Caja<Golosina> cajita4 = new Caja<Golosina>("Morado",g4);
		Caja<Golosina> cajita5 = new Caja<Golosina>("Rosado",g5);
		
		Caja<Chocolatina> cajita6 = new Caja<Chocolatina>("Rojo", c1);
		Caja<Chocolatina> cajita7 = new Caja<Chocolatina>("Blanco", c2);
		Caja<Chocolatina> cajita8 = new Caja<Chocolatina>("Azul", c3);
		Caja<Chocolatina> cajita9 = new Caja<Chocolatina>("Beige", c4);
		Caja<Chocolatina> cajita10 = new Caja<Chocolatina>("Celeste", c5);
		
		Cajoneria<Golosina> cajoneriaG = new Cajoneria<>(10);
		cajoneriaG.add(cajita1);
		cajoneriaG.add(cajita2);
		cajoneriaG.add(cajita3);
		cajoneriaG.add(cajita4);
		cajoneriaG.add(cajita5);
		System.out.println("Cajoneria de golosinas \n" + cajoneriaG);
		System.out.println("Buscando Sugus: " + cajoneriaG.search(g4));
		System.out.println("Cantidad de Sugus: " + cajoneriaG.contar(g4));
		System.out.println(cajoneriaG.delete(g2));
		System.out.println(cajoneriaG);
		
		Cajoneria<Chocolatina> cajoneriaC = new Cajoneria<>(7);
		cajoneriaC.add(cajita6);
		cajoneriaC.add(cajita7);
		cajoneriaC.add(cajita8);
		cajoneriaC.add(cajita9);
		cajoneriaC.add(cajita10);
		System.out.println("Cajoneria de Chocolatinas \n" + cajoneriaC);
		System.out.println("Buscando chocol: " + cajoneriaC.search(c3));
		System.out.println("Cantidad de chocol: " + cajoneriaC.contar(c3));
		System.out.println(cajoneriaC.delete(c1));
		System.out.println(cajoneriaC);
		
	}
}
