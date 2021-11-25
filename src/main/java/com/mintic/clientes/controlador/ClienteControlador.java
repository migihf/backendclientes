package com.mintic.clientes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mintic.clientes.modelo.Cliente;
import com.mintic.clientes.servicio.ClienteServicio;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE })
@RequestMapping("/api/clientes")

public class ClienteControlador {	
	@Autowired
	private ClienteServicio clienteServicio;
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAllClientes(){
		return ResponseEntity.ok().body(clienteServicio.getAllCliente());
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable String id) {
		return ResponseEntity.ok().body(clienteServicio.getClienteById(id));
	}
	
	@PostMapping("/clientes")
	public ResponseEntity < Cliente > crearCliente(@RequestBody Cliente cliente){
		return ResponseEntity.ok().body(this.clienteServicio.crearCliente(cliente));
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable String id, @RequestBody Cliente cliente){
		cliente.set_id(id);
		return ResponseEntity.ok().body(this.clienteServicio.updateCliente(cliente));
	}
	
	@DeleteMapping("/clientes/{id}")
	public HttpStatus deleteCliente(@PathVariable String id) {
		this.clienteServicio.deleteCliente(id);
		return HttpStatus.OK;
	}
}