
package Skateboard.Skate.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
    private String name;
    private String brand;
    private Integer years;
    private String description;

    public Integer getYears() {
        return years;
    }

    public String getDescription() {
        return description;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    public Integer getYear() {
        return years;
    }

    public void setYear(Integer year) {
        this.years = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

 

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

   

    public void setName(String name) {
        this.name = name;
    }

 
    
    @ManyToOne
    @JoinColumn(name ="category")
    @JsonIgnoreProperties("skate")
    
    private Category category;
    
            

    
    
}
