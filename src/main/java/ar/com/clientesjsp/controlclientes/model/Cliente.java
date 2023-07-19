package ar.com.clientesjsp.controlclientes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private double saldo;

    //Constructor util para eliminar registros de la BD
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    //Constructor util para agregar registros en la BD, sin id porque es autoincrement
    public Cliente(String nombre, String apellido, String email, String telefono, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    //Constructor util para editar registros en la BD
    public Cliente(int idCliente, String nombre, String apellido, String email, String telefono, double saldo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }
}
