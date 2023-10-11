package org.example;


import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

    readXML();
    }


    public static void readXML() throws FileNotFoundException {

        XStream xStream = new XStream();

        xStream.processAnnotations(Institutos.class);
        xStream.processAnnotations(Instituto.class);
        xStream.processAnnotations(Persona.class);
        xStream.processAnnotations(Profesor.class);
        xStream.processAnnotations(Administrativo.class);
        xStream.processAnnotations(Historial.class);
        xStream.processAnnotations(Falta.class);

        xStream.addImplicitCollection(Institutos.class,"institutos");
        xStream.addImplicitCollection(Instituto.class,"persona");
        xStream.addImplicitCollection(Profesor.class,"historial");
        xStream.addImplicitCollection(Profesor.class,"falta");
        xStream.addImplicitCollection(Historial.class,"asignatura");


        xStream.allowTypes(new Class[] {
                Institutos.class,
                org.example.Instituto.class,
                org.example.Persona.class,
                org.example.Profesor.class,
                org.example.Administrativo.class,
                org.example.Historial.class,
                org.example.Falta.class
        });

//        Institutos lista = (Institutos) xStream.fromXML( new FileInputStream("src/main/resources/instituto.xml"));
//
//        for (Instituto instituto: lista.getInstitutos()) {
//            System.out.println(instituto);
//        }
    }
}