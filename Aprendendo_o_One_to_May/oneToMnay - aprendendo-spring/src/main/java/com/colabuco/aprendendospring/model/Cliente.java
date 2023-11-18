package com.colabuco.aprendendospring.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

//@Entity jackarta.persistence -> para declarar que cliente seria uma entidade
@Entity
public class Cliente {
    //anotação para declarar que é uma priory key
    @Id
    //para setar de forma automatica ids(de maneira sequencial)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //para indicar que esse atributo não aceita valores nullos
    @Column(nullable = false)
    private String nome;
    //para representar relações entre classes e com esse parâmetro, declkaramos que um faz o que o outro faz
    //ex.: se um é excluído, o outro também

    @JsonIgnore
    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    //criando uma chave estrangeira
    private ArrayList<Conta> contas;

    public Cliente(){

    }

    public Cliente(String nome, ArrayList<Conta> contas){
        this.nome = nome;
        this.contas = contas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }
}
