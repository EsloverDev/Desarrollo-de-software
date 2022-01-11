package proyecto_bicicletas_g32.bicicleta_spring.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto_bicicletas_g32.bicicleta_spring.modelo.Reservas;
import proyecto_bicicletas_g32.bicicleta_spring.repositorio.reservaRepository;

@Service
public class reservaService
{
    @Autowired
    private reservaRepository reservaRepository;

    public List<Reservas> getAll()
        {
            return reservaRepository.getAll();
        }

    public Optional<Reservas> getReserva(int id)
        {
            return reservaRepository.getReserva(id);
        }

    public Reservas save(Reservas r)
        {
            if(r.getIdReservation()==null)
                {
                    return reservaRepository.save(r);
                }
            else
                {
                    Optional<Reservas> rAux = reservaRepository.getReserva(r.getIdReservation());
                    if(rAux.isEmpty())
                        {
                            return reservaRepository.save(r);
                        }
                    else
                        {
                            return r;
                        }
                }
        }

    public Reservas update(Reservas reservation)
        {
            if(reservation.getIdReservation()!=null)
                {
                    Optional<Reservas> res = reservaRepository.getReserva(reservation.getIdReservation());
                    if(!res.isEmpty())
                        {
                            if(reservation.getStartDate()!=null)
                                {
                                    res.get().setStartDate(reservation.getStartDate());
                                }
                            if(reservation.getDevolutionDate()!=null)
                                {
                                    res.get().setDevolutionDate(reservation.getDevolutionDate());
                                }
                            if(reservation.getStatus()!=null)
                                {
                                    res.get().setStatus(reservation.getStatus());
                                }
                            reservaRepository.save(res.get());
                            return res.get();
                        }
                    else
                        {
                            return reservation;
                        }
                }
            else
                {
                    return reservation;
                }
        }

    public boolean deleteReservation(int resId)
        {
            boolean rBoolean = getReserva(resId).map(reserva -> {
                reservaRepository.delete(reserva);
                return true;
            }).orElse(false);
            return rBoolean;
        }
}
