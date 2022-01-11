package proyecto_bicicletas_g32.bicicleta_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"proyecto_bicicletas_g32.bicicleta_spring.modelo"})
@SpringBootApplication
public class BicicletaSpringApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(BicicletaSpringApplication.class, args);
	}

}
