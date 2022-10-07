
package Skateboard.Skate.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"messages","reservations"}) 
    //@JsonIgnoreProperties({"messages"})
    public Skateboard skate;


    @ManyToOne
    @JoinColumn(name="idClient")
    //@JsonIgnoreProperties({"messages"})
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public Client getClient() {
        return client;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Skateboard getSkate() {
        return skate;
    }

    public void setSkate(Skateboard skate) {
        this.skate = skate;
    }

    
    
    
}
