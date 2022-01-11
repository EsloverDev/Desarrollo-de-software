package proyecto_bicicletas_g32.bicicleta_spring.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto_bicicletas_g32.bicicleta_spring.modelo.Categorias;
import proyecto_bicicletas_g32.bicicleta_spring.repositorio.crud.categoriaCrudRepository;

@Repository
public class categoriaRepository
{
    @Autowired
    private categoriaCrudRepository categoriaCrudRepository;

    public List<Categorias> getAll()
        {
            return (List<Categorias>)categoriaCrudRepository.findAll();
        }

    public Optional<Categorias> getCategoria(int id)
        {
            return categoriaCrudRepository.findById(id);
        }

    public Categorias save(Categorias c)
        {
            return categoriaCrudRepository.save(c);
        }
    
    public void delete(Categorias categoria)
        {
            categoriaCrudRepository.delete(categoria);
        }
}
