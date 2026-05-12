package Exceptions;

public class ExceptionIsEmpty extends Exception {
	public ExceptionIsEmpty (String mensaje) {
		super(mensaje);
	}
	
	public ExceptionIsEmpty() {
		super("El arbol esta vacio");
	}
}
