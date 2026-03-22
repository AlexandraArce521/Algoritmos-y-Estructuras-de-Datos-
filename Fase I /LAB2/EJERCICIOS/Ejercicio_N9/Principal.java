
public class Principal {

	public static void main(String[] args) {
	
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
	} 

}
