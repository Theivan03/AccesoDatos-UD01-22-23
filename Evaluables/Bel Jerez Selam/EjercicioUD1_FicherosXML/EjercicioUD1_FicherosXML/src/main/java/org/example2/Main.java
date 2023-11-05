package org.example2;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static File institutoXML = new File("src/main/resources/instituto.xml");
    public static void main(String[] args) {
    EJ2();
    }

    private static void EJ2() {
        ArrayList<Instituto> institutos = new ArrayList<>();
        Instituto instiActual;
        try (ObjectInputStream LECTOR = new ObjectInputStream(new FileInputStream(institutoXML))){
            while (true){
                instiActual = (Instituto) LECTOR.readObject();
                System.out.println(instiActual);
                institutos.add(instiActual);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
