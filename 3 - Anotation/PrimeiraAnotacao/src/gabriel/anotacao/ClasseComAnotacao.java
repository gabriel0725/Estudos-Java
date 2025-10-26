/**
 * @author Gabri
 */

package gabriel.anotacao;

@PrimeiraAnotação(value = "Gabriel", bairros = {"teste"}, numeroCasa = 50L)
public class ClasseComAnotacao {

    @PrimeiraAnotação(value = "Clark", bairros = {"teste2"}, numeroCasa = 6l, valores = 100d)
    private String nome;
}
