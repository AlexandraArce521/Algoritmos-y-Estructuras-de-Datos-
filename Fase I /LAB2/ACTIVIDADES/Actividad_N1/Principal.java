public class Principal {
	public static void main(String[] args) {

		
		Bolsa <Chocolatina> bolsaCho = new Bolsa <Chocolatina>(4);
		Chocolatina c = new Chocolatina("milka");
		Chocolatina c1 = new Chocolatina("milka");
		Chocolatina c2 = new Chocolatina("ferrero");
		
		bolsaCho.add(c);
		bolsaCho.add(c1);
		bolsaCho.add(c2);
		
		for (Chocolatina chocolatina: bolsaCho) {
			System.out.println(chocolatina.getMarca());
		}
	}
}


//*
public class Principal {
	public static void main(String[] args) {

		
		Bolsa <Chocolatina> bolsaCho = new Bolsa <Chocolatina>(4);
		Chocolatina c = new Chocolatina("milka");
		Chocolatina c1 = new Chocolatina("fresa");
		Chocolatina c2 = new Chocolatina("ferrero");
		
		bolsaCho.add(c);
		bolsaCho.add(c1);
		bolsaCho.add(c2);
		
		for (Chocolatina chocolatina: bolsaCho) {
			System.out.println(chocolatina.getMarca());
		}
		
		Caja <Chocolatina> cajaChocolatina = new Caja <Chocolatina> ("Rosa");
		cajaChocolatina.add(c);
		cajaChocolatina.add(c1);
		cajaChocolatina.add(c2);
		
		cajaChocolatina.mostrar();
	}
}
//*
