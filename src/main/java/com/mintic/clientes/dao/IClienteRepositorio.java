package com.mintic.clientes.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mintic.clientes.modelo.Cliente;

@Repository

public interface IClienteRepositorio extends MongoRepository<Cliente, String> {
}
