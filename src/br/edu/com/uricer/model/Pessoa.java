package br.edu.com.uricer.model;

/**
 *
 * @author Gabriel
 */
public class Pessoa {
    
    private Integer id;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String data;
    private String email;
    private String telefone;

    public String getEndereco() {
        return endereco;
    }

    public Integer getId() {
        return id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    @Override
    public String toString() {
        return "Pessoa[id: " + id + " nome: " + nome + "endereco:" + endereco + "bairro" + bairro + "cidade:" + cidade + "uf:" + uf + "email:" + email + "data:" + data + "telefone:" + telefone +"]";
    }
}
