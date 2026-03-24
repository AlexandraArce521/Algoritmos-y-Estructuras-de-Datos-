
public class Verificador {
	public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        double r1x1 = r1.getEsquina1().getX();
        double r1x2 = r1.getEsquina2().getX();
        double r1y1 = r1.getEsquina1().getY();
        double r1y2 = r1.getEsquina2().getY();
        
        double r2x1 = r2.getEsquina1().getX(); 
        double r2x2 = r2.getEsquina2().getX();
        double r2y1 = r2.getEsquina1().getY();
        double r2y2 = r2.getEsquina2().getY();

        return (r2x1 < r1x2 && r1x1 < r2x2 && r2y1 < r1y2 && r1y1 < r2y2);
    }

    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        double r1x1 = r1.getEsquina1().getX();
        double r1x2 = r1.getEsquina2().getX();
        double r1y1 = r1.getEsquina1().getY();
        double r1y2 = r1.getEsquina2().getY();
        
        double r2x1 = r2.getEsquina1().getX();
        double r2x2 = r2.getEsquina2().getX();
        double r2y1 = r2.getEsquina1().getY();
        double r2y2 = r2.getEsquina2().getY();

        
        boolean xCruce = (r1x1 <= r2x2 && r2x1 <= r1x2);
        boolean yCruce = (r1y1 <= r2y2 && r2y1 <= r1y2);
        boolean xToque = (r1x2 == r2x1 || r2x2 == r1x1);
        boolean yToque = (r1y2 == r2y1 || r2y2 == r1y1);

        return (xToque && yCruce) || (yToque && xCruce);
    }

    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) { 
        return !(esSobrePos(r1, r2) || esJunto(r1, r2));
    }
}
