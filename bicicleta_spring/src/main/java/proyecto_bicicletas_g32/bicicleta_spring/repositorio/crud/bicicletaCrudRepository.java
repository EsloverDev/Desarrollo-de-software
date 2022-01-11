package proyecto_bicicletas_g32.bicicleta_spring.repositorio.crud;

import org.springframework.data.repository.CrudRepository;
import proyecto_bicicletas_g32.bicicleta_spring.modelo.Bicicletas;

public interface bicicletaCrudRepository extends CrudRepository<Bicicletas, Integer>
{
    
}
