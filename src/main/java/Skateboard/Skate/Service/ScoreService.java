
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
}
