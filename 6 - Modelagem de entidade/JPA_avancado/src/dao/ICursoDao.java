package dao;


import domain.Curso;

import java.util.Collection;

public interface ICursoDao {

    public Curso cadastrar(Curso curso);

    void excluir(Long id);

    Curso buscarPorID(Long id);

    Collection<Curso> buscarTodos();

    void alterar(Curso cursoBuscado);
}
