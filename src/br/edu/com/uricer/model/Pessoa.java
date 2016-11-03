package br.edu.com.uricer.model;

/**
 *
 * @author Gabriel
 */
public class Pessoa {
    
    private Integer id;
    private String nome;
    private String endereco;

    public String getEndereco() {
        return endereco;
    }

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
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa[id: " + id + " nome: " + nome + "endereco:" + endereco + "]";
    }
}
