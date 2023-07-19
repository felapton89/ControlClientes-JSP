package ar.com.clientesjsp.controlclientes.dao.impl;

import ar.com.clientesjsp.controlclientes.config.ConnectionConfig;
import ar.com.clientesjsp.controlclientes.dao.ClienteDAO;
import ar.com.clientesjsp.controlclientes.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC implements ClienteDAO {

    public String getDatabaseName() {
        try (
                Connection conn = ConnectionConfig.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT DATABASE()");
        ) {
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        try (
                Connection conn = ConnectionConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM CLIENTES");
                ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setSaldo(rs.getDouble("saldo"));
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Cliente findById(int id) {
        Cliente cliente = null;
        try (
                Connection conn = ConnectionConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM CLIENTES WHERE ID_CLIENTE = ?")
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("id_cliente"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellido((rs.getString("apellido")));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefono(rs.getString("telefono"));
                    cliente.setSaldo(rs.getDouble("saldo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public void save(Cliente cliente) {
        try (
                Connection conn = ConnectionConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO CLIENTES (nombre, apellido, email, telefono, saldo) VALUES (?, ?, ?, ? ,?)");
        ) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getTelefono());
            pstmt.setDouble(5, cliente.getSaldo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cliente cliente) {
        try (
                Connection conn = ConnectionConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE CLIENTES SET NOMBRE=?, APELLIDO=?, EMAIL=?, TELEFONO=?, SALDO=? WHERE ID_CLIENTE = ?")
        ) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getTelefono());
            pstmt.setDouble(5, cliente.getSaldo());
            pstmt.setInt(6, cliente.getIdCliente());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        try (
                Connection conn = ConnectionConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM CLIENTES WHERE ID_CLIENTE = ?");
        ) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
