/**
 * @author Gabri
 */

package br.com.clark.dao;

import br.com.clark.dao.generic.GenericDAO;
import br.com.clark.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    @Override
    public Class<Cliente> getTipoClasse() {
        return null;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
