package com.colabuco.aprendendospring.repository;

import com.colabuco.aprendendospring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByNome(String nome);
}
