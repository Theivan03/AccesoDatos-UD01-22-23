package view;

import com.mycompany.libreria.Libreria;
import controller.SponsorController;
import controller.TenistaController;
import controller.TorneoController;
import model.entity.Contrato;
import model.entity.Sponsor;
import model.entity.Tenista;
import model.entity.Torneo;

import java.time.LocalDate;
import java.util.*;

/**
 * Esta es la clase desde la que se accede al programa, junto con sus datos y menus.
 */
public class Menu {
    private static TenistaController tenistaController = new TenistaController();
    private static SponsorController sponsorController = new SponsorController();
    private static TorneoController torneoController = new TorneoController();

    /**
     * Método que abre el menú principal con el que interactuar
     */
    public static void startOpenTenis() {
        clear();
        int respuestaMenuPrincipal;
        do {
            System.out.println("---- OPEN TENIS ----");
            respuestaMenuPrincipal = Libreria.createMenu("1. Tenista", "2. Sponsor", "3. Torneo", "4. Salir");
            System.out.println("-----------------");

            clear();
            switch (respuestaMenuPrincipal) {
                case 1:
                    menuTenista();
                    break;
                case 2:
                    menuSponsor();
                    break;
                case 3:
                    menuTorneo();
                    break;
                case 4:
                    System.out.println("Un placer.");
                    return;
            }
        } while (true);
    }


    //region TODOS LOS MENUS
    private static void menuTenista() {
        int respuestaMenuTenis;
        do {
            System.out.println("\n---- TENISTAS ----");
            respuestaMenuTenis = Libreria.createMenu("1. Crear Tenista", "2. Obtener tenista", "3. Mostrar Tenistas",
                    "4. Borrar Tenista", "5. Actualizar Tenista", "6. Añadir Torneo Ganado", "7. Crear Contrato",
                    "8. Puntos totales por un tenista", "9. Lista de Sponsors de tenista", "10. Salir");
            System.out.println("-----------------");

            clear();
            switch (respuestaMenuTenis) {
                case 1:
                    crearTenista();
                    break;
                case 2:
                    obtenerTenista();
                    break;
                case 3:
                    mostrarTenistas();
                    break;
                case 4:
                    borrarTenista();
                    break;
                case 5:
                    actualizarTenista();
                    break;
                case 6:
                    añadirTorneoGanado();
                    break;
                case 7:
                    crearContrato();
                    break;
                case 8:
                    puntosTotalesDeUnTenista();
                    break;
                case 9:
                    sponsorsDeTenista();
                    break;
                default:
                    return;
            }
        } while (true);
    }




    private static void menuSponsor() {
        int respuestaMenuSponsor;
        do {
            System.out.println("\n---- SPONSORS ----");
            respuestaMenuSponsor = Libreria.createMenu("1. Crear Sponsor", "2. Obtener Sponsor", "3. Mostrar Sponsors",
                    "4. Borrar Sponsor", "5. Actualizar Sponsor", "6. Mostrar Sponsors más ricos", "7. Salir");
            System.out.println("-----------------");

            clear();
            switch (respuestaMenuSponsor) {
                case 1:
                    crearSponsor();
                    break;
                case 2:
                    obtenerSponsor();
                    break;
                case 3:
                    mostrarSponsors();
                    break;
                case 4:
                    borrarSponsor();
                    break;
                case 5:
                    actualizarSponsor();
                    break;
                case 6:
                    mostrarRicos();
                    break;
                default:
                    return;
            }
        } while (true);
    }

    private static void borrarSponsor() {
        System.out.println("---- BORRAR SPONSOR ----\n");
        int codigoABuscar = Libreria.getInt("Código de Sponsor que borrar: ");


        if (sponsorController.delete(codigoABuscar)) {
            System.out.println("Se ha borrado el sponsor.");
        } else {
            System.out.println("No se ha podido borrado el sponsor.");
        }
    }


    private static void menuTorneo() {
        int respuestaMenuTorneo;
        do {
            System.out.println("\n---- TORNEO ----");
            respuestaMenuTorneo = Libreria.createMenu("1. Crear Torneo", "2. Obtener Torneo", "3. Mostrar Torneo",
                    "4. Borrar Torneo", "5. Actualizar Torneo", "6. Salir");
            System.out.println("-----------------");

            clear();
            switch (respuestaMenuTorneo) {
                case 1:
                    crearTorneo();
                    break;
                case 2:
                    obtenerTorneo();
                    break;
                case 3:
                    mostrarTorneos();
                    break;
                case 4:
                    borrarTorneo();
                    break;
                case 5:
                    actualizarTorneo();
                    break;
                default:
                    return;
            }
        } while (true);
    }


    //endregion

