import dao.IProdutoDao;
import dao.ProdutoDao;
import domain.Produto;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Gabri
 */

public class ProdutoTest {

    @Test
    public void cadastrar(){

        Produto produto = new Produto();
        IProdutoDao dao = new ProdutoDao();

        produto.setNome("Produto 01");
        produto.setQtd(50);
        dao.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());

    }
}
