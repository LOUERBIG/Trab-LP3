/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.com.uricer.view;

import br.edu.com.uricer.model.Pessoa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gabriel
 */
public class PessoaTableModel extends AbstractTableModel {

    private List<Pessoa> pessoas;

    public PessoaTableModel(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public int getRowCount() {
        return pessoas.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pessoa pessoa = pessoas.get(rowIndex);
        switch (columnIndex) {
            case 0: return pessoa.getId();
            case 1: return pessoa.getNome();
            case 2: return pessoa.getEndereco();
            case 3: return pessoa.getBairro();
            case 4: return pessoa.getCidade();
            case 5: return pessoa.getUf();
            case 6: return pessoa.getEmail();
            case 7: return pessoa.getData();
            case 8: return pessoa.getTelefone();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Id";
            case 1: return "Nome";
            case 2: return "Endereco";
            case 3: return "Bairro";
            case 4: return "Cidade";
            case 5: return "Uf";
            case 6: return "Email";
            case 7: return "Data de Nascimento";
            case 8: return "Telefone";
            default:
                throw new AssertionError();
        }
    }

}
