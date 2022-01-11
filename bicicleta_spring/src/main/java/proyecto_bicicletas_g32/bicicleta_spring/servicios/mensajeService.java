package proyecto_bicicletas_g32.bicicleta_spring.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto_bicicletas_g32.bicicleta_spring.modelo.mensajes;
import proyecto_bicicletas_g32.bicicleta_spring.repositorio.mensajeRepository;

@Service
public class mensajeService
{
    @Autowired
    private mensajeRepository mensajeRepository;

    public List<mensajes> getAll()
        {
            return mensajeRepository.getAll();
        }

    public Optional<mensajes> getMensaje(int id)
        {
            return mensajeRepository.getMensaje(id);
        }

    public mensajes save(mensajes m)
        {
            if(m.getIdMessage()==null)
                {
                    return mensajeRepository.save(m);
                }
            else
                {
                    Optional<mensajes> mAux =mensajeRepository.getMensaje(m.getIdMessage());
                    if(mAux.isEmpty())
                        {
                            return mensajeRepository.save(m);
                        }
                    else
                        {
                            return m;
                        }
                }
        }

    public mensajes update(mensajes message)
        {
            if(message.getIdMessage()!=null)
                {
                    Optional<mensajes> mensa = mensajeRepository.getMensaje(message.getIdMessage());
                    if(!mensa.isEmpty())
                        {
                            if(message.getMessageText()!=null)
                                {
                                    mensa.get().setMessageText(message.getMessageText());
                                }
                            mensajeRepository.save(mensa.get());
                            return mensa.get();
                        }
                    else
                        {
                            return message;
                        }
                }
            else
                {
                    return message;
                }
        }

    public boolean deleteMessage(int messageId)
        {
            boolean mBoolean = getMensaje(messageId).map(message ->{
                mensajeRepository.delete(message);
                return true;
            }).orElse(false);
            return mBoolean;
        }
}
