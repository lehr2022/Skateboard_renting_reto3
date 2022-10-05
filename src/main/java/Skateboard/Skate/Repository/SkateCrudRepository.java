
package Skateboard.Skate.Repository;

import Skateboard.Skate.Model.Category;
import Skateboard.Skate.Model.Skateboard;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author devin
 */
public interface SkateCrudRepository extends CrudRepository<Skateboard, Integer> {
    

    
}
