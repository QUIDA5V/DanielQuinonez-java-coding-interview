package coding.interview.app.services;

import coding.interview.app.dto.PassengerDTO;
import coding.interview.app.entities.Passenger;
import coding.interview.app.repositories.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    private PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }

    public Passenger createPassenger(PassengerDTO passengerDTO){
        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getFlights());

        return passengerRepository.save(passenger);
    }

    public List<Passenger> getPassengers(){
        return passengerRepository.findAll();
    }
}
