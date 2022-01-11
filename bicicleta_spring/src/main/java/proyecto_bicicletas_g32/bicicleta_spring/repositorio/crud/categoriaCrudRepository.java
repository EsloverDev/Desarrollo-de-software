package proyecto_bicicletas_g32.bicicleta_spring.repositorio.crud;

import org.springframework.data.repository.CrudRepository;
import proyecto_bicicletas_g32.bicicleta_spring.modelo.Categorias;

public interface categoriaCrudRepository extends CrudRepository<Categorias, Integer>
{
    
}
