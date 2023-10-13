package org.example;


import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        File ruta = new File("src/main/resources/institutos.dat");
        ruta.createNewFile();


        createDat(readXML());


    }


    public static void createDat(Institutos institutos) throws IOException {

        try {

            FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/institutos.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(institutos);


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

    public static Institutos readXML() throws FileNotFoundException {

        XStream xStream = new XStream();

        xStream.processAnnotations(Institutos.class);
        xStream.processAnnotations(Instituto.class);
        xStream.processAnnotations(Persona.class);
        xStream.processAnnotations(Profesor.class);
        xStream.processAnnotations(Administrativo.class);
        xStream.processAnnotations(Historial.class);
        xStream.processAnnotations(Falta.class);

        xStream.addImplicitCollection(Institutos.class, "instituto");
        xStream.addImplicitCollection(Instituto.class, "persona");
        xStream.addImplicitCollection(Profesor.class, "historial");
        xStream.addImplicitCollection(Profesor.class, "falta");
//        xStream.addImplicitCollection(Historial.class,"asignatura");


        xStream.allowTypes(new Class[]{
                org.example.Institutos.class,
                org.example.Instituto.class,
                org.example.Persona.class,
                org.example.Profesor.class,
                org.example.Administrativo.class,
                org.example.Historial.class,
                org.example.Falta.class
        });

        Institutos lista = (Institutos) xStream.fromXML(new FileInputStream("src/main/resources/instituto.xml"));

        return lista;


    }
}