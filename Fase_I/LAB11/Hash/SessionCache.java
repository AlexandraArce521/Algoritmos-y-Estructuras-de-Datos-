package Hash;
import LINKEDlist.ListLinked;

public class SessionCache {

    private ListLinked<Session>[] tabla;
    private int tamaño;

    @SuppressWarnings("unchecked")
    public SessionCache(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new ListLinked[tamaño];

        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new ListLinked<>();
        }
    }

    private int hash(String token) {
        return Math.abs(token.hashCode()) % tamaño;
    }


    public void login(String token, String usuario, String rol, long tiempoVidaMs) {
        long expiracion = System.currentTimeMillis() + tiempoVidaMs;
        int indice = hash(token);
        Session sesion = new Session(token, usuario, rol, expiracion);
        tabla[indice].insertLast(sesion);
    }


    public Session validate(String token) {
        int indice = hash(token);

        for (int i = 0; i < tabla[indice].size(); i++) {
            Session sesion = tabla[indice].get(i);

            if (sesion.getToken().equals(token)) {
                if (sesion.getExpiresAt() >= System.currentTimeMillis()) {
                    return sesion;
                } else {
                    tabla[indice].removeNode(sesion);
                    return null;
                }
            }
        }
        return null;
    }


    public void logout(String token) {
        int indice = hash(token);

        for (int i = 0; i < tabla[indice].size(); i++) {
            Session sesion = tabla[indice].get(i);

            if (sesion.getToken().equals(token)) {
                tabla[indice].removeNode(sesion);
                return;
            }
        }
    }


    public void cleanExpired() {
        long ahora = System.currentTimeMillis();

        for (int i = 0; i < tamaño; i++) {
            int j = 0;

            while (j < tabla[i].size()) {
                Session sesion = tabla[i].get(j);

                if (sesion.getExpiresAt() < ahora) {
                    tabla[i].removeNode(sesion);
                } else {
                    j++;
                }
            }
        }
    }


    public void printTable() {
        System.out.println("\n===== SESSION CACHE =====");

        for (int i = 0; i < tamaño; i++) {
            System.out.print("[" + i + "] -> ");
            tabla[i].print();
        }
    }
}

