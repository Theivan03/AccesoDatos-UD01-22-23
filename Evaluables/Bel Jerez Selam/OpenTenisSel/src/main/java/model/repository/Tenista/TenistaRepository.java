package model.repository.Tenista;

import com.mycompany.libreria.Libreria;
import model.entity.Contrato;
import model.entity.Sponsor;
import model.entity.Tenista;
import model.services.contrato.ContratoService;
import model.services.contrato.IContratoService;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Repositorio que con métodos accede a la base de datos para obtener la información de tenista
 */
public class TenistaRepository implements ITenistaRepository {

    private final String CONFIG_FILE = "src/main/resources/propiedades.properties";
    private Connection conexion;
    private String db, user, pass;

    /**
     * El constructor del repositorio, que guarda los datos de la base de datos para luego hacer la conexión
     */
    public TenistaRepository() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            db = properties.getProperty("URL");
            user = properties.getProperty("USER");
            pass = properties.getProperty("PASS");

        } catch (IOException ex) {
            System.out.println("ERROR ARCHIVO CONSTRUCTOR REPOSITORIO TENISTA: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR GENERICO CONSTRUCTOR REPOSITORIO TENISTA: " + ex.getMessage());
        }
    }

    /**
     * Método que devuelve una lista con todos los tenistas actualmente en la base
     *
     * @return la lista con tenistas
     */
    @Override
    public List<Tenista> findAll() {
        List<Tenista> tenistas;
        try {
            tenistas = new ArrayList<>();
            String query = "select * from tenista";
            conexion = DriverManager.getConnection(db, user, pass);
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                tenistas.add(new Tenista(UUID.fromString(resultado.getString("codigo")), resultado.getString("nombre"), resultado.getString("nacionalidad")));
            }
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return null;
        }
        return tenistas;
    }

    /**
     * Introduce un tenista nuevo en la base de datos
     *
     * @param entity tenista a introducir
     */

    @Override
    public void save(Tenista entity) {
        try {

            String query = "INSERT INTO tenista (codigo, nombre, nacionalidad) " +
                    "VALUES(?, ?, ?)";
            conexion = DriverManager.getConnection(db, user, pass);
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, entity.getCodigo().toString());
            ps.setString(2, entity.getNombre());
            ps.setString(3, entity.getNacionalidad());

            ps.executeQuery();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
        }
    }

    /**
     * Busca un tenista en específico con el id
     *
     * @param id el id del tenista
     * @return o el tenista si lo encuentra, o null
     */

    @Override
    public Tenista findById(UUID id) {
        Tenista tenista = null;
        try {

            String query = "select * from tenista where codigo = ?";
            conexion = DriverManager.getConnection(db, user, pass);
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, id.toString());


            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                tenista = new Tenista(UUID.fromString(resultado.getString("codigo")),
                        resultado.getString("nombre"),
                        resultado.getString("nacionalidad"));
            }

            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return tenista;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return tenista;
        }
        return tenista;
    }

    /**
     * Actualizar los datos de un tenista en específico
     *
     * @param tenista el tenista a actualizar
     * @return true si lo ha conseguido, false si no
     */

    @Override
    public boolean update(Tenista tenista) {
        try {
            String query = "UPDATE tenista " +
                    "SET nombre = ?, nacionalidad = ? " +
                    "WHERE codigo = ?;";
            conexion = DriverManager.getConnection(db, user, pass);
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, tenista.getNombre());
            ps.setString(2, tenista.getNacionalidad());
            ps.setString(3, tenista.getCodigo().toString());
            ps.executeQuery();

            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Borrar un tenista por codigo
     *
     * @param codigo el codigo de tenista a borrar
     * @return true si lo consigue borrar, false si no
     */

    @Override
    public boolean delete(UUID codigo) {
        boolean result = false;

        try  {
            conexion = DriverManager.getConnection(db, user, pass);
            conexion.setAutoCommit(false);

            String deleteTorneoGanadoQuery = "DELETE FROM torneoganado WHERE codTenista = ?";
            String selectTenistaContratoQuery = "SELECT * FROM tenistacontrato WHERE codTenista = ?";
            String deleteTenistaContratoQuery = "DELETE FROM tenistacontrato WHERE codTenista = ?";
            String deleteContratoQuery = "DELETE FROM contrato WHERE codigo = ?";
            String deleteTenistaQuery = "DELETE FROM tenista WHERE codigo = ?";

            PreparedStatement ps = conexion.prepareStatement(deleteTorneoGanadoQuery);
            ps.setObject(1, codigo);
            result = ps.executeUpdate() > 0;

            ps = conexion.prepareStatement(selectTenistaContratoQuery);
            ps.setObject(1, codigo);
            ResultSet resultado = ps.executeQuery();

            ps = conexion.prepareStatement(deleteTenistaContratoQuery);
            ps.setObject(1, codigo);
            result = ps.executeUpdate() > 0;

            UUID codigoContrato;
            while (resultado.next()) {
                codigoContrato = UUID.fromString(resultado.getString("codContrato"));

                ps = conexion.prepareStatement(deleteContratoQuery);
                ps.setObject(1, codigoContrato);
                result = ps.executeUpdate() > 0;
            }

            ps = conexion.prepareStatement(deleteTenistaQuery);
            ps.setObject(1, codigo);
            result = ps.executeUpdate() > 0;

            if (!result) {
                System.out.println("ERROR: No se ha eliminado tenista");
                return false;
            }

            conexion.commit();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return result;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return result;
        }

        System.out.println("Tenista se ha eliminado correctamente");
        return result;
    }

    /**
     * Añadir un torneo ganado a un tenista en concreto
     *
     * @param codTenista el codigo del tenista al que añadir torneo
     * @param codTorneo  el torneo a añadir
     * @return true si lo consigue añadir, false si no
     */

    @Override
    public boolean addTorneoGanado(String codTenista, String codTorneo) {
        try {

            String query = "INSERT INTO torneoganado (codTenista, codTorneo) " +
                    "VALUES(?, ?)";
            conexion = DriverManager.getConnection(db, user, pass);
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, codTenista);
            ps.setString(2, codTorneo);

            ps.executeQuery();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Añade un contrato al tenista que pidas. Primero usa el método del service de Contrato,
     * para crearlo y añadirlo. Luego, lo añade al tenista.
     *
     * @param codSponsor  el codigo del sponsor a añadir
     * @param codTenista  el tenista al que añadirle el contrato
     * @param fechaInicio la fecha de inicio de contrato
     * @param fechaFin    la fecha de fin de contrato
     * @param saldo       el sueldo del contrato
     * @return true si lo consigue añadir, false si no
     */
    @Override
    public boolean addContrato(int codSponsor, String codTenista, LocalDate fechaInicio, LocalDate fechaFin, double saldo) {
        IContratoService iContratoService = new ContratoService();
        UUID id = UUID.randomUUID();
        Contrato contrato = new Contrato(id, fechaInicio, fechaFin, saldo, codSponsor);
        iContratoService.save(contrato);

        try {

            String query = "INSERT INTO tenistacontrato (codTenista, codContrato) " +
                    "VALUES(?, ?)";
            conexion = DriverManager.getConnection(db, user, pass);
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, codTenista);
            ps.setString(2, id.toString());

            ps.executeQuery();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Devuelve el total de puntos que tienen los torneos en los que un tenista ha ganado
     *
     * @param codTenista el tenista a buscar
     * @return el número de puntos total
     */
    @Override
    public int getPointsByTenista(String codTenista) {
        int suma = -1;
        try {
            String query = "select getPointsByTenista(?)";
            conexion = DriverManager.getConnection(db, user, pass);
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, codTenista);


            ResultSet resultado = ps.executeQuery();
            resultado.next();
            suma = resultado.getInt(1);

            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return suma;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return suma;
        }
        return suma;
    }

    /**
     * Obtiene un treemap con la lista de todos los tenistas con sus respectivos sponsors
     * <p>
     * NOTA: Me obecequé en no crear una clase para específicamente este método, y hice este
     * apaño el cual probablemente de más problemas que soluciones, pero creo que va bien
     *
     * @return devuelve la lista
     */
    @Override
    public TreeMap<String, List<String>> getTenistaWithSponsor() {
        TreeMap<String, List<String>> tenistas;
        try {
            String query = "call getTenistaWithSponsor();";
            conexion = DriverManager.getConnection(db, user, pass);
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();

            tenistas = new TreeMap<>();
            String tenistaActual, sponsorActual;
            List<String> listaTenistaActual = new ArrayList<>();

            // A partir de aquí, se encarga de guardar lo que ha recibido de la base en el tree map

            // Si está vacio, sale automáticamente
            if (!resultado.next())
                return null;

            // Primero guarda el primer registro, y a partir de ahí comprueba el siguiente con el anterior
            // y si son el mismo, lo añade a su respectiva lista, si no, guarda la lista en el treemap y
            // hace una nueva

            String tenistaAnterior = resultado.getString("nombreTenista");
            listaTenistaActual.add(resultado.getString("nombreSponsor"));
            while (resultado.next()) {
                tenistaActual = resultado.getString("nombreTenista");
                sponsorActual = resultado.getString("nombreSponsor");

                if (tenistaActual.equals(tenistaAnterior)) {
                    listaTenistaActual.add(sponsorActual);
                } else {
                    // Aquí tuve que pasarle una lista nueva porque como se pasa por referencia, todos los tenistas
                    // tenían la misma lista de sponsors
                    tenistas.put(tenistaAnterior, new ArrayList<>(listaTenistaActual));
                    listaTenistaActual.clear();

                    listaTenistaActual.add(sponsorActual);
                }
                tenistaAnterior = tenistaActual;
            }

            // Este apaño es para cuando se daba el caso de que la lista solo contuviera un tenista y un sponsor
            if (!tenistaAnterior.isEmpty() && !listaTenistaActual.isEmpty()) {
                tenistas.put(tenistaAnterior, listaTenistaActual);
            }
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return null;
        }

        return tenistas;
    }
}

