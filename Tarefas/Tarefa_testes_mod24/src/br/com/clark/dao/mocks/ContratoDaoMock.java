/**
 * @author Gabri
 */

package br.com.clark.dao.mocks;

import br.com.clark.dao.IContratoDao;

public class ContratoDaoMock implements IContratoDao {

    @Override
    public String salvar() {
        return "Salvo com sucesso mock";
    }

    @Override
    public void buscar() {

    }

    @Override
    public void excluir() {

    }

    @Override
    public void atualizar() {

    }
}
