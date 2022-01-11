package proyecto_bicicletas_g32.bicicleta_spring.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "message")
public class mensajes implements Serializable
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Bicicletas bike;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Clientes client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Bicicletas getBike() {
        return bike;
    }

    public void setBike(Bicicletas bike) {
        this.bike = bike;
    }

    public Clientes getClient() {
        return client;
    }

    public void setClient(Clientes client) {
        this.client = client;
    }

}
