package br.com.clark.dao;

import br.com.clark.domain.Produto;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoDAO {
    int cadastrar(Produto produto) throws SQLException;

    Produto buscar(String codigo) throws SQLException;

    Integer excluir(Produto produtoBD) throws SQLException;

    List<Produto> buscarTodos() throws SQLException;

    Integer atualizar(Produto produtoBD) throws SQLException;
}
