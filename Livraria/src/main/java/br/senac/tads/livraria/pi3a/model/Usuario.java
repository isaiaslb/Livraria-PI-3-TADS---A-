/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.model;

import java.util.Date;

/**
 *
 * @author Isaias
 */
public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String fixo;
    private String cel;
    private String setor;
    private String sexo;
    private String senha;
    private String tipoAcesso;
    private Date dataNasc;
            
    public Usuario() {

    }

    public Usuario(String nome, String email, String fixo, String cel, String setor,
            String sexo, String senha, String tipoAcesso, Date dataNasc) {
        this.nome = nome;
        this.email = email;
        this.fixo = fixo;
        this.cel = cel;
        this.setor = setor;
        this.sexo = sexo;
        this.senha = senha;
        this.tipoAcesso = tipoAcesso;
        this.dataNasc = dataNasc;
    }

    public Usuario(int id, String nome, String email, String fixo, String cel,
            String setor, String sexo, String senha, String tipoAcesso, Date dataNasc) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.fixo = fixo;
        this.cel = cel;
        this.setor = setor;
        this.sexo = sexo;
        this.senha = senha;
        this.tipoAcesso = tipoAcesso;
        this.dataNasc = dataNasc;
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

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexor) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
    this.senha = senha;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(String tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}