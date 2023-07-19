package ar.com.clientesjsp.controlclientes.config;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionConfig {
    private static final String JDBC_URL = "jdbc:h2:mem:data/control_clientes";
    private static final String JDBC_USERNAME = "sa";
    private static final String JDBC_PASSWORD = "";
    private static BasicDataSource ds;

    //Recuperamos la conexion a la base de datos
    private static DataSource getDataSource() {
        if (ds == null) {
            ds = new BasicDataSource();
            ds.setDriverClassName("org.h2.Driver");
            ds.setUrl(JDBC_URL);
            ds.setUsername(JDBC_USERNAME);
            ds.setPassword(JDBC_PASSWORD);
            ds.setInitialSize(5); //tamaño inicial del pool de conexiones
        }
        return ds;
    }

    //Metodo para obtener una conexion a partir del pool
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    // Método para configurar la base de datos y agregar una tabla
    public static void setupDatabase() {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            // Creación de la tabla CLIENTES
            String createTableSql = "CREATE TABLE IF NOT EXISTS CLIENTES (" +
                    "id_cliente INT PRIMARY KEY AUTO_INCREMENT, " +
                    "nombre VARCHAR(45), " +
                    "apellido VARCHAR(45), " +
                    "email VARCHAR(45), " +
                    "telefono VARCHAR(20), " +
                    "saldo DOUBLE)";
            stmt.executeUpdate(createTableSql);

            // Inserción de registros de ejemplo
            String insertCliente1Sql = "INSERT INTO CLIENTES (nombre, apellido, email, telefono, saldo) VALUES " +
                    "('John', 'Doe', 'jdoe@mail.com', '555444222', 450)";
            stmt.executeUpdate(insertCliente1Sql);

            String insertCliente2Sql = "INSERT INTO CLIENTES (nombre, apellido, email, telefono, saldo) VALUES " +
                    "('Mary', 'Ann', 'amary@mail.com', '999777333', 800)";
            stmt.executeUpdate(insertCliente2Sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
