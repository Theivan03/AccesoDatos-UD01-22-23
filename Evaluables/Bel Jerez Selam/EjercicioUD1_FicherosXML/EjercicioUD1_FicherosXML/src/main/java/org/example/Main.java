package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static File viajes = new File("src/main/resources/viajes.dat");

    public static void main(String[] args) throws FileNotFoundException {
        EJ1();

    }



    public static void EJ1() throws FileNotFoundException {
        ArrayList<Viaje> viajesLista = new ArrayList<>();
        Viaje viajeActual;
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(viajes))) {
            try {
                while (true) {
                    viajeActual = (Viaje) lector.readObject();
                    System.out.println(viajeActual);
                    viajesLista.add(viajeActual);
                }
            } catch (EOFException ignored) {
            }
        } catch (IOException e) {
            System.out.println("ERROR EN EL FICHERO: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }


        // GENERAR XML
        XStream xstream = new XStream();
        xstream.processAnnotations(Viaje.class);
        xstream.processAnnotations(Etapa.class);
        xstream.processAnnotations(Lugar.class);
        xstream.processAnnotations(Hotel.class);

//        xstream.addImplicitCollection(ListaCanciones.class, "lista");

        xstream.toXML(viajesLista, new FileOutputStream("src/main/resources/VIAJES_EJ1.xml"));


    }





}