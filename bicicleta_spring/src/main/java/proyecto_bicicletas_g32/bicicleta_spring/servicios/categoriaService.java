package proyecto_bicicletas_g32.bicicleta_spring.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto_bicicletas_g32.bicicleta_spring.modelo.Categorias;
import proyecto_bicicletas_g32.bicicleta_spring.repositorio.categoriaRepository;

@Service
public class categoriaService
{
    @Autowired
    private categoriaRepository categoriaRepository;

    public List<Categorias> getAll()
        {
            return categoriaRepository.getAll();
        }

    public Optional<Categorias> getCategoria(int id)
        {
            return categoriaRepository.getCategoria(id);
        }

    public Categorias save(Categorias c)
        {
            if(c.getId()==null)
                {
                    return categoriaRepository.save(c);
                }
            else
                {
                    Optional<Categorias> cAux = categoriaRepository.getCategoria(c.getId());
                    if(cAux.isEmpty())
                        {
                            return categoriaRepository.save(c);
                        }
                    else
                        {
                            return c;
                        }
                }
        }
    
    public Categorias update(Categorias category)
        {
            if(category.getId()!=null)
                {
                    Optional<Categorias> c=categoriaRepository.getCategoria(category.getId());
                    if(!c.isEmpty())
                        {
                            if(category.getName()!=null)
                                {
                                    c.get().setName(category.getName());
                                }
                            if(category.getDescription()!=null)
                                {
                                    c.get().setDescription(category.getDescription());
                                }
                            categoriaRepository.save(c.get());
                            return c.get();
                        }
                    else
                        {
                            return category;
                        }
                }
            else
                {
                    return category;
                }
        }

    public boolean deleteCategory(int categoryId)
        {
            boolean cate = getCategoria(categoryId).map(categorias -> {
                categoriaRepository.delete(categorias);
                return true;
            }).orElse(false);
            return cate;
        }
}
