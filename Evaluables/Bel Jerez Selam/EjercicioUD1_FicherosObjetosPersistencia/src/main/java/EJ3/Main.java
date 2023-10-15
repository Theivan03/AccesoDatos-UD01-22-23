package EJ3;

import EJ2.*;
import com.mycompany.libreria.Libreria;
import com.thoughtworks.xstream.XStream;
import org.example.*;

import java.io.*;
import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int eleccionMenu;
        do {
            eleccionMenu = Libreria.createMenu("1. Convertir XML a DAT", "2. Convertir DAT a XML", "3. Mostrar XML", "4. Mostrar DAT", "5. Salir");
            switch (eleccionMenu) {
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
                default:

            }
        } while (eleccionMenu != 5);
        System.out.println("Un placer.");

    }

    private static void convertirXMLaDAT() throws FileNotFoundException {
        File file = pedirFichero();
        File newFile = cambiarExtension(file, "dat");

        ListaInstitutos listaInstitutos = leerXML(file);

        try (ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(newFile, true))) {
            objOutStream.writeObject(listaInstitutos);
            System.out.println("Hecho con exito.");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }

    private static ListaInstitutos leerXML(File file) throws FileNotFoundException {
        XStream xStream = new XStream();

        xStream.processAnnotations(ListaInstitutos.class);
        xStream.processAnnotations(Instituto.class);
        xStream.processAnnotations(Persona.class);
        xStream.processAnnotations(Profesor.class);
        xStream.processAnnotations(Administrativo.class);
        xStream.processAnnotations(Historial.class);
        xStream.processAnnotations(Falta.class);

        xStream.addImplicitCollection(ListaInstitutos.class, "listaInstitutos");
        xStream.addImplicitCollection(Instituto.class, "personas");
        xStream.addImplicitCollection(Profesor.class, "historial");
        xStream.addImplicitCollection(Profesor.class, "faltas");
        xStream.addImplicitCollection(Historial.class, "asignaturas");

        xStream.allowTypes(new Class[]{
                EJ2.ListaInstitutos.class,
                EJ2.Instituto.class,
                EJ2.Persona.class,
                EJ2.Profesor.class,
                EJ2.Administrativo.class,
                EJ2.Historial.class,
                EJ2.Falta.class
        });

        ListaInstitutos lista = (ListaInstitutos) xStream.fromXML(new FileInputStream(file));
        return lista;
    }

    private static void mostrarXML() throws FileNotFoundException {
        File file = pedirFichero();
        ListaInstitutos lista = leerXML(file);

        for (Instituto it : lista.getListaInstitutos()) {
            System.out.println(it.toString());
        }
    }

    private static void mostrarDAT() {
        File file = pedirFichero();
        ListaInstitutos listaInstitutos = leerDAT(file);
        System.out.println(listaInstitutos);
    }

    private static ListaInstitutos leerDAT(File file) {
        ListaInstitutos listaInstitutos = new ListaInstitutos();
        Instituto instituto;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                listaInstitutos = (ListaInstitutos) objectInputStream.readObject();
            }
        } catch (EOFException IGNORED) {
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return listaInstitutos;
    }


    private static void convertirDATaXML() throws FileNotFoundException {
        File file = pedirFichero();
        File newFile = cambiarExtension(file, "xml");

        ListaInstitutos listaInstitutos = leerDAT(file);

        if (newFile.exists()) {
            ListaInstitutos listaInstitutos2 = leerXML(newFile);
            for (Instituto insti: listaInstitutos2.getListaInstitutos()) {
                listaInstitutos.add(insti);
            }
        }

        XStream xStream = new XStream();

        xStream.processAnnotations(EJ2.Administrativo.class);
        xStream.processAnnotations(EJ2.Falta.class);
        xStream.processAnnotations(EJ2.Historial.class);
        xStream.processAnnotations(EJ2.Instituto.class);
        xStream.processAnnotations(EJ2.ListaInstitutos.class);
        xStream.processAnnotations(EJ2.Persona.class);
        xStream.processAnnotations(EJ2.Profesor.class);

        try {
            xStream.toXML(listaInstitutos, new FileOutputStream(newFile));
            System.out.println("Hecho con exito");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static File pedirFichero() {
        do {
            File file = new File(Libreria.getLine("Dirección del fichero: "));
            if (file.exists())
                return file;
            else
                System.err.println("ERROR: No existe el fichero.");
        } while (true);
    }

    private static File cambiarExtension(File direccion, String extension) {
        String direccionString = direccion.toString();
        String[] partes = direccionString.split("\\.");
        return new File(partes[0] + "." + extension);
    }
}
