package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("src/main/resources/viajes.dat");
        ListaViajes listaViajes = readFile(archivo);
        writeXML(listaViajes);
    }

    public static void writeXML(ListaViajes listaViajes) {
        XStream xStream = new XStream();
        xStream.processAnnotations(Viaje.class);
        xStream.processAnnotations(Lugar.class);
        xStream.processAnnotations(Hotel.class);
        xStream.processAnnotations(Etapa.class);
        xStream.processAnnotations(ListaViajes.class);

        xStream.addImplicitCollection(ListaViajes.class, "lista");


        try {
            xStream.toXML(listaViajes, new FileOutputStream("src/main/resources/viajes.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("Se ha creado el fichero XML");

    }

    public static ListaViajes readFile(File archivo) {
        ListaViajes listaViajes = new ListaViajes();
        try {
            FileInputStream fileInput = new FileInputStream(archivo);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);

            try {
                while (true) {
                    Viaje viaje = (Viaje) objectInput.readObject();
                    listaViajes.add(viaje);
                }
            } catch (EOFException e) {
                objectInput.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaViajes;
    }
}