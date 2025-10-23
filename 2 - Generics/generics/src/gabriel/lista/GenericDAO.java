package gabriel.lista;

import java.util.List;

public interface GenericDAO<T> {
    void adicionar(T item);
    void remover(T item);
    T buscarPorIndice(int index);
    List<T> listarTodos();
    int tamanho();
}
