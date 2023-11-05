package EJ2;

import com.thoughtworks.xstream.XStream;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        crearFichero();
        ListaInstitutos lista = leerXML();
        escribirFichero(lista);
    }

    public static void crearFichero() throws IOException {
        File archivo = new File("src/main/resources/instituto.dat");

        if (!archivo.exists()) {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado correctamente!");
            }
        }
    }

    public static void escribirFichero(ListaInstitutos lista) {
        File archivo = new File("src/main/resources/instituto.dat");

        try (FileOutputStream outputStream = new FileOutputStream(archivo);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(lista);
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    public static ListaInstitutos leerXML() throws FileNotFoundException {
        XStream xStream = new XStream();

        xStream.processAnnotations(ListaInstitutos.class);
        xStream.processAnnotations(Instituto.class);
        xStream.processAnnotations(Persona.class);
        xStream.processAnnotations(Profesor.class);
        xStream.processAnnotations(Administrativo.class);
        xStream.processAnnotations(Historial.class);
        xStream.processAnnotations(Falta.class);

        xStream.addImplicitCollection(ListaInstitutos.class,"listaInstitutos");
        xStream.addImplicitCollection(Instituto.class,"personas");
        xStream.addImplicitCollection(Profesor.class,"historial");
        xStream.addImplicitCollection(Profesor.class,"faltas");
        xStream.addImplicitCollection(Historial.class,"asignaturas");

        xStream.allowTypes(new Class[]{
                EJ2.ListaInstitutos.class,
                EJ2.Instituto.class,
                EJ2.Persona.class,
                EJ2.Profesor.class,
                EJ2.Administrativo.class,
                EJ2.Historial.class,
                EJ2.Falta.class
        });

        ListaInstitutos lista = (ListaInstitutos) xStream.fromXML(new FileInputStream("src/main/resources/instituto.xml"));

        for (Instituto it : lista.getListaInstitutos()) {
            System.out.println(it.toString());
        }

        return lista;
    }
}
