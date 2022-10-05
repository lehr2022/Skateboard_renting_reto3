/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Skateboard.Skate.Repository;

import Skateboard.Skate.Model.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author devin
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer>{
    
}
