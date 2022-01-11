package proyecto_bicicletas_g32.bicicleta_spring.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto_bicicletas_g32.bicicleta_spring.modelo.mensajes;
import proyecto_bicicletas_g32.bicicleta_spring.repositorio.crud.mensajeCrudRepository;

@Repository
public class mensajeRepository
{
    @Autowired
    private mensajeCrudRepository mensajeCrudRepository;

    public List<mensajes> getAll()
        {
            return (List<mensajes>)mensajeCrudRepository.findAll();
        }

    public Optional<mensajes> getMensaje(int id)
        {
            return mensajeCrudRepository.findById(id);
        }

    public mensajes save(mensajes m)
        {
            return mensajeCrudRepository.save(m);
        }

    public void delete(mensajes mensaje)
        {
            mensajeCrudRepository.delete(mensaje);
        }
}
