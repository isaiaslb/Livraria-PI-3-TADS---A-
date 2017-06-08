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
    //private int id;
    private int prodId;   
    private int prodFilial;
    private String prodNome;
    private String prodAutor;
    private String prodGenero;
    private int prodQtd;    
    private double prodVal;
    private String prodDesc;
    
    public Produtos(){
        
    }
//    public Produtos(int filial, String nome, String autor, 
//            String genero, int qtd, double val, String descricao) {
//   // this.prodId = id;
//    this.prodFilial = filial;
//    this.prodNome = nome;
//    this.prodAutor = autor;
//    this.prodGenero = genero;
//    this.prodQtd = qtd;
//    this.prodValVenda = val;
//    this.prodDesc = descricao;
//  }      
    public Produtos(int id,int filial, String nome, String autor, 
            String genero, int qtd, double val, String descricao) {
    this.prodId = id;
    this.prodFilial = filial;
    this.prodNome = nome;
    this.prodAutor = autor;
    this.prodGenero = genero;
    this.prodQtd = qtd;   
    this.prodVal = val;
    this.prodDesc = descricao;
  }      

    public int getProdId(){
        return prodId;
    }
    
    public void setProdId(int id){
        this.prodId = id;
    }
  
    
    public int getProdFilial(){
        return prodFilial;
    }
    
    public void setProdFilial(int filial){
        this.prodFilial = filial;
    }
    
    public String getProdNome(){
        return prodNome;
    }
    
    public void setProdNome(String nome){
        this.prodNome = nome;
    }
    
    public String getProdAutor(){
        return prodAutor;
    }
    
    public void setProdAutor(String autor){
        this.prodAutor = autor;
    }
    public String getProdGenero(){
        return prodGenero;        
    }
    public void setProdGenero(String genero){
        this.prodGenero = genero;
    }
    public int getProdQtd(){
        return prodQtd;
    }
    public void setProdQtd(int qtd){
        this.prodQtd = qtd;
    }
   
    public double getProdVal(){
        return prodVal;
    }
    public void setProdVal(double vVenda){
        this.prodVal = vVenda;
    }
    public String getProdDesc(){
        return prodDesc;
    }
    public void setProdDesc(String desc){
        this.prodDesc = desc;
    }

    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/
}
