package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void mostrarOpciones() {
        System.out.println("\n1. Convertir XML a DAT");
        System.out.println("2. Convertir DAT a XML");
        System.out.println("3. Mostrar XML");
        System.out.println("4. Mostrar DAT");
        System.out.println("5. Salir");
    }

    public static int leerOpcion() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.print("Opcion: ");
            try {
                opcion = sc.nextInt();
                if (opcion < 1 || opcion > 5) {
                    System.out.println("Solo opciones del 1 al 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Solo numeros");
                sc.nextLine();
                opcion = 0;
            }
        } while (opcion < 1 || opcion > 5);

        return opcion;
    }
}
