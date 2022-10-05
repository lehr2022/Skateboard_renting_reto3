
package Skateboard.Skate.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String name;
    private String email;
    private Integer password;
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    //@OneToMany(mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Message>messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    //@OneToMany(mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Reservation> reservations;

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
    
    
    
    
    
}