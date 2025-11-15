package br.com.clark.dao;

import br.com.clark.domain.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws SQLException;

    Cliente consultar(String codigo) throws SQLException;

    Integer excluir(Cliente clienteBD) throws SQLException;


    List<Cliente> buscarTodos() throws SQLException;

    Integer atualizar(Cliente cliente) throws SQLException;
}
