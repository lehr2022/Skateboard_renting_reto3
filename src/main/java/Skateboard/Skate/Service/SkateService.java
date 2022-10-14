
package Skateboard.Skate.Service;

import Skateboard.Skate.Model.Skateboard;
import Skateboard.Skate.Repository.SkateCrudRepository;
import Skateboard.Skate.Repository.SkateRepository;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkateService {
    
    @Autowired
     private SkateRepository skateRepository;
    
    public List<Skateboard> getAll(){
        return skateRepository.getAll();
    }
    
    
      public Optional<Skateboard> getSkateboard(int id) {
        return skateRepository.getSkateboard(id);
    }

    
  
    
    public Skateboard save(Skateboard skate){
        if(skate.getId()==null){
           return skateRepository.save(skate); 
        }else{
            Optional<Skateboard> opt = skateRepository.getSkateboard(skate.getId());
            if(opt.isPresent()){
                return skateRepository.save(skate);
            }else{
                return skate;
            }
        }    
    }
    
     public Skateboard update(Skateboard skate){
        if(skate.getId()!=null){
            Optional<Skateboard> opt = skateRepository.getSkateboard(skate.getId());
            if(!opt.isPresent()){
                if(skate.getName()!=null){
                    opt.get().setName(skate.getName());
                }
                if(skate.getBrand()!=null){
                    opt.get().setBrand(skate.getBrand());
                }
                if(skate.getYear()!=null){
                    opt.get().setYear(skate.getYear());
                }
                if(skate.getDescription()!=null){                    
                    opt.get().setDescription(skate.getDescription());
                }
                if(skate.getCategory()!=null){                    
                   opt.get().setCategory(skate.getCategory());
                }
                skateRepository.save(opt.get());
                return opt.get();
            }else{
                return skate;
            }
        }else{
           return skate;
     }
 }
        
    
    
    
    public boolean deleteSkateboard(int id) {
       
        Optional<Skateboard> c= skateRepository.getSkateboard(id);
        if(c.isPresent()){
            skateRepository.delete(c.get());
            return true;
        }
        return false;
    }

}

