/**
 * @author Gabri
 */

package br.com.clark.dao;

import br.com.clark.domain.Cliente;
import br.com.clark.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("Gabriel");
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");
        cliente.setEnd("endereço");
        cliente.setNumero(10);
        cliente.setTel(11989899889L);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Gabriel");
        clienteDao.alterar(cliente);
        Assert.assertEquals("Gabriel", cliente.getNome());
    }
}
