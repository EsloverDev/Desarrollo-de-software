package proyecto_bicicletas_g32.bicicleta_spring.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto_bicicletas_g32.bicicleta_spring.modelo.Clientes;
import proyecto_bicicletas_g32.bicicleta_spring.repositorio.clienteRepository;

@Service
public class clienteService
{
    @Autowired
    private clienteRepository clienteRepository;

    public List<Clientes> getAll()
        {
            return clienteRepository.getAll();
        }

    public Optional<Clientes> getCliente(int id)
        {
            return clienteRepository.getCliente(id);
        }

    public Clientes save(Clientes c)
        {
            if (c.getIdClient()==null)
                {
                    return clienteRepository.save(c);
                }
            else
                {
                    Optional<Clientes> cAux = clienteRepository.getCliente(c.getIdClient());
                    if(cAux.isEmpty())
                        {
                            return clienteRepository.save(c);
                        }
                    else
                        {
                            return c;
                        }
                }
        }
    
    public Clientes update(Clientes client)
        {
            if(client.getIdClient()!=null)
                {
                    Optional<Clientes> cl = clienteRepository.getCliente(client.getIdClient());
                    if(!cl.isEmpty())
                        {
                            if(client.getName()!=null)
                                {
                                    cl.get().setName(client.getName());
                                }
                            if(client.getEmail()!=null)
                                {
                                    cl.get().setEmail(client.getEmail());
                                }
                            if(client.getAge()!=null)
                                {
                                    cl.get().setAge(client.getAge());
                                }
                            if(client.getPassword()!=null)
                                {
                                    cl.get().setPassword(client.getPassword());
                                }
                            clienteRepository.save(cl.get());
                            return cl.get();
                        }
                    else
                        {
                            return client;
                        }
                }
            else
                {
                    return client;
                }
        }

    public boolean deleteClient(int ClientId)
        {
            boolean cBoolean = getCliente(ClientId).map(client -> {
                clienteRepository.delete(client);
                return true;
            }).orElse(false);
            return cBoolean;
        }
}
