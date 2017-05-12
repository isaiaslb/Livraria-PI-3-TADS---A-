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
    
    public static int prodId;   
    public static int prodFilial;
    public static String prodNome;
    public static String prodAutor;
    public static String prodGenero;
    public static int prodQtd;
    public static double prodValCompra;
    public static double prodValVenda;
    public static String prodDesc;
      
    public static int getIdProd(){
        return prodId;
    }
    
    public void setIdProd(int id){
        this.prodId = id;
    }
    
    public static int getFilialProd(){
        return prodFilial;
    }
    
    public void setFilialProd(int filial){
        this.prodFilial = filial;
    }
    
    public static String getNomeProd(){
        return prodNome;
    }
    
    public void setNomeProd(String nome){
        this.prodNome = nome;
    }
    
    public static String getAutorProd(){
        return prodAutor;
    }
    
    public void setAutorProd(String autor){
        this.prodAutor = autor;
    }
    public static String getGeneroProd(){
        return prodGenero;        
    }
    public void setGeneroProd(String genero){
        this.prodGenero = genero;
    }
    public static int getQtdProd(){
        return prodQtd;
    }
    public void setQtdProd(int qtd){
        this.prodQtd = qtd;
    }
    public static double getValCompraProd(){
        return prodValCompra;
    }
    public void setValCompraProd(double vCompra){
        this.prodValCompra = vCompra;
    }
    public static double getValVendaProd(){
        return prodValVenda;
    }
    public void setValVendaProd(double vVenda){
        this.prodValVenda = vVenda;
    }
    public static String getDescProd(){
        return prodDesc;
    }
    public void setDescProd(String desc){
        this.prodDesc = desc;
    }
}
