package com.mintic.clientes.servicio;

import java.util.List;

import com.mintic.clientes.modelo.Cliente;

public interface ClienteServicio {
	
    Cliente crearCliente(Cliente cliente);

    Cliente updateCliente(Cliente cliente);

    List<Cliente> getAllCliente();

    Cliente getClienteById(String clienteId);

    void deleteCliente(String clienteId);	

}
