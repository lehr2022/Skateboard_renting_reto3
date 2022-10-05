

package Skateboard.Skate.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class Score {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    private String messageText;
    private Integer stars;

    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

    
    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getIdScore() {
        return idScore;
    }

    public String getMessageText() {
        return messageText;
    }

    public Integer getStars() {
        return stars;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
    
    
}
