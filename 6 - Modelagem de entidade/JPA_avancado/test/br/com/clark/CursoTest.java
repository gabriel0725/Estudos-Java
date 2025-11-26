/**
 * @author Gabri
 */

package br.com.clark;

import dao.CursoDao;
import dao.ICursoDao;
import domain.Curso;
import org.junit.After;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class CursoTest {

    private ICursoDao cursoDao;

    public CursoTest() {
        cursoDao = new CursoDao();
    }

//    @After
//    public void fim(){
//        Collection<Curso> lista = cursoDao.buscarTodos();
//        lista.forEach(curso -> cursoDao.excluir(curso.getId()));
//    }

    @Test
    public void cadastrar2() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setNome("Curso novo no intellij");
        curso.setDescricao("Indo pelo novo projeto");
        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());
    }


    @Test
    public void cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setNome("Curso novo no intellij");
        curso.setDescricao("Indo pelo novo projeto");
        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());

        cursoDao.excluir(curso.getId());

        Curso cursoBuscado = cursoDao.buscarPorID(curso.getId());
        assertNull(cursoBuscado);
    }

    @Test
    public void buscarTodos() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setNome("Curso novo no intellij");
        curso.setDescricao("Indo pelo novo projeto");
        curso = cursoDao.cadastrar(curso);

        Curso curso2 = new Curso();
        curso2.setCodigo("B2");
        curso2.setNome("Novo curso");
        curso2.setDescricao("Curso novo para o buscar todos");
        curso2 = cursoDao.cadastrar(curso2);

        assertNotNull(curso);
        assertNotNull(curso.getId());

        assertNotNull(curso2);
        assertNotNull(curso2.getId());

        Collection<Curso> lista = cursoDao.buscarTodos();
        assertTrue(lista != null);
        assertTrue(lista.size() == 2);
    }

    @Test
    public void alterar(){
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setNome("Curso novo no intellij");
        curso.setDescricao("Indo pelo novo projeto");
        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());

        Curso cursoBuscado = cursoDao.buscarPorID(curso.getId());
        assertNotNull(cursoBuscado);

        cursoBuscado.setNome("Curso alterado");
        cursoDao.alterar(cursoBuscado);

        Curso cursoAlterado = cursoDao.buscarPorID(cursoBuscado.getId());
        assertNotNull(cursoAlterado);
        assertEquals("Curso alterado", cursoAlterado.getNome());
    }
}
