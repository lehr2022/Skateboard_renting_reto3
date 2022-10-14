
package Skateboard.Skate.Service;

import Skateboard.Skate.Model.Reservation;
import Skateboard.Skate.Repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservation1 = reservationRepository.getReservation(reservation.getIdReservation());
            if (reservation1.isPresent()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation>g= reservationRepository.getReservation(reservation.getIdReservation());
            if(g.isPresent()){
                if(reservation.getStartDate()!=null){
                    g.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){                    
                    g.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                return reservationRepository.save(g.get());
            }
        }
        return reservation;
    }
    
    
    public boolean deleteReservation(int id) {
       
        Optional<Reservation> c= reservationRepository.getReservation(id);
        if(c.isPresent()){
            reservationRepository.delete(c.get());
            return true;
        }
        return false;
    }

    
    
    
    
}
