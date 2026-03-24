
public class Principal {

	public static void main(String[] args) {
		/*
		//Laptop
        Laptop l1 = new Laptop("Dell", 65, 55, 56);
        Laptop l2 = new Laptop("Dell", 65, 30, 56);
        Laptop l3 = new Laptop("HP", 45, 50, 40);

        if (l1.equals(l2)) {
            System.out.println("l1 es igual a l2 -> TRUE");
        } else {
            System.out.println("l1 es igual a l2 -> FALSE");
        }

        if (l1.equals(l3)) {
            System.out.println("l1 es igual a l3 -> TRUE");
        } else {
            System.out.println("l1 es igual a l3 -> FALSE");
        }
        
        //Smartphone
        Smartphone s1 = new Smartphone("Samsung S21", 15, 0);
        Smartphone s2 = new Smartphone("Samsung S21", 15, 0);
        Smartphone s3 = new Smartphone("iPhone 13", 20, 0);

        if (s1.equals(s2)) {
            System.out.println("s1 es igual a s2 -> TRUE");
        } else {
            System.out.println("s1 es igual a s2 -> FALSE");
        }

        if (s1.equals(s3)) {
            System.out.println("s1 es igual a s3 -> TRUE");
        } else {
            System.out.println("s1 es igual a s3 -> FALSE");
        }

        if (s1.equals(s1)) {
            System.out.println("s1 es igual a sí mismo -> TRUE");
        } else {
            System.out.println("s1 es igual a sí mismo -> FALSE");
        }

        if (s1.equals(null)) {
            System.out.println("s1 es igual a null -> TRUE");
        } else {
            System.out.println("s1 es igual a null -> FALSE");
        }
        */
		
		
        //Prueba estacion de carga

        PowerStation<Smartphone> estacion = new PowerStation<>(3);

        Smartphone s1 = new Smartphone("Samsung S21", 15, 0);
        Smartphone s2 = new Smartphone("iPhone 13", 20, 0);
        Smartphone s3 = new Smartphone("Xiaomi Mi 11", 18, 0);

        // Conectar dispositivos
        estacion.conectar(s1);
        estacion.conectar(s2);
        estacion.conectar(s3);

        // Mostrar reporte (posiciones 0,1,2)
        estacion.mostrarReporte();

        // Calcular consumo total
        System.out.println("Consumo total: " + estacion.calcularConsumo());

        // Buscar dispositivo existente (TRUE)
        Smartphone buscado1 = new Smartphone("Samsung S21", 15, 0);
        estacion.buscarDispositivo(buscado1);

        // Buscar dispositivo inexistente (FALSE)
        Smartphone buscado2 = new Smartphone("Huawei P30", 22, 0);
        estacion.buscarDispositivo(buscado2);
        
	} 

}
