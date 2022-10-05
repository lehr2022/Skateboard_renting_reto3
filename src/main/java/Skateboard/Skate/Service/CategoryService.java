
package Skateboard.Skate.Service;

import Skateboard.Skate.Model.Category;
import Skateboard.Skate.Repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> category1 = categoryRepository.getCategory(category.getId());
            if (category1.equals("")) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }
   
    
}
