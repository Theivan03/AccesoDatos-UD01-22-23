import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static int leerOpcion () {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.print("Opcion: ");
            try {
                opcion = sc.nextInt();
                if (opcion < 1 || opcion > 5) {
                    System.out.println("Introduce un numero del 1 al 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un número entero.");
                sc.nextLine();
                opcion = 0;
            }
        } while (opcion < 1 || opcion > 5);
        return opcion;
    }

    public static void mostrarOpciones () {
        System.out.println("\nMi Videoclub");
        System.out.println("------------\n");
        System.out.println("Menu:");
        System.out.println("1. Insertar pelicula");
        System.out.println("2. Modificar pelicula");
        System.out.println("3. Eliminar pelicula");
        System.out.println("4. Visualizar pelicula");
        System.out.println("5. Salir");
    }
}
