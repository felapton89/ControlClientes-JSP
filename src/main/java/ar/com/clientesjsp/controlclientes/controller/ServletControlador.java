package ar.com.clientesjsp.controlclientes.controller;

import ar.com.clientesjsp.controlclientes.config.ConnectionConfig;
import ar.com.clientesjsp.controlclientes.model.Cliente;
import ar.com.clientesjsp.controlclientes.service.ClienteService;
import ar.com.clientesjsp.controlclientes.service.impl.ClienteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    private ClienteService service;


    @Override
    public void init() {
        ConnectionConfig.setupDatabase();
        service = new ClienteServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "edit":
                    editUser(req, resp);
                    break;
                case "delete":
                    int idClient = Integer.parseInt(req.getParameter("idClient"));
                    service.deleteById(idClient);
                    getData(req, resp);
                    break;
                default:
                    getData(req, resp);
            }
        } else {
            getData(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "insert":
                service.save(req);
                getData(req, resp);
                break;
            case "update":
                service.update(req);
                getData(req, resp);
                break;
            default:
                getData(req, resp);
        }
    }

    private void getData(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Cliente> clientes = service.findAll();
        double saldoTotal = service.saldoTotal(clientes);

        HttpSession session = req.getSession();
        session.setAttribute("clientes", clientes);
        session.setAttribute("saldoTotal", saldoTotal);
        session.setAttribute("totalClientes", clientes != null ? clientes.size() : 0);

        resp.sendRedirect("clientes.jsp");
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente client = service.findById(Integer.parseInt(req.getParameter("idClient")));
        req.setAttribute("client", client);
        String jspEdit = "/WEB-INF/privatesJsps/client/updateClient.jsp";
        req.getRequestDispatcher(jspEdit).forward(req, resp);
    }
}
