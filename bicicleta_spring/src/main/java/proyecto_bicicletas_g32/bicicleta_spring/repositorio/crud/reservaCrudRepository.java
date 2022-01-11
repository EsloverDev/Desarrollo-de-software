package proyecto_bicicletas_g32.bicicleta_spring.repositorio.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import proyecto_bicicletas_g32.bicicleta_spring.modelo.Reservas;

public interface reservaCrudRepository extends CrudRepository<Reservas, Integer>
{
    public List<Reservas> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservas> findAllByStatus(String status);
}