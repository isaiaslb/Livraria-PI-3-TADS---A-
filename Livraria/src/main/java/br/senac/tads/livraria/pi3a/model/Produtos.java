/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.model;

/**
 *
 * @author Marcus
 */
public class Produtos {
    public Integer prodId;    
    public String prodNome;
    public String prodAutor;
    public String prodGenero;
    public Integer prodQtd;
    public double prodValCompra;
    public double prodValVenda;
    public String prodDesc;
    
    public Integer getIdProd(){
        return prodId;
    }
    
    public void setIdProd(Integer id){
        this.prodId = id;
    }
    
    public String getNomeProd(){
        return prodNome;
    }
    
    public void setNomeProd(String nome){
        this.prodNome = nome;
    }
    
    public String getAutorProd(){
        return prodAutor;
    }
    
    public void setAutorProd(String autor){
        this.prodAutor = autor;
    }
    public String getGeneroProd(){
        return prodGenero;        
    }
    public void setGeneroProd(String genero){
        this.prodGenero = genero;
    }
    public Integer getQtdProd(){
        return prodQtd;
    }
    public void setQtdProd(Integer qtd){
        this.prodQtd = qtd;
    }
    public double getValCompraProd(){
        return prodValCompra;
    }
    public void setValCompraProd(double vCompra){
        this.prodValCompra = vCompra;
    }
    public double getValVendaProd(){
        return prodValVenda;
    }
    public void setValVendaProd(double vVenda){
        this.prodValVenda = vVenda;
    }
    public String getDescProd(){
        return prodDesc;
    }
    public void setDescProd(String desc){
        this.prodDesc = desc;
    }
}
