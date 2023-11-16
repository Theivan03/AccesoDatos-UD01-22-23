package model.repository.Torneo;

import com.mycompany.libreria.Libreria;
import model.entity.Torneo;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

/**
 * Repositorio que con métodos accede a la base de datos para obtener la información de torneos
 */
public class TorneoRepository implements ITorneoRepository {

    private final String CONFIG_FILE = "src/main/resources/propiedades.properties";
    private Connection conexion;
    private String db, user, pass;

    /**
     * El constructor del repositorio, que guarda los datos de la base de datos para luego hacer la conexión
     */
    public TorneoRepository() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            db = properties.getProperty("URL");
            user = properties.getProperty("USER");
            pass = properties.getProperty("PASS");
        } catch (IOException ex) {
            System.out.println("ERROR ARCHIVO CONSTRUCTOR REPOSITORIO TORNEO: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR GENERICO CONSTRUCTOR REPOSITORIO TORNEO: " + ex.getMessage());
        }
    }

    /**
     * Introduce un torneo nuevo en la base de datos
     *
     * @param entity torneo a introducir
     */
    @Override
    public void save(Torneo entity) {
        try {

            String query = "INSERT INTO torneo (codigo, nombre, puntos, premio) " +
                    "VALUES(?, ?, ?, ?)";

            conexion = DriverManager.getConnection(db, user, pass);

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, entity.getCodigo().toString());
            ps.setString(2, entity.getNombre());
            ps.setInt(3, entity.getPuntos());
            ps.setDouble(4, entity.getPremio());

            ps.executeQuery();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
        }
    }

    /**
     * Busca un torneo en específico con el id
     *
     * @param id el id del torneo
     * @return o el torneo si lo encuentra, o null
     */
    @Override
    public Torneo findById(UUID id) {
        Torneo torneo = null;
        try {

            String query = "select * from torneo where codigo = ?";

            conexion = DriverManager.getConnection(db, user, pass);

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, id.toString());


            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                torneo = new Torneo(
                        UUID.fromString(resultado.getString("codigo")),
                        resultado.getString("nombre"),
                        resultado.getInt("puntos"),
                        resultado.getDouble("premio"));
            }

            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return torneo;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return torneo;
        }
        return torneo;
    }

    /**
     * Método que devuelve una lista con todos los torneos actualmente en la base
     *
     * @return la lista con torneos
     */
    @Override
    public List<Torneo> findAll() {
        List<Torneo> torneos;
        try {
            torneos = new ArrayList<>();
            String query = "select * from torneo";

            conexion = DriverManager.getConnection(db, user, pass);

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                torneos.add(new Torneo(
                        UUID.fromString(resultado.getString("codigo")),
                        resultado.getString("nombre"),
                        resultado.getInt("puntos"),
                        resultado.getDouble("premio")));
            }
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return null;
        }
        return torneos;
    }

    /**
     * Borrar un torneo por codigo
     *
     * @param codigo el codigo de torneo a borrar
     * @return true si lo consigue borrar, false si no
     */
    @Override
    public boolean delete(UUID codigo) {
        boolean result = false;

        try  {
            conexion = DriverManager.getConnection(db, user, pass);
            conexion.setAutoCommit(false);

            String deleteTorneoGanadoQuery = "DELETE FROM torneoganado WHERE codTorneo = ?";
            String deleteTorneoQuery = "DELETE FROM torneo WHERE codigo = ?";

            PreparedStatement ps = conexion.prepareStatement(deleteTorneoGanadoQuery);
            ps.setObject(1, codigo);
            result = ps.executeUpdate() > 0;

            ps = conexion.prepareStatement(deleteTorneoQuery);
            ps.setObject(1, codigo);
            result = ps.executeUpdate() > 0;

            if (!result) {
                System.out.println("ERROR: No se ha eliminado torneo");
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

        System.out.println("Torneo se ha eliminado correctamente");
        return result;
    }

    /**
     * Actualizar los datos de un torneo en específico
     *
     * @param torneo el torneo a actualizar
     * @return true si lo ha conseguido, false si no
     */
    @Override
    public boolean update(Torneo torneo) {
        try {

            String query = "UPDATE torneo\n" +
                    "SET nombre = ?, puntos = ?, premio = ? " +
                    "WHERE codigo = ?;";

            conexion = DriverManager.getConnection(db, user, pass);

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, torneo.getNombre());
            ps.setInt(2, torneo.getPuntos());
            ps.setDouble(3, torneo.getPremio());
            ps.setString(4, torneo.getCodigo().toString());

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
}
