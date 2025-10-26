/**
 * @author Gabri
 */

package gabriel;

import gabriel.anotation.Tabela;
import gabriel.usuario.Usuario;

public class App {
    public static void main(String[] args) {
        // Verificando a anotação na classe Usuario
        Class<?> classe = Usuario.class;

        // Verificando se a classe está anotada com @Tabela
        if (classe.isAnnotationPresent(Tabela.class)) {
            // Pegando a anotação
            Tabela tabela = classe.getAnnotation(Tabela.class);
            // Imprimindo o nome da tabela
            System.out.println("A tabela da classe " + classe.getSimpleName() + " é: " + tabela.nome());
        } else {
            System.out.println("A classe " + classe.getSimpleName() + " não possui a anotação @Tabela.");
        }
    }
}
