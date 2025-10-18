/**
 * @author Gabri
 */

package gabriel.dev.comidas;

public class Pizza implements Comida{
    @Override
    public void removeIngrediente(String nome) {
        System.out.println("Ingrediente " + nome + "removido da pizza");
    }
}
