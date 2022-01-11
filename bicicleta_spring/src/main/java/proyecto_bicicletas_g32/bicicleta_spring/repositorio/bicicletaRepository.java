package proyecto_bicicletas_g32.bicicleta_spring.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import proyecto_bicicletas_g32.bicicleta_spring.modelo.Bicicletas;
import proyecto_bicicletas_g32.bicicleta_spring.repositorio.crud.bicicletaCrudRepository;

@Repository
public class bicicletaRepository
{
    @Autowired
    private bicicletaCrudRepository bicicletaCrudRepository;

    public List<Bicicletas> getAll()
        {
            return (List<Bicicletas>)bicicletaCrudRepository.findAll();
        }

    public Optional<Bicicletas> getBicicleta(int id)
        {
            return bicicletaCrudRepository.findById(id);
        }

    public Bicicletas save(Bicicletas b)
        {
            return bicicletaCrudRepository.save(b);
        }

    public void delete(Bicicletas b)
    {
        bicicletaCrudRepository.delete(b);
    }
}
