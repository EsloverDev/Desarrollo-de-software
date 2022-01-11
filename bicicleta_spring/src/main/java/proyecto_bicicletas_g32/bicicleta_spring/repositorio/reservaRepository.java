package proyecto_bicicletas_g32.bicicleta_spring.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import proyecto_bicicletas_g32.bicicleta_spring.modelo.Reservas;
import proyecto_bicicletas_g32.bicicleta_spring.repositorio.crud.reservaCrudRepository;

@Repository
public class reservaRepository
{
    @Autowired
    private reservaCrudRepository reservaCrudRepository;

    public List<Reservas> getAll()
        {
            return (List<Reservas>) reservaCrudRepository.findAll();
        }

    public Optional<Reservas> getReserva(int id)
        {
            return reservaCrudRepository.findById(id);
        }

    public Reservas save(Reservas r)
        {
            return reservaCrudRepository.save(r);
        }
    
    public void delete(Reservas reserva)
        {
            reservaCrudRepository.delete(reserva);
        }
}