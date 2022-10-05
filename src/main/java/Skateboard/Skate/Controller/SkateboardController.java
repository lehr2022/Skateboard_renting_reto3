
package Skateboard.Skate.Controller;


import Skateboard.Skate.Model.Skateboard;
import Skateboard.Skate.Service.SkateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class SkateboardController {
    @Autowired
    private SkateService skateService;
    
    @GetMapping("/all")
    public List<Skateboard> getSkateboard(){
        return skateService.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skateboard save (@RequestBody Skateboard skate){
        return skateService.save(skate);
    }
    
}

