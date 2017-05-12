/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.model;

/**
 *
 * @author Fernanda
 */
public class Usuario{
    private int id;
    private String nome;
    private String email;
    private String fixo;
    
    public Usuario(){
        
    }
    public Usuario(String nome, String email, String fixo) {
    this.nome = nome;
    this.email = email;
    this.fixo = fixo;
  }
    public Usuario(int id, String nome,String email, String fixo) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.fixo = fixo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        this.fixo = fixo;
    }
}