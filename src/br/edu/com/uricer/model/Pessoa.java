package br.edu.com.uricer.model;

import java.math.BigInteger;

/**
 *
 * @author Gabriel
 */
public class Pessoa {
    
    private Integer id;
    private String nome;
    private String endereco;
    private Integer telefone;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    @Override
    public String toString() {
        return "Pessoa[id: " + id + " nome: " + nome + "endereco: " + endereco + "telefone: " + telefone + "Email: " + email + "]";
    }
}
