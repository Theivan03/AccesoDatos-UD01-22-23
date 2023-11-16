package model.repository.Contrato;

import model.entity.Contrato;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class ContratoRepository implements IContratoRepository {

    private final String CONFIG_FILE = "src/main/resources/propiedades.properties";
    private Connection conexion;
    private String db, user, pass;

    public ContratoRepository() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(CONFIG_FILE));

            db = properties.getProperty("URL");
            user = properties.getProperty("USER");
            pass = properties.getProperty("PASS");
        } catch (IOException ex) {
            System.out.println("ERROR ARCHIVO CONSTRUCTOR REPOSITORIO CONTRATO: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("ERROR GENERICO CONSTRUCTOR REPOSITORIO CONTRATO: " + ex.getMessage());
        }
    }

    @Override
    public void save(Contrato contrato) {
        try {

            String query = "INSERT INTO contrato (codigo, fechaInicio, fechaFin, saldo, codSponsor) " +
                    "VALUES(?, ?, ?, ?, ?)";

            conexion = DriverManager.getConnection(db, user, pass);
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, contrato.getCodigo().toString());
            ps.setDate(2, Date.valueOf(contrato.getFechaInicio()));
            ps.setDate(3, Date.valueOf(contrato.getFechaFin()));
            ps.setDouble(4, contrato.getSueldo());
            ps.setInt(5, contrato.getCodSponsor());

            ps.executeQuery();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("error sql: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("error genérico: " + ex.getMessage());
        }
    }
}
