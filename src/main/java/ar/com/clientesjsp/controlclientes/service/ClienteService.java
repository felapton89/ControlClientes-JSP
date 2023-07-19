package ar.com.clientesjsp.controlclientes.service;

import ar.com.clientesjsp.controlclientes.model.Cliente;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente findById(int id);

    void save(HttpServletRequest req);

    void update(HttpServletRequest req);

    void deleteById(int id);

    double saldoTotal(List<Cliente> clientes);

}
