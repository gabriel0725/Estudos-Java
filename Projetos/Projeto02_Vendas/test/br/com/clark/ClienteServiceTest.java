/**
 * @author Gabri
 */

package br.com.clark;


import br.com.clark.dao.ClienteDaoMock;
import br.com.clark.dao.IClienteDAO;
import br.com.clark.domain.Cliente;
import br.com.clark.exceptions.TipoChaveNaoEncontradaException;
import br.com.clark.service.ClienteService;
import br.com.clark.service.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);

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
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Gabriel");
        clienteService.alterar(cliente);
        Assert.assertEquals("Gabriel", cliente.getNome());
    }
}
