
package Skateboard.Skate.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    
    @ManyToOne
    @JoinColumn(name ="message")
    @JsonIgnoreProperties("skate")
    private Message messages;
    
    @ManyToOne
    @JoinColumn(name ="reservation")
    @JsonIgnoreProperties("skate")
    private Reservation reservations;

    public void setMessages(Message messages) {
        this.messages = messages;
    }

    public void setReservations(Reservation reservations) {
        this.reservations = reservations;
    }
    
    
    

    public Message getMessages() {
        return messages;
    }

    public Reservation getReservations() {
        return reservations;
    }
    
    
    

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getYear() {
        return year;
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
