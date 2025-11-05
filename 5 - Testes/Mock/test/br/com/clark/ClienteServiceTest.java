/**
 * @author Gabri
 */

package br.com.clark;

import br.com.clark.dao.ClienteDao;
import br.com.clark.dao.ClienteDaoMock;
import br.com.clark.service.ClienteService;
import org.junit.Assert;
import org.junit.Test;

public class ClienteServiceTest {

    @Test
    public void SalvarTest() {
        ClienteDaoMock mockService = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockService);
        String retorno = service.Salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void EsperadoErroNoSalvarTest() {
        ClienteDao cliDao = new ClienteDao();
        ClienteService service = new ClienteService(cliDao);
        String retorno = service.Salvar();
        Assert.assertEquals("Sucesso", retorno);
    }
}
