/**
 * @author Gabri
 */

package br.com.clark.service;


import br.com.clark.dao.IClienteDAO;
import br.com.clark.domain.Cliente;
import br.com.clark.exceptions.TipoChaveNaoEncontradaException;
import br.com.clark.service.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);

    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return this.dao.consultar(cpf);
    }

}
