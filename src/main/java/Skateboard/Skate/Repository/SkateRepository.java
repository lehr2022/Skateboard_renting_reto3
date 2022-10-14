
package Skateboard.Skate.Repository;

import Skateboard.Skate.Repository.SkateCrudRepository;
import Skateboard.Skate.Model.Skateboard;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SkateRepository {
    
    @Autowired
    private SkateCrudRepository skateCrudRepository;
    
    public List<Skateboard> getAll(){
        return(List<Skateboard>) skateCrudRepository.findAll();
    }
    
    public Optional<Skateboard> getSkateboard(int id){
        return skateCrudRepository.findById(id);
    }
    
    public Skateboard save (Skateboard skate){
        return skateCrudRepository.save(skate);
    }
        
    public void delete(Skateboard skate){
        skateCrudRepository.delete(skate);
    }
    
}
