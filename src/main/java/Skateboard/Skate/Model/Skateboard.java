
package Skateboard.Skate.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "skate")

public class Skateboard implements Serializable{

       
       
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    @Column(name="years")
    private Integer year;
    private String name;
    private String description;

    
    @ManyToOne
    @JoinColumn(name ="category")
    @JsonIgnoreProperties("skate")
    
    private Category category;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="skate")
    @JsonIgnoreProperties("skate")
    public List<Message>messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="skate")
    @JsonIgnoreProperties("skate")
    public List<Reservation> reservations;
    
    

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Integer getYear() {
        return year;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
    
            

    
    
}
