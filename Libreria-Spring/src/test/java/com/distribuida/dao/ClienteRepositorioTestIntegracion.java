package com.distribuida.dao;

import ch.qos.logback.core.net.server.Client;
import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional

@Rollback(value = false)


public class ClienteRepositorioTestIntegracion {

    @Autowired
    private ClienteRepositorio clienteRepositorio;


    @Test
    public void findAll(){
    List<Cliente> clientes = clienteRepositorio.findAll();
    for(Cliente item : clientes) {
        System.out.println(item.toString());
    }
    }

    @Test
    public void findOne(){

    }

    @Test
    public void save(){
        Cliente cliente = new Cliente(0,"1751881100","juan","caiza","pifo","09873664","example@example.com");
        clienteRepositorio.save(cliente);
    }

    @Test
    public void update(){
        Optional<Cliente> clienteExistente = clienteRepositorio.findById(39);
        clienteExistente.orElse(null).setCedula("456465464");
        clienteExistente.orElse(null).setNombre("Jhoel");
        clienteExistente.orElse(null).setApellido("chilcañan");
        clienteExistente.orElse(null).setDireccion("puembo");
        clienteExistente.orElse(null).setTelefono("0983737373");
        clienteExistente.orElse(null).setCorreo("exampple1@example1.com");

        clienteRepositorio.save(clienteExistente.orElse(null));

    }

    @Test
    public void delete(){
        if(clienteRepositorio.existsById(39)){
            clienteRepositorio.deleteById(39);
        }
    }
}

