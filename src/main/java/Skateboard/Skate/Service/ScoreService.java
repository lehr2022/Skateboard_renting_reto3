
package Skateboard.Skate.Service;

import Skateboard.Skate.Model.Score;
import Skateboard.Skate.Repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    
     public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getReservation(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score score) {
        if (score.getIdScore()== null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> score1 = scoreRepository.getScore(score.getIdScore());
            if (score1.isPresent()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }
    
    
     public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score>g= scoreRepository.getScore(score.getIdScore());
            if(!g.isPresent()){
                if(score.getMessageText()!=null){
                    g.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){                    
                    g.get().setStars(score.getStars());
                }
                return scoreRepository.save(g.get());
            }
        }
        return score;
    }
    
    
    public boolean deleteScore(int id) {
       
        Optional<Score> c= scoreRepository.getScore(id);
        if(c.isPresent()){
            scoreRepository.delete(c.get());
            return true;
        }
        return false;
    }

}
