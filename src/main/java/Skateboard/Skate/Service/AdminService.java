
package Skateboard.Skate.Service;

import Skateboard.Skate.Model.Admin;
import Skateboard.Skate.Model.Category;
import Skateboard.Skate.Repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll() {
        return adminRepository.getAll();
    }
    
    
    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> admin1 = adminRepository.getAdmin(admin.getIdAdmin());
            if (admin1.equals("")) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }
}
