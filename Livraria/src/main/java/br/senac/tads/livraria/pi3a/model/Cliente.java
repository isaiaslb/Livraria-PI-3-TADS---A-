/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.model;

/**
 *
 * @author douglas.gsilva2
 */
public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String end;
    private String bairro;
    private String cep;
    private String estado;
    private String cel;
    private String email;
    
     public Cliente(){
        
    }
    public Cliente(String nome, String cpf, String end, String bairro, 
            String cep, String estado, String cel, String email) {
    this.nome = nome;
    this.cpf = cpf;
    this.end = end;
    this.bairro = bairro;
    this.cep = cep;
    this.estado = estado;
    this.cel = cel;
    this.email = email;
  }
    
    public Cliente(int id, String nome, String cpf, String end, String bairro, 
            String cep, String estado, String cel, String email) {
    this.id = id;    
    this.nome = nome;
    this.cpf = cpf;
    this.end = end;
    this.bairro = bairro;
    this.cep = cep;
    this.estado = estado;
    this.cel = cel;
    this.email = email;
  }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
}
