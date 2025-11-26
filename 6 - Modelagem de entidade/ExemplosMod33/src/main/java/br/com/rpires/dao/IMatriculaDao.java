/**
 * 
 */
package br.com.rpires.dao;

import br.com.rpires.domain.Curso;
import br.com.rpires.domain.Matricula;
import java.util.List;

/**
 * @author rodrigo.pires
 *
 */
public interface IMatriculaDao {

	Matricula cadastrar(Matricula mat);
	
	Matricula buscarPorCodigoCurso(String codigoCurso);
	
	Matricula buscarPorCurso(Curso curso);
	
	Matricula buscarPorCodigoCursoCriteria(String codigoCurso);
	
	Matricula buscarPorCursoCriteria(Curso curso);

    //List<Matricula> buscarTodos();
}
