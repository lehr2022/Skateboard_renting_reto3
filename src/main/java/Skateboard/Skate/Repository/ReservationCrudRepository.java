/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Skateboard.Skate.Repository;

import Skateboard.Skate.Model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author devin
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer>{
    
    
    // Cantidad de reservas completatas vs canceladas
    public List<Reservation> findAllByStatus(String status);

    // Cantidad de reservas en un tiempo determinado.
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date fechaInicio, Date fechaFin);



    // Top de los clientes que más dinero le han dejado a la compañía.
    // INSTRUCCION SQL SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    
    @Query("SELECT c.client, COUNT(c.client) from Reservation  AS c  group by c.client order by COUNT(c.client)DESC ")
    public List<Object[]> reporteClientes();

}

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    
    

