package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            Menu.mostrarOpciones();
            opcion = Menu.leerOpcion();
            switch (opcion) {
                case 1:
                    convertirXMLaDAT();
                    break;
                case 2:
                    convertirDATaXML();
                    break;
                case 3:
                    mostrarXML();
                    break;
                case 4:
                    mostrarDAT();
                    break;
                case 5:
                    System.out.println("FIN DEL PROGRAMA");
                    break;
            }
        } while (opcion != 5);

    }

    public static void convertirXMLaDAT() {
        String nombreFichero = leerFichero();
        ListaInstitutos listaInstitutos = leerXML(nombreFichero);
        if (listaInstitutos != null) {
            escribirDAT(listaInstitutos, nombreFichero);
        }
    }

    public static void convertirDATaXML() {
        String nombreFichero = leerFichero();
        ListaInstitutos listaInstitutos = leerDAT(nombreFichero);
        if (listaInstitutos != null) {
            escribirXML(listaInstitutos, nombreFichero);
        }
    }

    public static void mostrarXML() {
        String nombreFichero = leerFichero();
        ListaInstitutos listaInstitutos = leerXML(nombreFichero);
        if (listaInstitutos != null) {
            System.out.println(listaInstitutos);
        }
    }

    public static void mostrarDAT() {
        String nombreFichero = leerFichero();
        ListaInstitutos listaInstitutos = leerDAT(nombreFichero);
        if (listaInstitutos != null) {
            System.out.println(listaInstitutos);
        }
    }

    //metodos lectura y escritura
    public static ListaInstitutos leerDAT(String nombreFichero) {
        File archivo = new File("src/main/resources/" + nombreFichero + ".dat");
        ListaInstitutos listaInstitutos = null;

        if (archivo.exists()) {
            try (FileInputStream fileInput = new FileInputStream(archivo);
                 ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {

                listaInstitutos = (ListaInstitutos) objectInput.readObject();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("La ruta especificada no existe");
        }

        return listaInstitutos;
    }

    public static ListaInstitutos leerXML(String nombreFichero) {
        ListaInstitutos listaInstitutos = null;

        File archivo = new File("src/main/resources/" + nombreFichero + ".xml");

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

        if (archivo.exists()) {
            try {
                listaInstitutos = (ListaInstitutos) xStream.fromXML(
                        new FileInputStream(archivo));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El fichero epecificado no existe");
        }

        return listaInstitutos;
    }


    public static void escribirDAT(ListaInstitutos listaInstitutos, String nombreFichero) {
        File archivo = new File("src/main/resources/" + nombreFichero + ".dat");

        ListaInstitutos listaAux = null;

        if (archivo.exists()) {
            listaAux = leerDAT(nombreFichero);
        }

        if (listaAux != null) {
            for (Instituto instituto : listaAux.getInstitutos()) {
                listaInstitutos.add(instituto);
            }
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, true);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(listaInstitutos);

            System.out.println("Se ha añadido la información al fichero DAT");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void escribirXML(ListaInstitutos listaInstitutos, String nombreFichero) {
        File archivo = new File("src/main/resources/" + nombreFichero + ".xml");

        XStream xStream = new XStream();

        xStream.processAnnotations(Administrativo.class);
        xStream.processAnnotations(Falta.class);
        xStream.processAnnotations(Historial.class);
        xStream.processAnnotations(Instituto.class);
        xStream.processAnnotations(ListaInstitutos.class);
        xStream.processAnnotations(Profesor.class);
        xStream.processAnnotations(Persona.class);

        ListaInstitutos listaAux = leerXML(nombreFichero);

        if (listaAux != null) {
            for (Instituto instituto : listaAux.getInstitutos()) {
                listaInstitutos.add(instituto);
            }
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(archivo)) {

            xStream.toXML(listaInstitutos, fileOutputStream);

            System.out.println("Se ha añadido la información al fichero XML");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String leerFichero() {
        System.out.print("Introduce el nombre del fichero sin extension: ");
        return sc.nextLine();
    }

}