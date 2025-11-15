/**
 * @author Gabri
 */

package br.com.clark;

import br.com.clark.dao.ClienteDAO;
import br.com.clark.dao.IClienteDAO;
import br.com.clark.domain.Cliente;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {

    @Test
    public void cadastrarTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();

        cliente.setCodigo("01");
        cliente.setNome("Clark");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer qtdDel = dao.excluir(clienteBD);
        assertTrue(qtdDel == 1);
    }

    @Test
    public void consultarTodos() throws SQLException {
        IClienteDAO dao = new ClienteDAO();

        // Criação da lista de clientes diretamente
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        listaCliente.add(new Cliente("01", "Clark"));
        listaCliente.add(new Cliente("02", "Thiago"));
        listaCliente.add(new Cliente("03", "Jhow"));

        int qtdCadastrada = 0;

        for (Cliente cliente : listaCliente) {
            qtdCadastrada += dao.cadastrar(cliente);
        }
        assertTrue(qtdCadastrada == listaCliente.size());

        List<Cliente> listaClientesBD = dao.buscarTodos();
        assertNotNull(listaClientesBD);
        assertEquals(listaCliente.size(), listaClientesBD.size());

        int qtdDeletada = 0;

        for (Cliente cliente : listaClientesBD) {
            qtdDeletada += dao.excluir(cliente);
        }

        assertEquals(qtdDeletada, listaClientesBD.size());

        listaClientesBD = dao.buscarTodos();
        assertEquals(listaClientesBD.size(),0);

    }

    @Test
    public void atualizarTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente("01","Clark");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar("01");
        assertNotNull(clienteBD);
        clienteBD.setCodigo("02");
        clienteBD.setNome("Gabriel");

        Integer qtdAtualizar = dao.atualizar(clienteBD);
        assertTrue(qtdAtualizar == 1);

        List<Cliente> listaClientesBD = dao.buscarTodos();
        for (Cliente clienteCadBD : listaClientesBD) {
            dao.excluir(clienteCadBD);
        }
    }

    @Test
    public void excluirTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente("01","Clark");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Integer qtdExcluido = dao.excluir(cliente);
        assertTrue(qtd == 1);

        List<Cliente> listaClientesBD = dao.buscarTodos();
        assertEquals(listaClientesBD.size(), 0);
    }

    @Test
    public void buscarTest() throws SQLException {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente("10", "Gabriel");

        Integer qtdCadastrada = dao.cadastrar(cliente);
        assertTrue(qtdCadastrada == 1);

        Cliente clienteBD = dao.consultar("10");
        assertNotNull(clienteBD);
        assertEquals(clienteBD.getCodigo(),cliente.getCodigo());
        assertEquals(clienteBD.getNome(),cliente.getNome());

        Integer qtdExcluida = dao.excluir(clienteBD);
        assertTrue(qtdExcluida == 1);
    }
}
