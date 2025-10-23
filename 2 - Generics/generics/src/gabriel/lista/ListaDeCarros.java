/**
 * @author Gabri
 */

package gabriel.lista;

import gabriel.carro.Carro;
import java.util.ArrayList;
import java.util.List;

public class ListaDeCarros implements GenericDAO<Carro> {

    private List<Carro> carros = new ArrayList<>();

    @Override
    public void adicionar(Carro carro) {
        carros.add(carro);
    }

    @Override
    public void remover(Carro carro) {
        carros.remove(carro);
    }

    @Override
    public Carro buscarPorIndice(int index) {
        if (index >= 0 && index < carros.size()) {
            return carros.get(index);
        }
        return null;
    }

    @Override
    public List<Carro> listarTodos() {
        return new ArrayList<>(carros);
    }

    @Override
    public int tamanho() {
        return carros.size();
    }

    public void imprimirLista() {
        System.out.println("Lista de Carros:");
        for (Carro carro : carros) {
            System.out.println(carro);
        }
    }
}
