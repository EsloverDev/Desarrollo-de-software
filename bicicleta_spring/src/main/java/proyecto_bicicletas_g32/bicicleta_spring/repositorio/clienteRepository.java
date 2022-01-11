package proyecto_bicicletas_g32.bicicleta_spring.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import proyecto_bicicletas_g32.bicicleta_spring.modelo.Clientes;
import proyecto_bicicletas_g32.bicicleta_spring.repositorio.crud.clienteCrudRepository;

@Repository
public class clienteRepository
{
    @Autowired
    private clienteCrudRepository clienteCrudRepository;

    public List<Clientes> getAll()
        {
            return (List<Clientes>)clienteCrudRepository.findAll();
        }
    
    public Optional<Clientes> getCliente(int id)
        {
            return clienteCrudRepository.findById(id);
        }
    
    public Clientes save(Clientes c)
        {
            return clienteCrudRepository.save(c);
        }

    public void delete(Clientes cliente)
        {
            clienteCrudRepository.delete(cliente);
        }
}
