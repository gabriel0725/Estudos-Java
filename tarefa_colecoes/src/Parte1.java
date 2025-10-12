import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Gabri
 */

public class Parte1 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Digite os nomes separados por virgula ',':");
        String entrada = s.nextLine();

        String[] nomes = entrada.split(",");

        for (int i = 0; i < nomes.length; i++) {
            nomes[i] = nomes[i].trim();
        }

        Arrays.sort(nomes);

        System.out.println("Nomes ordenados:");

        for(String nome : nomes) {
            System.out.println(nome);
        }
    }
}
