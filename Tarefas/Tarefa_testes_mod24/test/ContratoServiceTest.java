import br.com.clark.dao.ContratoDao;
import br.com.clark.dao.IContratoDao;
import br.com.clark.dao.mocks.ContratoDaoMock;
import br.com.clark.service.ContratoService;
import br.com.clark.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

/**
 * @author Gabri
 */

public class ContratoServiceTest {


    @Test
    public void SalvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso ao salvar", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso ao salvar", retorno);
    }

    @Test
    public void BuscarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Sucesso ao buscar", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroAoBuscarComBancoTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Sucesso ao buscar", retorno);
    }

    @Test
    public void ExcluirTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Sucesso ao excluir", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroAoExcluirComBancoTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Sucesso ao excluir", retorno);
    }

    @Test
    public void AtualizarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Sucesso ao atualizar", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroAoAtualizarComBancoTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String returno = service.atualizar();
        Assert.assertEquals("Sucesso ao atualizar", returno);
    }

}
