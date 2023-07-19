package ar.com.clientesjsp.controlclientes.service.impl;

import ar.com.clientesjsp.controlclientes.dao.ClienteDAO;
import ar.com.clientesjsp.controlclientes.dao.impl.ClienteDaoJDBC;
import ar.com.clientesjsp.controlclientes.model.Cliente;
import ar.com.clientesjsp.controlclientes.service.ClienteService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

public class ClienteServiceImpl implements ClienteService {

    ClienteDAO dao;

    public ClienteServiceImpl() {
        dao = new ClienteDaoJDBC();
    }

    @Override
    public List<Cliente> findAll() {
        return dao.findAll();
    }

    @Override
    public Cliente findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void save(HttpServletRequest req) {
        Cliente c = setClient(req);
        dao.save(c);
    }

    @Override
    public void update(HttpServletRequest req) {
        Cliente c = setClient(req);
        dao.update(c);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public double saldoTotal(List<Cliente> clientes) {
        if (clientes.size() > 0) {
            return clientes.stream()
                    .mapToDouble(Cliente::getSaldo)
                    .sum();
        } else {
            return 0;
        }
    }

    private Cliente setClient(HttpServletRequest req) {
        Cliente client;
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        double saldo = Double.parseDouble(req.getParameter("saldo"));
        String idClient = req.getParameter("idClient");
        if (Objects.nonNull(idClient)) {
            int id = Integer.parseInt(idClient);
            client = new Cliente(id, nombre, apellido, email, telefono, saldo);
        } else {
            client = new Cliente(nombre, apellido, email, telefono, saldo);
        }
        return client;
    }
}
