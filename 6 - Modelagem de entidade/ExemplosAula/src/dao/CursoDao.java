/**
 * @author Gabri
 */

package dao;


import domain.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

public class CursoDao implements ICursoDao{

    @Override
    public Curso cadastrar(Curso curso) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return curso;
    }

    @Override
    public void excluir(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Curso curso = entityManager.find(Curso.class, id);

        if (curso != null) {
            entityManager.remove(curso);
        }

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public Curso buscarPorID(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Curso curso = entityManager.find(Curso.class, id);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return curso;
    }

    @Override
    public Collection<Curso> buscarTodos() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Collection<Curso> listaCursos = entityManager.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return listaCursos;
    }

    @Override
    public void alterar(Curso cursoBuscado) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(cursoBuscado);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }


}
