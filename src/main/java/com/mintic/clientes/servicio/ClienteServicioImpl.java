package com.mintic.clientes.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mintic.clientes.dao.IClienteRepositorio;
import com.mintic.clientes.excepcion.ResourceNotFoundException;
import com.mintic.clientes.modelo.Cliente;

@Service
@Transactional

public class ClienteServicioImpl implements ClienteServicio {
	
	@Autowired
	private IClienteRepositorio clienteRepo;	

	@Override
	public Cliente crearCliente(Cliente cliente) {
		return clienteRepo.save(cliente);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		// Buscar cliente con ID
		Optional<Cliente> clienteDb = this.clienteRepo.findById(cliente.get_id());
		
		if(clienteDb.isPresent()) {
			// Se crea un objeto tipo Cliente con los datos recuperados
			Cliente clienteUpdate = clienteDb.get();
			// Se actualiza el valor de cada atributo con el get correspondiente de cliente
			clienteUpdate.set_id(cliente.get_id());
			clienteUpdate.setCedula_cliente(cliente.getCedula_cliente());
			clienteUpdate.setDireccion_cliente(cliente.getDireccion_cliente());;
			clienteUpdate.setEmail_cliente(cliente.getEmail_cliente());
			clienteUpdate.setNombre_cliente(cliente.getNombre_cliente());
			clienteUpdate.setTelefono_cliente(cliente.getTelefono_cliente());
			
			// Se guarda el nuevo usuario
			clienteRepo.save(clienteUpdate);
			return clienteUpdate;
		} else {
			throw new ResourceNotFoundException("Cliente con ID '"+cliente.get_id()+"' no encontrado.");
		}
	}

	@Override
	public List<Cliente> getAllCliente() {
		return clienteRepo.findAll();
	}

	@Override
	public Cliente getClienteById(String clienteId) {
		Optional<Cliente> clienteDb = this.clienteRepo.findById(clienteId);
		if(clienteDb.isPresent()) {
			return clienteDb.get();
		} else {
			throw new ResourceNotFoundException("Cliente con ID '"+clienteId+"' no encontrado.");
		}
	}

	@Override
	public void deleteCliente(String clienteId) {
		Optional<Cliente> clienteDb = this.clienteRepo.findById(clienteId);
		if(clienteDb.isPresent()) {
			this.clienteRepo.delete(clienteDb.get());
		} else {
			throw new ResourceNotFoundException("Cliente con ID '"+clienteId+"' no encontrado.");
		}
	}
}