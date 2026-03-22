

public class ContainerRect {
	private Rectangulo[] rectangulos;
    private double[]     distancias;
    private double[]     areas;
    private int          n;

    
    private static int numRec = 0;

    public ContainerRect(int n) {
        this.n        = n;
        rectangulos   = new Rectangulo[n];
        distancias    = new double[n];
        areas         = new double[n];
    }

    public void addRectangulo(Rectangulo r) {
        if (numRec < n) {
            rectangulos[numRec] = r;
            distancias[numRec]  = Coordenada.distancia(r.getEsquina1(), r.getEsquina2());
            areas[numRec]       = r.calculoArea();
            numRec++;
        } else {
            System.out.println("Capacidad maxima alcanzada, no se puede guardar mas");
        }
    }

    @Override
    public String toString() {
    	String texto = "Rectangulo   Coordenadas   Distancia   Area\n";

        for (int i = 0; i < numRec; i++) {
            texto = texto + (i + 1) + "   " + rectangulos[i].toString() + "   " + distancias[i] + "   " + areas[i] + "\n";
        }

        return texto;
    }

    public static int getNumRec() { 
    	return numRec; 
    }
}
