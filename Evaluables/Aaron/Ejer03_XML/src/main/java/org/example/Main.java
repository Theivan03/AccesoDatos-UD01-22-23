package org.example;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        int opcion;
        String nombreFichero;
        boolean repetir = false;

//        do{
//            do {
//                System.out.println("Introduce un numero entre 1 y 5: ");
//                opcion = sc.nextInt();
//            }while (opcion<1 || opcion>5);
//
//            switch (opcion){
//                case 1:
//                    System.out.println("Introduce el nombre del fichero XML: ");
//                    nombreFichero = sc.nextLine();
                    //createDat(nombreFichero);
//                    break;
//                case 2:
//                    System.out.println("Introduce el nombre del fichero DAT: ");
//                    nombreFichero = sc.nextLine();
                    //createXML(nombreFichero);
//                    break;
//                case 3:
//                    System.out.println("Introduce el nombre del fichero XML: ");
//                    nombreFichero = sc.nextLine();
//                    break;
//                case 4:
//                    System.out.println("Introduce el nombre del fichero DAT: ");
//                    nombreFichero = sc.nextLine();
//                    break;
//                case 5:
//                    System.out.println("Fin de programa.");
//                    break;
//            }
//
//        }while (opcion!=5);

        System.out.println("Nombre: ");
        nombreFichero = sc.nextLine();
        createXML(nombreFichero);




    }


    public static void createDat(String nombreFichero) throws IOException {

        File rutaXML = new File("src/main/resources/" + nombreFichero + ".xml");

        if(!rutaXML.exists()){
            System.out.println("El archivo no existe en la ruta.");
        }else{
            System.out.println("Archivo encontrado, procediendo a la creacion del .dat");
        }

        XStream xStream = new XStream();

        xStream.processAnnotations(Institutos.class);
        xStream.processAnnotations(Instituto.class);
        xStream.processAnnotations(Persona.class);
        xStream.processAnnotations(Profesor.class);
        xStream.processAnnotations(Administrativo.class);
        xStream.processAnnotations(Historial.class);
        xStream.processAnnotations(Falta.class);

        xStream.addImplicitCollection(Institutos.class,"instituto");
        xStream.addImplicitCollection(Instituto.class,"persona");
        xStream.addImplicitCollection(Profesor.class,"historial");
        xStream.addImplicitCollection(Profesor.class,"falta");

        xStream.allowTypes(new Class[] {
                org.example.Institutos.class,
                org.example.Instituto.class,
                org.example.Persona.class,
                org.example.Profesor.class,
                org.example.Administrativo.class,
                org.example.Historial.class,
                org.example.Falta.class
        });

        Institutos listaInstitutos = (Institutos) xStream.fromXML(rutaXML);

        //ruta del .dat
        File rutaDat = new File("src/main/resources/" + nombreFichero + ".dat");

        FileOutputStream fileOutputStream = new FileOutputStream(rutaDat,true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(listaInstitutos);

    }

    public static void createXML(String nombreFichero) throws IOException, ClassNotFoundException {

        File rutaDat = new File("src/main/resources/"+nombreFichero+".dat");

        FileInputStream fileInputStream = new FileInputStream(rutaDat);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Institutos datListaInstitutos = (Institutos) objectInputStream.readObject();

        objectInputStream.close();

        File rutaXML = new File("src/main/resources/"+nombreFichero+".xml");

        XStream xStream = new XStream();

        xStream.processAnnotations(Institutos.class);
        xStream.processAnnotations(Instituto.class);
        xStream.processAnnotations(Persona.class);
        xStream.processAnnotations(Profesor.class);
        xStream.processAnnotations(Administrativo.class);
        xStream.processAnnotations(Historial.class);
        xStream.processAnnotations(Falta.class);

        xStream.addImplicitCollection(Institutos.class,"instituto");
        xStream.addImplicitCollection(Instituto.class,"persona");
        xStream.addImplicitCollection(Profesor.class,"historial");
        xStream.addImplicitCollection(Profesor.class,"falta");

        xStream.allowTypes(new Class[]{
                org.example.Institutos.class,
                org.example.Instituto.class,
                org.example.Persona.class,
                org.example.Profesor.class,
                org.example.Administrativo.class,
                org.example.Historial.class,
                org.example.Falta.class
        });



        Institutos xmlListaInstitutos = (Institutos) xStream.fromXML(rutaXML);

        List<Instituto> nuevaListaInstitutos = new ArrayList<>();

        for (Instituto instituto: xmlListaInstitutos.getInstituto()) {
            nuevaListaInstitutos.add(instituto);

        }
        for (Instituto instituto : datListaInstitutos.getInstituto()) {
            nuevaListaInstitutos.add(instituto);
        }

        xStream.toXML(nuevaListaInstitutos, new FileOutputStream(rutaXML));

    }

    public static void mostrarXML(String nombreFichero) throws IOException, ClassNotFoundException {

        File rutaXML = new File("src/main/resources/"+nombreFichero+".xml");

        XStream xStream = new XStream();

        xStream.processAnnotations(Institutos.class);
        xStream.processAnnotations(Instituto.class);
        xStream.processAnnotations(Persona.class);
        xStream.processAnnotations(Profesor.class);
        xStream.processAnnotations(Administrativo.class);
        xStream.processAnnotations(Historial.class);
        xStream.processAnnotations(Falta.class);

        xStream.addImplicitCollection(Institutos.class,"instituto");
        xStream.addImplicitCollection(Instituto.class,"persona");
        xStream.addImplicitCollection(Profesor.class,"historial");
        xStream.addImplicitCollection(Profesor.class,"falta");

        xStream.allowTypes(new Class[]{
                org.example.Institutos.class,
                org.example.Instituto.class,
                org.example.Persona.class,
                org.example.Profesor.class,
                org.example.Administrativo.class,
                org.example.Historial.class,
                org.example.Falta.class
        });

        Institutos listaInstitutos = (Institutos) xStream.fromXML(rutaXML);

//        List<Instituto> mostrarListaInstitutos = new ArrayList<>();


        for (Instituto instituto: listaInstitutos.getInstituto()) {
            System.out.println(instituto);

        }

//        for (Instituto instituto:mostrarListaInstitutos      ) {
//            System.out.println(instituto);
//
//        }

    }

}