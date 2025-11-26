/**
 * @author Gabri
 */

package br.com.clark;

import dao.*;
import domain.Aluno;
import domain.Computador;
import domain.Curso;
import domain.Matricula;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MatriculaTest {

    private IMatricula matriculaDao;
    private ICursoDao cursoDao;
    private IAlunoDao alunoDao;
    private IComputadorDao computadorDao;

    public MatriculaTest(){
        matriculaDao = new MatriculaDao();
        cursoDao = new CursoDao();
        alunoDao = new AlunoDao();
        computadorDao = new ComputadorDao();
    }

    @Test
    public void cadastrar(){
        Curso curso = criarCurso("A1");
        Aluno aluno = criarAluno("A1");

        Matricula matricula = new Matricula();
        matricula.setCodigo("A1");
        matricula.setDataMatricula(Instant.now());
        matricula.setStatus("ATIVA");
        matricula.setValor(2000d);
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
        aluno.setMatricula(matricula);
        matricula = matriculaDao.cadastrar(matricula);

     /*   Matricula matricula2 = new Matricula();
        matricula2.setCodigo("A2");
        matricula2.setDataMatricula(Instant.now());
        matricula2.setStatus("RESCINDIDA");
        matricula2.setValor(1500d);
        matricula2.setCurso(curso);
        matricula2 = matriculaDao.cadastrar(matricula2);*/

        assertNotNull(matricula);
        assertNotNull(matricula.getId());

       /* assertNotNull(matricula2);
        assertNotNull(matricula2.getId());*/
    }

    private Curso criarCurso(String codigo){
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setNome("Curso novo no intellij");
        curso.setDescricao("Indo pelo novo projeto");
        return cursoDao.cadastrar(curso);
    }

    private Aluno criarAluno(String codigo){
        Computador computador = criarComputador("A1");
        Computador computador2 = criarComputador("A2");
        Aluno aluno = new Aluno();
        aluno.setNome("Jhow");
        aluno.setCodigo(codigo);
        aluno.add(computador);
        aluno.add(computador2);
        return alunoDao.cadastrar(aluno);
    }

    private Computador criarComputador(String codigo){
        Computador computador = new Computador();
        computador.setDescricao("Computador 01");
        computador.setCodigo(codigo);
        return computador;
    }
}
