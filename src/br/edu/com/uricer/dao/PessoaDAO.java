package br.edu.com.uricer.dao;

import br.edu.com.uricer.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class PessoaDAO {

    private Connection con;

    public PessoaDAO(Connection con) {
        this.con = con;
    }

    public Integer create(Pessoa pessoa) throws SQLException {
        String sql = "insert into Pessoas(nome, endereco, email, telefone) values (? ,?, ?, ?)";
        Integer idCriado = 0;
        try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stm.setString(1, pessoa.getNome());
            stm.setString(2, pessoa.getEndereco());
            stm.setString(3, pessoa.getEmail());
            stm.setInt(4, pessoa.getTelefone());
            stm.execute();
            
            try (ResultSet resultSet = stm.getGeneratedKeys()) {
                while (resultSet.next()) {
                    idCriado = resultSet.getInt(1);
                }
            }            
            con.commit();
        } catch (Exception ex) {
            System.out.println("Erro ao tentar executar insercao: " + ex.getMessage());
            con.rollback();
        }
        
        return idCriado;
    }
    
    public Pessoa findById(Integer id) throws SQLException {
        String sql = "Select * from Pessoas p where p.id = ?";
        Pessoa pessoa = null;
        try(PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, id);
            stm.execute();
            
            try(ResultSet resultSet = stm.getResultSet()) {
                while(resultSet.next()) {
                    pessoa = new Pessoa();
                    pessoa.setId(resultSet.getInt("id"));
                    pessoa.setNome(resultSet.getString("nome"));
                    pessoa.setEndereco(resultSet.getString("endereco"));
                }
            }
        }
        
        return pessoa;
    }
    
    public List<Pessoa> findByNome(String nome) throws SQLException {
        String sql = "Select * from Pessoas p where upper(p.nome) like ?";
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa = null;
        try(PreparedStatement stm = con.prepareStatement(sql)) {
            
            stm.setString(1, "%" + nome.toUpperCase() + "%");
            stm.execute();
            
            try(ResultSet resultSet = stm.getResultSet()) {
                while(resultSet.next()) {
                    pessoa = new Pessoa();
                    pessoa.setId(resultSet.getInt("id"));
                    pessoa.setNome(resultSet.getString("nome"));
                    pessoa.setEndereco(resultSet.getString("endereco"));
                    pessoa.setEmail(resultSet.getString("email"));
                    pessoa.setTelefone(resultSet.getInt("telefone"));
                    pessoas.add(pessoa);
                }
            }
        }
        
        return pessoas;
    }   
    
    public void update(Pessoa pessoa) throws SQLException {
        String sql = "update Pessoas set nome = ? where id = ?";
        
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, pessoa.getNome());
            stm.setInt(2, pessoa.getId());
            stm.setString(3, pessoa.getEndereco());
            stm.setString(4, pessoa.getEmail());
            stm.setInt(5, pessoa.getTelefone());
            stm.executeUpdate();
            
            con.commit();
        } catch (Exception ex) {
            System.out.println("Erro ao tentar executar atualização: " + ex.getMessage());
            con.rollback();
        }
    }
    
    public void delete(Pessoa pessoa) throws SQLException {
        String sql = "delete from Pessoas where id = ?";
        
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, pessoa.getId());
            stm.executeUpdate();
            
            con.commit();
        } catch (Exception ex) {
            System.out.println("Erro ao tentar excluir: " + ex.getMessage());
            con.rollback();
        }
    }    
    

}
