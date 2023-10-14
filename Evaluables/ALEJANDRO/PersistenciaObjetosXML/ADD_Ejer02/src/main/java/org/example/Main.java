package org.example;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.time.LocalDateConverter;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        ListaInstitutos listaInstitutos = leerXML();
        escribirDAT(listaInstitutos);
    }

    public static void escribirDAT(ListaInstitutos listaInstitutos) {
        File archivo = new File("src/main/resources/instituto.dat");

        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(listaInstitutos.getInstitutos());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ListaInstitutos leerXML() {
        ListaInstitutos listaInstitutos = null;

        XStream xStream = new XStream();

        xStream.processAnnotations(Administrativo.class);
        xStream.processAnnotations(Falta.class);
        xStream.processAnnotations(Historial.class);
        xStream.processAnnotations(Instituto.class);
        xStream.processAnnotations(ListaInstitutos.class);
        xStream.processAnnotations(Profesor.class);
        xStream.processAnnotations(Persona.class);

        xStream.allowTypes(new Class[]{
                org.example.Administrativo.class,
                org.example.Falta.class,
                org.example.Historial.class,
                org.example.Instituto.class,
                org.example.ListaInstitutos.class,
                org.example.Profesor.class,
                org.example.Persona.class
        });

        try {
            listaInstitutos = (ListaInstitutos) xStream.fromXML(
                    new FileInputStream("src/main/resources/instituto.xml"));
            System.out.println(listaInstitutos.getInstitutos());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaInstitutos;
    }

}