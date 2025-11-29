import dao.*;
import domain.Acessorio;
import domain.Carro;
import domain.Marca;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Gabri
 */

public class MarcaTest {

    private ICarroDao carroDao;
    private IAcessorioDao acessorioDao;
    private IMarcaDao marcaDao;

    public MarcaTest(){
        marcaDao = new MarcaDao();
        carroDao = new CarroDao();
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void cadastrarMarcaTest(){

        Marca marca = new Marca();
        marca.setPais("Japão");
        marca.setNome("Nissan");
        marca.setCodigo("M16");
        marca = marcaDao.cadastrar(marca);

        Carro carro = criarCarro("C15", marca);

        assertNotNull(marca);
        assertNotNull(marca.getId());
    }

    private Carro criarCarro(String codigo, Marca marca) {
        Acessorio acessorio1 = criarAcessorio("A15");
        Acessorio acessorio2 = criarAcessorio("A23");
        Carro carro = new Carro();
        carro.setNome("Tiida");
        carro.setCodigo(codigo);
        carro.add(acessorio1);
        carro.add(acessorio2);
        carro.setAno(2011);
        carro.setMarca(marca);
        return carroDao.cadastrar(carro);
    }

    private Acessorio criarAcessorio(String codigo) {
        Acessorio acessorio = new Acessorio();
        acessorio.setDescricao("descrição do acessorio");
        acessorio.setCodigo(codigo);
        acessorio.setNome("porta copo");
        return acessorio;
    }


}
