/**
 * @author Gabri
 */

package br.com.clark;

import br.com.clark.dao.IProdutoDAO;
import br.com.clark.dao.ProdutoDAO;
import br.com.clark.domain.Cliente;
import br.com.clark.domain.Produto;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {





    @Test
    public void cadastrarTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();

        produto.setCodigo("10");
        produto.setNome("Produto 01");
        produto.setQtd(30);

        Integer qtdCad = dao.cadastrar(produto);
        assertTrue(qtdCad == 1);

        Produto produtoBD = dao.buscar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertEquals(produtoBD.getCodigo(), produto.getCodigo());
        assertEquals(produtoBD.getNome(), produto.getNome());
        assertEquals(produtoBD.getQtd(), produto.getQtd());

        Integer qtdExcluida = dao.excluir(produtoBD);
        assertTrue(qtdExcluida >= 1);
    }

    @Test
    public void buscarTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto("10","Produto 01", 20);

        Integer qtdCad = dao.cadastrar(produto);
        assertTrue(qtdCad == 1);

        Produto produtoBD = dao.buscar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertEquals(produtoBD.getCodigo(), produto.getCodigo());
        assertEquals(produtoBD.getNome(), produto.getNome());
        assertEquals(produtoBD.getQtd(), produto.getQtd());

        Integer qtdExcluida = dao.excluir(produtoBD);
        assertTrue(qtdExcluida >= 1);

    }

    @Test
    public void exluirTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto("10","Produto 01", 20);

        Integer qtdCad = dao.cadastrar(produto);
        assertTrue(qtdCad == 1);

        Integer qtdExcluida = dao.excluir(produto);
        assertTrue(qtdExcluida >= 1);
    }

    @Test
    public void buscartodosTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();

        List<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto("10", "Produto 01", 50));
        listaProdutos.add(new Produto("20", "Produto 02", 30));
        listaProdutos.add(new Produto("30", "Produto 03", 10));

        int qtdCadastrada = 0;

        for (Produto produto : listaProdutos) {
            qtdCadastrada += dao.cadastrar(produto);
        }
        assertTrue(qtdCadastrada == listaProdutos.size());

        List<Produto> listaProdutoBD = dao.buscarTodos();
        assertNotNull(listaProdutoBD);
        assertEquals(listaProdutoBD.size(),listaProdutos.size());

        int qtdDeletada = 0;
        for (Produto produto : listaProdutoBD) {
            qtdDeletada += dao.excluir(produto);
        }
        assertEquals(qtdDeletada,listaProdutoBD.size());

        listaProdutoBD = dao.buscarTodos();
        assertEquals(listaProdutoBD.size(),0);

    }

    @Test
    public void atualizarTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto("10","Produto 01", 20);

        Integer qtdCad = dao.cadastrar(produto);
        assertTrue(qtdCad == 1);

        Produto produtoBD = dao.buscar(produto.getCodigo());
        assertNotNull(produtoBD);

        produtoBD.setCodigo("20");
        produtoBD.setNome("Outro produto");
        produtoBD.setQtd(30);

        Integer qtdAtualizada = dao.atualizar(produtoBD);
        assertTrue(qtdAtualizada >= 1);

        List<Produto> listaProdutosBD = dao.buscarTodos();
        for (Produto produtoCadBD : listaProdutosBD) {
            dao.excluir(produtoCadBD);
        }

    }



}
