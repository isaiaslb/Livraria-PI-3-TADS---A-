/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.livraria.pi3a.dao;


import br.senac.tads.livraria.pi3a.model.Produtos;
import java.util.List;

/**
 *
 * @author Marcus
 */
public interface ProdutosDao{
    
    public void inserir(Produtos produto);
    public void remover(int id); 
    public List<Produtos> listar();
    public Produtos buscar(String produto, String Autor);
    public void alterar(Produtos produto);
    
}
