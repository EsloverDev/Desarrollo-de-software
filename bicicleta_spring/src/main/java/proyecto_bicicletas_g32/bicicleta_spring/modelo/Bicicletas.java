package proyecto_bicicletas_g32.bicicleta_spring.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "bike")
public class Bicicletas implements Serializable
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("bikes")
    private Categorias category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "bike")
    @JsonIgnoreProperties({"bike", "client"})
    public List<mensajes> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "bike")
    @JsonIgnoreProperties({"bike", "client"})
    public List<Reservas> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categorias getCategory() {
        return category;
    }

    public void setCategory(Categorias category) {
        this.category = category;
    }

    public List<mensajes> getMessages() {
        return messages;
    }

    public void setMessages(List<mensajes> messages) {
        this.messages = messages;
    }

    public List<Reservas> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservas> reservations) {
        this.reservations = reservations;
    }

}
