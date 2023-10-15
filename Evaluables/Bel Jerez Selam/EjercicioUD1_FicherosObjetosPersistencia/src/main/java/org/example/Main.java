package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;

public class Main implements Serializable {
    static File file = new File("src/main/resources/viajes.dat");
    static File newFile = new File("src/main/resources/viajes.xml");

    public static void main(String[] args) throws FileNotFoundException {
        ListaViajes viajes = objetenerViajes(file);
        convertirXML(viajes);
    }

    public static ListaViajes objetenerViajes(File file) {
        ListaViajes listaViajes = new ListaViajes();
        Viaje viaje;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                viaje = (Viaje) objectInputStream.readObject();
                System.out.println(viaje);
                listaViajes.add(viaje);
            }
        } catch (EOFException IGNORED) {
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return listaViajes;
    }

    public static void convertirXML(ListaViajes listaViajes) throws FileNotFoundException {

        XStream xStream = new XStream();

        xStream.processAnnotations(Viaje.class);
        xStream.processAnnotations(Etapa.class);
        xStream.processAnnotations(Hotel.class);
        xStream.processAnnotations(Lugar.class);

        xStream.addImplicitCollection(Viaje.class, "estapas");
        xStream.addImplicitCollection(Etapa.class, "puntosVisita");
        xStream.addImplicitCollection(ListaViajes.class, "lista");


        try {
            xStream.toXML(listaViajes, new FileOutputStream(newFile));
            System.out.println("Creado con exito.");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }
}