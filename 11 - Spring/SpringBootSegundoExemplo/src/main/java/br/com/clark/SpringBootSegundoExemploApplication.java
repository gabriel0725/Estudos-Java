package br.com.clark;

import br.com.clark.domain.Cliente;
import br.com.clark.repository.IClienteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class SpringBootSegundoExemploApplication implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(SpringBootSegundoExemploApplication.class);

    @Autowired
    private IClienteRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSegundoExemploApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("StartApplication...");
        Cliente cliente = createCliente();
        repository.save(cliente);
    }

    private Cliente createCliente() {
        return Cliente.builder()
                .cidade("SP")
                .cpf(12312312310L)
                .email("Teste@spring.com")
                .end("End")
                .estado("SP")
                .nome("Outro teste Spring Boot")
                .numero(85216)
                .tel(10203040L)
                .build();
    }
}
