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
    private int id;
    private int prodId;   
    private int prodFilial;
    private String prodNome;
    private String prodAutor;
    private String prodGenero;
    private int prodQtd;
    private double prodValCompra;
    private double prodValVenda;
    private String prodDesc;
    
    public Produtos(){
        
    }
    public Produtos(int id, int filial, String nome, String autor, 
            String genero, int qtd, double valCompra, double valVenda, String descricao) {
    this.prodId = id;
    this.prodFilial = filial;
    this.prodNome = nome;
    this.prodAutor = autor;
    this.prodGenero = genero;
    this.prodQtd = qtd;
    this.prodValCompra = valCompra;
    this.prodValVenda = valVenda;
    this.prodDesc = descricao;
  }      
    public int getIdProd(){
        return prodId;
    }
    
    public void setIdProd(int id){
        this.prodId = id;
    }
    
    public int getFilialProd(){
        return prodFilial;
    }
    
    public void setFilialProd(int filial){
        this.prodFilial = filial;
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
    public int getQtdProd(){
        return prodQtd;
    }
    public void setQtdProd(int qtd){
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
