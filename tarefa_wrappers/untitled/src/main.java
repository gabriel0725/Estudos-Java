/**
 * @author Gabri
 */

package tarefa;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        // Scanner para leitura do console
        Scanner scanner = new Scanner(System.in);

        // Lendo um valor numérico inteiro do console
        System.out.println("Digite um valor numérico:");
        int numeroPrimitivo = scanner.nextInt();  // Leitura do valor como um tipo primitivo (int)

        // Convertendo o valor primitivo para o tipo wrapper (Integer)
        Integer numeroWrapper = Integer.valueOf(numeroPrimitivo);

        // Imprimindo os valores no console
        System.out.println("Valor primitivo: " + numeroPrimitivo);
        System.out.println("Valor após conversão para tipo wrapper: " + numeroWrapper);

        // Fechando o scanner
        scanner.close();
    }
}
