/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.model;

/**
 *
 * @author Isaias
 */
public class PesquisaUsuario {
    private String cpfBusca;

    public PesquisaUsuario(){
        
    }
    
    public PesquisaUsuario(String cpf){
        this.cpfBusca = cpf;
    }
    
    public String getCpfBusca() {
        return cpfBusca;
    }

    public void setCpfBusca(String cpfBusca) {
        this.cpfBusca = cpfBusca;
    }
    
}