    //region Metodos Sponsor
    private static void actualizarSponsor() {
        System.out.println("---- ACTUALIZAR SPONSOR ----\n");
        int codigo = Libreria.getInt("Código de Sponsor que modificar: ");
        String nombre = Libreria.getLine("Nuevo nombre: ");

        if (sponsorController.update(new Sponsor(codigo, nombre))) {
            System.out.println("Modificado con exito");
        } else {
            System.out.println("Fracaso modificando");
        }
    }

    private static void obtenerSponsor() {
        System.out.println("---- BUSCAR SPONSOR ----\n");
        int codigoABuscar = Libreria.getInt("Código de Sponsor que buscar: ");
        Sponsor sponsor = sponsorController.findById(codigoABuscar);

        if (sponsor == null) {
            System.out.println("No se ha encontrado un tenista con ese código.");
        } else {
            System.out.println(sponsor);
        }


    }

    private static void mostrarSponsors() {
        List<Sponsor> sponsors = sponsorController.findAll();
        mostrarLista("SPONSORS", sponsors);
    }

    private static void crearSponsor() {
        System.out.println("---- CREAR SPONSOR ----");
        String nombre;

        nombre = Libreria.getLine("Nombre: ");

        sponsorController.save(new Sponsor(0, nombre));

    }

    private static void mostrarRicos() {
        List<Sponsor> sponsors = sponsorController.getRichSponsor();
        mostrarLista("SPONSORS RICOS", sponsors);
    }

    //endregion

    //region Metodos Tenista
    private static void actualizarTenista() {
        System.out.println("---- ACTUALIZAR TENISTA ----\n");
        String codigo = Libreria.getLine("Código de Tenista que modificar: ");
        String nombre = Libreria.getLine("Nuevo nombre: ");
        String nacionalidad = Libreria.getLine("Nueva Nacionalidad: ");

        if (tenistaController.update(new Tenista(UUID.fromString(codigo),nombre,nacionalidad))) {
            System.out.println("Modificado con exito");
        } else {
            System.out.println("Fracaso modificando");
        }
    }

    private static void borrarTenista() {
        System.out.println("---- BORRAR TENISTA ----\n");
        String codigoABuscar;
        codigoABuscar = Libreria.getLine("Código de Tenista que borrar: ");
        if (tenistaController.delete(UUID.fromString(codigoABuscar))) {
            System.out.println("Tenista borrado con exito");
        } else {
            System.out.println("Fallo borrando tenista");
        }
    }
    private static void obtenerTenista() {
        System.out.println("---- BUSCAR TENISTA ----\n");
        String codigoABuscar;
        codigoABuscar = Libreria.getLine("Código de Tenista que buscar: ");
        UUID id = null;
        try {
            id = UUID.fromString(codigoABuscar);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Formato de UUID invalido");
            return;
        }

        Tenista tenista = tenistaController.findById(id);

        if (tenista == null) {
            System.out.println("No se ha encontrado un tenista con ese código.");
        } else {
            System.out.println(tenista);
        }


    }

    private static void mostrarTenistas() {
        List<Tenista> tenistas = tenistaController.findAll();
        mostrarLista("TENISTAS", tenistas);
    }

    private static void crearTenista() {
        System.out.println("---- CREAR TENISTA ----");
        String nombre, nacionalidad;
        UUID uuid = UUID.randomUUID();

        nombre = Libreria.getLine("Nombre: ");
        nacionalidad = Libreria.getLine("Nacionalidad: ");

        tenistaController.save(new Tenista(uuid, nombre, nacionalidad));

    }

    private static void añadirTorneoGanado() {
        System.out.println("---- AÑADIR TORNEO GANADO A TENISTA ----\n");
        String codigoTenista = Libreria.getLine("Código de Tenista: ");
        String codigoTorneo = Libreria.getLine("Código de Torneo: ");
        if (tenistaController.addTorneoGanado(codigoTenista, codigoTorneo)) {
            System.out.println("Añadido con exito");
        } else {
            System.out.println("Fracaso añadiendo");
        }

    }

    private static void crearContrato() {
        LocalDate fechaInicio, fechaFin;
        System.out.println("---- AÑADIR CONTRATO A TENISTA ----\n");
        String codTenista = Libreria.getLine("Código de Tenista: ");
        int codSponsor = Libreria.getInt("Codigo de Sponsor: ");

        do {
            try {
                fechaInicio = LocalDate.parse(Libreria.getLine("Fecha Inicio YYYY-MM-DD: "));
                fechaFin = LocalDate.parse(Libreria.getLine("Fecha Inicio YYYY-MM-DD: "));
                break;
            } catch (Exception e) {
                System.err.println("\nERROR: Escribe la fecha con formato YYYY-MM-DD (Año, mes, dia)");
            }
        } while (true);

        double saldo = Libreria.getDouble("Saldo: ");

        if (tenistaController.addContrato(codSponsor, codTenista, fechaInicio, fechaFin, saldo)) {
            System.out.println("Añadido contrato con exito");
        } else {
            System.out.println("Fallo añadiendo contrato");
        }

    }

