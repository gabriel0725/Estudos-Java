package dao;

import domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public boolean excluir(Long cpf);

    public boolean alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();
}
