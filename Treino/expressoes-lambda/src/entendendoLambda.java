import java.util.function.IntBinaryOperator;

public class entendendoLambda {
    static void main(String[] args) {
       IntBinaryOperator continha = (int a, int b) -> {
            return a + b;
        };



        System.out.println(continha.applyAsInt(5, 8));
    }
}
