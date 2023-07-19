package ar.com.clientesjsp.controlclientes.dao;

import ar.com.clientesjsp.controlclientes.model.Cliente;

import java.util.List;

public interface ClienteDAO {

    String getDatabaseName();

    List<Cliente> findAll();

    Cliente findById(int id);

    void save(Cliente cliente);

    void update(Cliente cliente);

    void deleteById(int id);

}
