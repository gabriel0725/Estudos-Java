package br.com.clark.SpringBootPrimeiroExemplo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import br.com.clark.domain.Cliente;
import br.com.clark.repository.IClienteRepository;

@SpringBootApplication
public class SpringBootPrimeiroExemploApplication implements CommandLineRunner {

		private static final Logger log = LoggerFactory.getLogger(SpringBootPrimeiroExemploApplication.class);
		
		@Autowired
		private IClienteRepository repository;
		

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
					.email("Teste@testeeeee.com")
					.end("End")
					.estado("SP")
					.nome("Teste Spring Boot")
					.numero(102030)
					.tel(10203040L)
					.build();
		}
	

}