    private static void puntosTotalesDeUnTenista() {
        System.out.println("---- PUNTOS DE UN TENISTA ----");
        String codigoABuscar;
        codigoABuscar = Libreria.getLine("Código de Tenista que buscar: ");
        int num = tenistaController.getPointsByTenista(codigoABuscar);
        if (num == -1) {
            System.out.println("ERROR");
        } else {
            System.out.println("Puntos totales del tenista: " + num);
        }

    }

    private static void sponsorsDeTenista() {
        TreeMap<String, List<String>> lista = tenistaController.getTenistaWithSponsor();
        if (lista == null) {
            System.out.println("No hay actualmente Sponsors asignados a Tenistas");
            return;
        }

        System.out.println("---- SPONSORS DE TENISTAS ----");
        Set<Map.Entry<String, List<String>>> entradas = lista.entrySet();

        // Es la primera vez que uso un treemap que contenía una lista en vez de valor fijo, por lo que he tenido
        // que buscar y hacer apaños.

        Iterator<Map.Entry<String, List<String>>> iterator = entradas.iterator();
        Map.Entry<String, List<String>> registro = null;

        while (iterator.hasNext()) {
            registro = iterator.next();
            String tenistaActual = registro.getKey();
            List<String> sponsorsActual = registro.getValue();
            System.out.print("Sponsors de " + tenistaActual + ": " + sponsorsActual.get(0));

            for (int i = 1; i < sponsorsActual.size(); i++) {
                System.out.print(", " + sponsorsActual.get(i));
            }
            System.out.println("");
        }
    }

    //endregion

    //region Metodos Torneo
    private static void actualizarTorneo() {
        System.out.println("---- ACTUALIZAR TORNEO ----\n");
        String codigo = Libreria.getLine("Código de Torneo que modificar: ");
        String nombre = Libreria.getLine("Nuevo nombre: ");
        int puntos = Libreria.getInt("Nueva cantidad de puntos: ");
        double premio = Libreria.getDouble("Nueva cantidad de premio: ");

        if (torneoController.update(new Torneo(UUID.fromString(codigo),nombre,puntos,premio))) {
            System.out.println("Modificado con exito");
        } else {
            System.out.println("Fracaso modificando");
        }
    }

    private static void obtenerTorneo() {
        System.out.println("---- BUSCAR TORNEOS ----\n");
        String codigoABuscar;
        codigoABuscar = Libreria.getLine("Código de Torneo que buscar: ");
        Torneo torneo = torneoController.findById(UUID.fromString(codigoABuscar));

        if (torneo == null) {
            System.out.println("No se ha encontrado un tenista con ese código.");
        } else {
            System.out.println(torneo);
        }


    }

    private static void mostrarTorneos() {
        List<Torneo> torneos = torneoController.findAll();
        mostrarLista("TORNEOS", torneos);
    }

    private static void borrarTorneo() {
        System.out.println("---- BORRAR TORNEO ----\n");
        String codigoABuscar = Libreria.getLine("Código de Torneo que borrar: ");

        if (torneoController.delete(UUID.fromString(codigoABuscar))) {
            System.out.println("Se ha borrado el torneo.");
        } else {
            System.out.println("No se ha podido borrado el torneo.");
        }
    }

    private static void crearTorneo() {
        System.out.println("---- CREAR TORNEO ----");
        String nombre;
        int puntos;
        double premio;
        UUID uuid = UUID.randomUUID();

        nombre = Libreria.getLine("Nombre: ");

        do {
            puntos = Libreria.getInt("Puntos: ");
            if (puntos > 0)
                break;
            System.out.println("La cantidad de puntos debe ser superior a 0.");
        } while (true);

        do {
            premio = Libreria.getDouble("Premio: ");
            if (premio > 0)
                break;
            System.out.println("La cantidad de premio debe ser superior a 0.");
        } while (true);


        torneoController.save(new Torneo(uuid, nombre, puntos, premio));

    }
    //endregion

    //region Metodos Utiles
    /**
     * Método simple que hace espacio en la terminal para que se vea más limpio
     */
    private static void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Método que usan las opciones de mostrar lista de torneo, tenista y sponsor.
     *
     * @param texto el nombre del tipo de la lista que se le pasa
     * @param lista la lista que quieres mostrar por pantalla
     */
    private static void mostrarLista(String texto, List lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay " + texto + " actualmente.");
            return;
        }

        System.out.println("---- MOSTRAR " + texto.toUpperCase() + " ----");
        for (Object object : lista) {
            System.out.println("--------------------------");
            System.out.println(object);
            System.out.println("--------------------------");
        }

    }
    //endregion

}
