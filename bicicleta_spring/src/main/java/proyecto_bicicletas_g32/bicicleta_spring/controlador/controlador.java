package proyecto_bicicletas_g32.bicicleta_spring.controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import proyecto_bicicletas_g32.bicicleta_spring.modelo.Bicicletas;
import proyecto_bicicletas_g32.bicicleta_spring.servicios.bicicletaService;

@RestController
@RequestMapping(path = "/api/Bike")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controlador
{
    @Autowired
    private bicicletaService bicicletaService;

    @GetMapping("/all")
    public List<Bicicletas> getBicicletas()
        {
            return bicicletaService.getAll();
        }

    @GetMapping("/{id}")
    public Optional<Bicicletas> getBicicleta(@PathVariable("id") int id)
        {
            return bicicletaService.getBicicleta(id);
        }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bicicletas save(@RequestBody Bicicletas b)
        {
            return bicicletaService.save(b);
        }

    @PutMapping(path = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bicicletas update(@RequestBody Bicicletas bike)
        {
            return bicicletaService.update(bike);
        }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int bikeId)
        {
            return bicicletaService.deleteBike(bikeId);
        }
}