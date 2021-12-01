package cl.desafiolatam.empresaLogistiqal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.desafiolatam.empresaLogistiqal.model.Producto;
import cl.desafiolatam.empresaLogistiqal.repository.IProductoRepository;

@SpringBootApplication
public class EmpresaLogistiqalApplication {

	private static final Logger log = LoggerFactory.getLogger(EmpresaLogistiqalApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(EmpresaLogistiqalApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(IProductoRepository repo) {
		return (args) -> {
			repo.save(new Producto(111, "Paleta de Rubores", 21990, 5));
			repo.save(new Producto(222, "Delineador negro", 15990, 9));
			log.info("Lista de producto");
			for (Producto producto : repo.findAll()) {
				log.info(producto.toString());
			}
		};
	}

}
