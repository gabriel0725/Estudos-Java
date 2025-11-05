/**
 * @author Gabri
 */

package br.com.clark.dao;

public class ClienteDaoMock implements IClienteDao{

    @Override
    public String Salvar() {
        return "Sucesso com mock";
    }
}
