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
import proyecto_bicicletas_g32.bicicleta_spring.modelo.Reservas;
import proyecto_bicicletas_g32.bicicleta_spring.servicios.reservaService;

@RestController
@RequestMapping(path = "/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class reservaControlador
{
    @Autowired
    private reservaService reservaService;

    @GetMapping(path = "/all")
    public List<Reservas> getReservas()
        {
            return reservaService.getAll();
        }

    @GetMapping(path = "/{id}")
    public Optional<Reservas> getReserva(@PathVariable("id") int id)
        {
            return reservaService.getReserva(id);
        }

    @PostMapping(path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservas save(@RequestBody Reservas r)
        {
            return reservaService.save(r);
        }

    @PutMapping(path = "/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservas update(@RequestBody Reservas reservation)
        {
            return reservaService.update(reservation);
        }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId)
        {
            return reservaService.deleteReservation(reservationId);
        }
}