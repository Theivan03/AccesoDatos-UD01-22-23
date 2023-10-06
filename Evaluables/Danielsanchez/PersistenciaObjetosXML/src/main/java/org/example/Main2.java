package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main2 {

        public static void main(String[] args) {
            try {
                XStream xstream = new XStream();
                xstream.processAnnotations(Instituto.class);
                xstream.processAnnotations(Administrativo.class);
                xstream.processAnnotations(Profesor.class);

                xstream.allowTypes(new Class[]{
                        org.example.Instituto.class,
                        org.example.Administrativo.class,
                        org.example.Profesor.class
                });

                Instituto instituto = (Instituto) xstream.fromXML(new FileInputStream("src/main/resources/instituto.xml"));

                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/institutos.dat"));
                out.writeObject(instituto);
                out.close();

                System.out.println("Datos almacenados correctamente.");
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

}
