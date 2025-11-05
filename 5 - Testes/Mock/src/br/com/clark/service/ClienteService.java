/**
 * @author Gabri
 */

package br.com.clark.service;



import br.com.clark.dao.IClienteDao;


public class ClienteService {

    private IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao){
        this.clienteDao = clienteDao;
    }

    public String Salvar(){
        clienteDao.Salvar();
        return "Sucesso";
    }
}
