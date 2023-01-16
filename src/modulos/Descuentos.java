package modulos;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Descuentos {

    public static HashMap<String, Integer> descuentos = new HashMap<>();

    private static boolean cargarDescuentosHashMap() {

        try {
            // Lee de archivo llamado "descuentos.txt" en la raíz del proyecto
            FileReader entrada = new FileReader("./descuentos.txt");

            //Creación BufferedReader
            BufferedReader bfr = new BufferedReader(entrada);

            String linea;
            while ((linea = bfr.readLine()) != null) {

                // Hago split por "," y almaceno tanto código como descuento en un String[]
                String[] codigoYDescuento = linea.split(",");

                //Lo cargo en un HashMap, parseo valor descuento a Integer para poder operar con él más tarde
                descuentos.put(codigoYDescuento[0], Integer.valueOf(codigoYDescuento[1]));
            }

            bfr.close();
            entrada.close();
            return true;

        } catch (FileNotFoundException fnf) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ioe) {
            System.out.println("InputOutput Exception");
        }
        return false;
    }

    private static boolean cargarDescuentosTXT() {

        try {
            // Asigno el archivo que será actualizado
            FileWriter salida = new FileWriter("./descuentos.txt");

            // Objeto BufferedWriter para escribir en dicho fichero asignado como salida
            BufferedWriter bfw = new BufferedWriter(salida);

            for (Map.Entry<String, Integer> elemento : descuentos.entrySet()) {
                // Escribo en el fichero código de descuento "," y valor del descuento en formato CSV("CÓDIGO,VALOR")
                bfw.write(elemento.getKey() + "," + elemento.getValue().toString() + "\n");
            }

            bfw.close();
            salida.close();
            return true;

        } catch (IOException ioe) {
            System.out.println("InputOutput exception");
        }
        return false;
    }

    public static void mostrarDescuentosActuales() {
        descuentos.clear();
        Descuentos.cargarDescuentosHashMap();
        System.out.println("\u001B[31m Los descuentos actuales son:");

        for (Map.Entry<String, Integer> descuento : descuentos.entrySet()) {
            System.out.println("\u001B[34m Código: " + "\u001B[35m" + descuento.getKey() + " => " + "\u001B[33m" + descuento.getValue() + "% \u001B[0m"); // Reset color por defecto
        }
    }

    public static int porcentajeDescuento(String codDescuento) {
        codDescuento = codDescuento.toUpperCase();
        descuentos.clear();
        Descuentos.cargarDescuentosHashMap();
        // Busco en el mapa
        Integer porcentajeDescuento = descuentos.get(codDescuento);
        // Si no encuentra match ...
        if (porcentajeDescuento != null) {
            return porcentajeDescuento;
        } else {
            return -1;
        }
    }

    public static boolean existeDescuento(String codDescuento) {
        codDescuento = codDescuento.toUpperCase();
        descuentos.clear();
        Descuentos.cargarDescuentosHashMap();

        if (descuentos.get(codDescuento) == null) {
            return false;
        }
        return true;

    }

    public static void Admin_addDescuento(String codDescuento, Integer porcentajeDescuento) {
        codDescuento = codDescuento.toUpperCase();
        descuentos.clear();
        Descuentos.cargarDescuentosHashMap();
        descuentos.put(codDescuento, porcentajeDescuento);
        Descuentos.cargarDescuentosTXT();
    }

    public static boolean Admin_deleteDescuento(String codDescuento) {
        codDescuento = codDescuento.toUpperCase();
        descuentos.clear();
        Descuentos.cargarDescuentosHashMap();

        boolean encontrado = descuentos.containsKey(codDescuento);

        if (encontrado) {
            descuentos.remove(codDescuento);
            Descuentos.cargarDescuentosTXT();
            return true;
        } else {
            return false;
        }
    }

}
