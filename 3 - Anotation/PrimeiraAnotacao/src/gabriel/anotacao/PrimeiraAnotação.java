package gabriel.anotacao;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})

public @interface PrimeiraAnotação {

    String value();

    String[] bairros();

    long numeroCasa();

    double valores() default 10d;
}
