
package br.senac.tads.livraria.pi3a.model;

/**
 *
 * @author Antonio
 */
public class Empresa {
    private int id;

    private String razao;
        private String cnpj;
    private String ie;
    private String telefone;
    private String endereco;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    
     public Empresa(){
        
    }
    public Empresa(String razao, String cnpj, String ie, String telefone, String endereco, 
            String numero, String complemento, String cep, String bairro,String cidade,String estado) {
    
    this.razao = razao;
    this.cnpj = cnpj;
    this.ie = ie;
    this.telefone = telefone;
    this.endereco = endereco;
    this.numero = numero;
    this.complemento = complemento;
    this.cep = cep;
    this.bairro = bairro;
    this.cidade=cidade;
    this.estado = estado;
    
  }
    
    public Empresa(int id,String razao, String cnpj,  String ie, String telefone, String endereco, 
            String numero, String complemento, String cep, String bairro,String cidade,String estado) {
    this.id = id;    
 
    this.razao = razao;
       this.cnpj = cnpj;
    this.ie = ie;
    this.telefone = telefone;
    this.endereco = endereco;
    this.numero = numero;
    this.complemento = complemento;
    this.cep = cep;
    this.bairro = bairro;
    this.cidade=cidade;
    this.estado = estado;
  }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getBairro () {
        return bairro;
    }
    
     public void setBairro(String bairro) {
        this.bairro = bairro;
    }
     
     public String getCidade () {
        return cidade;
    }
      public void setCidade(String cidade) {
        this.cidade = cidade;
    }
      public String getEstado () {
        return estado;
    }
       public void setEstado(String estado) {
        this.estado = estado;
    }
  
}
