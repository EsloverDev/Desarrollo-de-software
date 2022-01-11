package proyecto_bicicletas_g32.bicicleta_spring.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto_bicicletas_g32.bicicleta_spring.modelo.Bicicletas;
import proyecto_bicicletas_g32.bicicleta_spring.repositorio.bicicletaRepository;

@Service
public class bicicletaService
{
    @Autowired
    private bicicletaRepository bicicletaRepository;

    public List<Bicicletas> getAll()
        {
            return bicicletaRepository.getAll();
        }

    public Optional<Bicicletas> getBicicleta(int id)
        {
            return bicicletaRepository.getBicicleta(id);
        }

    public Bicicletas save(Bicicletas b)
        {
            if (b.getId()==null)
                {
                    return bicicletaRepository.save(b);
                }
            else
                {
                    Optional<Bicicletas> bAux = bicicletaRepository.getBicicleta(b.getId());
                    if (bAux.isEmpty())
                        {
                            return bicicletaRepository.save(b);
                        }
                    else
                        {
                            return b;
                        }
                }
        }

    public Bicicletas update(Bicicletas bike)
        {
            if(bike.getId()!=null)
                {
                    Optional<Bicicletas> e=bicicletaRepository.getBicicleta(bike.getId());
                    if(!e.isEmpty())
                        {
                            if(bike.getName()!=null)
                                {
                                    e.get().setName(bike.getName());
                                }
                            if(bike.getBrand()!=null)
                                {
                                    e.get().setBrand(bike.getBrand());
                                }
                            if(bike.getYear()!=null)
                                {
                                    e.get().setYear(bike.getYear());
                                }
                            if(bike.getDescription()!=null)
                                {
                                    e.get().setDescription(bike.getDescription());
                                }
                            bicicletaRepository.save(e.get());
                            return e.get();
                        }
                    else
                        {
                            return bike;
                        }
                }
            else
                {
                    return bike;
                }
        }
    
    public boolean deleteBike(int bikeId)
        {
            boolean aboolean = getBicicleta(bikeId).map(bicicleta -> {
                bicicletaRepository.delete(bicicleta);
                return true;
            }).orElse(false);
            return aboolean;
        }
}