
package Skateboard.Skate.Service;

import Skateboard.Skate.Model.Client;
import Skateboard.Skate.Repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    
    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

   
     
    
     public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> category1 = clientRepository.getClient(client.getIdClient());
            if (category1.isPresent()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }
     
     
     public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client>g= clientRepository.getClient(client.getIdClient());
            if(g.isPresent()){
                if(client.getEmail()!=null){
                    g.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){                    
                    g.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null){
                    g.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    g.get().setAge(client.getAge());
                }
                return clientRepository.save(g.get());
            }
        }
        return client;
    }
    
    
    public boolean deleteClient(int id) {
       
        Optional<Client> c= clientRepository.getClient(id);
        if(c.isPresent()){
            clientRepository.delete(c.get());
            return true;
        }
        return false;
    }
    
}
