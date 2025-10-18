/**
 * @author Gabri
 */

package gabriel.dev.comidas;

public class Hamburger implements Comida{

    @Override
    public void removeIngrediente(String nome) {
        System.out.println("Ingrediente %s removido do hamburger".formatted(nome));
    }
}
