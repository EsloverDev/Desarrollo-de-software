package proyecto_bicicletas_g32.bicicleta_spring.controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import proyecto_bicicletas_g32.bicicleta_spring.modelo.Clientes;
import proyecto_bicicletas_g32.bicicleta_spring.servicios.clienteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api/Client")
@CrossOrigin (origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class clienteControlador
{
    @Autowired
    private clienteService clienteService;
    
    @GetMapping(path = "/all")
    public List<Clientes> getClients()
        {
            return clienteService.getAll();
        }

    @GetMapping(path = "/{id}")
    public Optional<Clientes> getCliente(@PathVariable("id") int id)
        {
            return clienteService.getCliente(id);
        }

    @PostMapping(path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes save(@RequestBody Clientes c)
        {            
            return clienteService.save(c);
        }

    @PutMapping(path = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes update(@RequestBody Clientes client)
        {
            return clienteService.update(client);
        }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId)
        {
            return clienteService.deleteClient(clientId);
        }
}
