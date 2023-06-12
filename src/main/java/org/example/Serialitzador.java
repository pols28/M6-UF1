package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialitzador {
    public static void main(String[] args) throws IOException {
        ArrayList<ArticlesCompra> llistaCompra = new ArrayList<>();
        serialitzaLlistaCompra(llistaCompra);
    }

    private static void serialitzaLlistaCompra(ArrayList<ArticlesCompra> llistaCompra) {
        try {
            FileOutputStream fileOut = new FileOutputStream("llista_compra.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(llistaCompra);
            objectOut.close();
            fileOut.close();
            System.out.println("Fitxer serialitzat.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
