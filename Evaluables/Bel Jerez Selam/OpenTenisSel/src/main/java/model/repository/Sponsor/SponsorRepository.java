package model.repository.Sponsor;

import com.mycompany.libreria.Libreria;
import model.entity.Sponsor;
import model.entity.Tenista;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

/**
 * Repositorio que con métodos accede a la base de datos para obtener la información de sponsor
 */
public class SponsorRepository implements ISponsorRepository {
    private final String CONFIG_FILE = "src/main/resources/propiedades.properties";
    private Connection conexion;
    private String db, user, pass;

    /**
     * El constructor del repositorio, que guarda los datos de la base de datos para luego hacer la conexión
     */
    public SponsorRepository() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            db = properties.getProperty("URL");
            user = properties.getProperty("USER");
            pass = properties.getProperty("PASS");
        } catch (IOException ex) {
            System.out.println("ERROR ARCHIVO CONSTRUCTOR REPOSITORIO SPONSOR: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR GENERICO CONSTRUCTOR REPOSITORIO SPONSOR: " + ex.getMessage());
        }
    }

    /**
     * Introduce un sponsor nuevo en la base de datos
     *
     * @param entity sponsor a introducir
     */
    @Override
    public void save(Sponsor entity) {
        try {
            String query = "INSERT INTO sponsor (codigo, nombre) " +
                    "VALUES(?, ?)";

            conexion = DriverManager.getConnection(db, user, pass);

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, entity.getCodigo());
            ps.setString(2, entity.getNombre());

            ps.executeQuery();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
        }
    }

    /**
     * Busca un sponsor en específico con el id
     *
     * @param id el id del sponsor
     * @return o el sponsor si lo encuentra, o null
     */

    @Override
    public Sponsor findById(Integer id) {
        Sponsor sponsor = null;
        try {

            String query = "select * from sponsor where codigo = ?";

            conexion = DriverManager.getConnection(db, user, pass);

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, id.toString());


            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                sponsor = new Sponsor(
                        resultado.getInt("codigo"),
                        resultado.getString("nombre"));
            }

            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return sponsor;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return sponsor;
        }
        return sponsor;
    }

    /**
     * Método que devuelve una lista con todos los sponsors actualmente en la base
     *
     * @return la lista con sponsors
     */
    @Override
    public List<Sponsor> findAll() {
        List<Sponsor> sponsors;
        try {
            sponsors = new ArrayList<>();
            String query = "select * from sponsor";

            conexion = DriverManager.getConnection(db, user, pass);

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                sponsors.add(new Sponsor((resultado.getInt("codigo")), resultado.getString("nombre")));
            }
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return null;
        }
        return sponsors;
    }

    /**
     * Borrar un sponsor por codigo
     *
     * @param codigo el codigo de sponsor a borrar
     * @return true si lo consigue borrar, false si no
     */
    @Override
    public boolean delete(Integer codigo) {

        boolean result = false;

        try  {
            conexion = DriverManager.getConnection(db, user, pass);
            conexion.setAutoCommit(false);
            PreparedStatement ps;

            String selectTenistaContratoQuery = "SELECT codigo FROM contrato WHERE codSponsor = ?";
            String deleteTenistaContratoQuery = "DELETE FROM tenistacontrato WHERE codContrato = ?";
            String deleteContratoQuery = "DELETE FROM contrato WHERE codSponsor = ?";
            String deleteSponsorQuery = "DELETE FROM sponsor WHERE codigo = ?";

            ps = conexion.prepareStatement(selectTenistaContratoQuery);
            ps.setInt(1, codigo);
            ResultSet resultado = ps.executeQuery();

            UUID codigoContrato;
            while (resultado.next()) {
                codigoContrato = UUID.fromString(resultado.getString("codigo"));

                ps = conexion.prepareStatement(deleteTenistaContratoQuery);
                ps.setObject(1, codigoContrato);
                result = ps.executeUpdate() > 0;
            }

            ps = conexion.prepareStatement(deleteContratoQuery);
            ps.setObject(1, codigo);
            result = ps.executeUpdate() > 0;

            ps = conexion.prepareStatement(deleteSponsorQuery);
            ps.setInt(1, codigo);
            result = ps.executeUpdate() > 0;

            if (!result) {
                System.out.println("ERROR: No se ha eliminado sponsor");
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

        System.out.println("Sponsor se ha eliminado correctamente");
        return result;
    }

    /**
     * Actualizar los datos de un sponsor en específico
     *
     * @param sponsor el sponsor a actualizar
     * @return true si lo ha conseguido, false si no
     */
    @Override
    public boolean update(Sponsor sponsor) {
        Tenista tenista = null;
        try {

            String query = "UPDATE sponsor\n" +
                    "SET nombre = ?" +
                    "WHERE codigo = ?;";

            conexion = DriverManager.getConnection(db, user, pass);

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, sponsor.getNombre());
            ps.setInt(2, sponsor.getCodigo());

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
     * Obtiene todos los sponsors que obtienen con la suma de sus contratos más de un millón de euros
     *
     * @return la lista con los sponsors ricos
     */
    @Override
    public List<Sponsor> getRichSponsor() {
        List<Sponsor> sponsors;
        try {
            sponsors = new ArrayList<>();
            String query = "call getRichSponsors()";

            conexion = DriverManager.getConnection(db, user, pass);

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                sponsors.add(new Sponsor((resultado.getInt("codigo")), resultado.getString("nombre")));
            }
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
            return null;
        }
        return sponsors;
    }
}
