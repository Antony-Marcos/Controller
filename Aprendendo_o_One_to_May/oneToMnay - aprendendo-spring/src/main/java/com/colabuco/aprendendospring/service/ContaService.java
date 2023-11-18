package com.colabuco.aprendendospring.service;

import com.colabuco.aprendendospring.model.Cliente;
import com.colabuco.aprendendospring.model.Conta;
import com.colabuco.aprendendospring.repository.ClienteRepository;
import com.colabuco.aprendendospring.repository.ContaRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ContaService {

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;
    @Autowired

    public ContaService(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    public Conta criarConta(Conta conta, long idCliente){
       Optional<Cliente> opCliente = clienteRepository.findById(idCliente);

       if(opCliente.isEmpty()){
           return null;
       } else {
           opCliente.get().getContas().add(conta);
           conta.setCliente(opCliente.get());
           return contaRepository.save(conta);
       }
    }

    public List<Conta> ListarContas(){
        return contaRepository.findAll();
    }

    public Optional<Conta> returnarContapeloId(Long id){
        return contaRepository.findById(id);
    }


}
