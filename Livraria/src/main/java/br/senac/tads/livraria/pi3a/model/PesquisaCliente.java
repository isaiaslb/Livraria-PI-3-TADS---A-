/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.model;

/**
 *
 * @author Douglas
 */
public class PesquisaCliente {
    private String cpfBusca;

    public PesquisaCliente(){
        
    }
    
    public PesquisaCliente(String cpf){
        this.cpfBusca = cpf;
    }
    
    public String getCpfBusca() {
        return cpfBusca;
    }

    public void setCpfBusca(String cpfBusca) {
        this.cpfBusca = cpfBusca;
    }
    
}
