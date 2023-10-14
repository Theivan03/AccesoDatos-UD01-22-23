import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static File archivo = new File("src/peliculas.dat");

    public static void main(String[] args) {

        int opcion;
        do {
            Menu.mostrarOpciones();
            opcion = Menu.leerOpcion();
            switch (opcion) {
                case 1:
                    insertarPelicula(leerDatos());
                    break;
                case 2:
                    modificarPelicula();
                    break;
                case 3:
                    eliminarPelicula();
                    break;
                case 4:
                    visualizarPelicula();
                    break;

            }
        } while (opcion != 5);

    }

    public static void insertarPelicula(Pelicula newMovie) {
        List<Pelicula> listaPeliculas = leerArchivo();

        listaPeliculas.add(newMovie);

        escribirArchivo(listaPeliculas);

    }

    public static void modificarPelicula() {
        List<Pelicula> listaPeliculas = leerArchivo();

        String titulo, formato;
        titulo = leerString("Introduce el nombre de la pelicula");

        boolean existe = false;
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().equals(titulo)) {
                formato = leerString("Introduce el formato");
                pelicula.setFormato(formato);
                existe = true;
            }
        }

        if (existe) {
            escribirArchivo(listaPeliculas);
        } else {
            System.out.println("No se encontro la pelicula en la lista");
        }

    }

    public static void eliminarPelicula() {
        List<Pelicula> listaPeliculas = leerArchivo();

        String titulo;
        titulo = leerString("Introduce el nombre de la pelicula a eliminar");

        boolean existe = false;
        for (int i = 0; i < listaPeliculas.size(); i++) {
            if (listaPeliculas.get(i).getTitulo().equals(titulo)) {
                listaPeliculas.remove(i);
                existe = true;
                System.out.println("Se ha eliminado la pelicula " + titulo + " de la lista");
            }
        }

        if (existe) {
            escribirArchivo(listaPeliculas);
        } else {
            System.out.println("No se encontro la pelicula en la lista");
        }

    }

    public static void visualizarPelicula() {
        List<Pelicula> listaPeliculas = leerArchivo();

        String titulo;
        titulo = leerString("Introduce el nombre de la pelicula");

        boolean existe = false;
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().equals(titulo)) {
                System.out.println(pelicula);
                existe = true;
            }
        }

        if (listaPeliculas.isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            if (!existe) {
                System.out.println("Esa pelicula no se encuentra en la lista");
            }
        }
    }

    //metodos para leer datos

    public static void escribirArchivo(List<Pelicula> listaPeliculas) {
        try {
            FileOutputStream fileOutput = new FileOutputStream(archivo);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

            for (Pelicula pelicula : listaPeliculas) {
                objectOutput.writeObject(pelicula);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Pelicula> leerArchivo() {
        List<Pelicula> listaPeliculas = new ArrayList<>();
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            if (archivo.length() > 0) {
                FileInputStream fileInput = new FileInputStream(archivo);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInput);

                try {
                    while (true) {
                        Pelicula pelicula = (Pelicula) objectInputStream.readObject();
                        listaPeliculas.add(pelicula);
                    }
                } catch (EOFException e) {

                }
                objectInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPeliculas;
    }

    public static Pelicula leerDatos() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Pelicula pelicula = new Pelicula();

        System.out.print("Introduce el titulo: ");
        pelicula.setTitulo(sc.nextLine());

        System.out.print("Introduce los actores: ");
        pelicula.setActores(Arrays.asList(sc.nextLine().split(";")));

        System.out.print("Introduce los directores: ");
        pelicula.setDirectores(Arrays.asList(sc.nextLine().split(";")));

        System.out.print("Introduce la fecha de salida: ");
        pelicula.setFechaSalida(LocalDate.parse(sc.nextLine(), formatter));

        System.out.print("Introduce el formato: ");
        pelicula.setFormato(sc.nextLine());

        return pelicula;
    }

    public static String leerString(String texto) {
        String cadena = null;
        System.out.println(texto + ": ");
        cadena = sc.nextLine();

        return cadena;
    }

}