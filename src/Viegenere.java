/**
 * Created by Everardo Ramirez on 21/05/2017.
 */
public class Viegenere {
    private static final String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz1234567890.,;: ";

    public static String codificar(String contra, String linea) {
        String contrasena = generarContraseña(contra, linea.length());
        int x, k, resultadoNumerico, j = 0;
        String resultado = "";
        for (char i : linea.toCharArray()) {
            x = alfabeto.indexOf(i);//posicion de la letra en el abeceario
            k = alfabeto.indexOf(contrasena.charAt(j));
            resultadoNumerico = (x + k) % alfabeto.length();
            resultado += alfabeto.charAt(resultadoNumerico);
            j++;
        }
        return resultado;
    }

    public static String decodificar(String contra, String linea) {
        String contrasena = generarContraseña(contra, linea.length());
        String resultado = "";
        int c, k, resultadoNumerico=0, j = 0;

        for (char i : linea.toCharArray()) {
            c = alfabeto.indexOf(i);
            k = alfabeto.indexOf(contrasena.charAt(j));
            if ((c - k) >= 0) {
                resultadoNumerico = (c - k) % alfabeto.length();
            } else if ((c - k) < 0) {
                resultadoNumerico = (c - k + alfabeto.length()) % alfabeto.length();
            }
            resultado += alfabeto.charAt(resultadoNumerico);
            j++;
        }
        return resultado;
    }

    private static String generarContraseña(String contra, int tamano) {
        int i = 0;
        String resultado = "";
        while (resultado.length() < tamano) {
            resultado += contra.charAt(i);
            i++;
            if (i >= contra.length()) i = 0;
        }
        return resultado;
    }
}
