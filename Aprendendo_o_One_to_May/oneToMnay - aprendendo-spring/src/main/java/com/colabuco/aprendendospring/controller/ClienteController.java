package com.colabuco.aprendendospring.controller;

import com.colabuco.aprendendospring.model.Cliente;
import com.colabuco.aprendendospring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

   private final ClienteService clienteService;

   @Autowired

   public ClienteController(ClienteService clienteService) {
      this.clienteService = clienteService;
   }

   @PostMapping
   public Cliente criarCliente(@RequestBody Cliente cliente){
      return clienteService.criarCliente(cliente);
   }
}
