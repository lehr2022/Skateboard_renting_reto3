
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
            if (category1.isPresent()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }
   
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g= categoryRepository.getCategory(category.getId());
            if(g.isPresent()){
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                if(category.getDescription()!=null){                    
                    g.get().setDescription(category.getDescription());
                }
                return categoryRepository.save(g.get());
            }
        }
        return category;
    }
    
    
    public boolean deleteCategory(int id) {
       
        Optional<Category> c= categoryRepository.getCategory(id);
        if(c.isPresent()){
            categoryRepository.delete(c.get());
            return true;
        }
        return false;
    }

    
    
    
    
    
    
    
    
    
}
