package com.colabuco.aprendendospring.repository;

import com.colabuco.aprendendospring.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
