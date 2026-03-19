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

import java.util.ArrayList;

public class Caja <T>{
	private String color;
	private ArrayList<T> lista = new ArrayList<T>();
	
	public Caja(String color) {
		this.setColor(color);
	}
	
	public void add(T objeto) {
	    lista.add(objeto);
	}
	
	public void mostrar() {
	    for(T e: lista) {
	        System.out.print("\n" + e + " ");
	    }
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ArrayList<T> getCaja() {
		return lista;
	}

	public void setCaja(ArrayList<T> caja) {
		this.lista = lista;
	}
}
