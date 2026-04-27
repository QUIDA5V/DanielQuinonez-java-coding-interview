package coding.interview.app.services;

import coding.interview.app.entities.Flight;
import coding.interview.app.entities.Passenger;
import coding.interview.app.repositories.FlightRepository;
import coding.interview.app.repositories.PassengerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private FlightRepository flightRepository;
    private PassengerRepository passengerRepository;

    public FlightService(FlightRepository flightRepository, PassengerRepository passengerRepository) {
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
    }

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public Optional<Flight> findById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Transactional
    public Flight deletePassengerFromFlight(Long id, Long passengerId){
        Optional<Flight> flightOptional = flightRepository.findById(id);
        Flight flight = flightOptional.get();

        List<Passenger> passengers = flight.getPassengers();
        List<Passenger> remainPassengers = passengers.stream().filter(p->p.getId() != passengerId).toList();

        flight.setPassengers(remainPassengers);

        Optional<Passenger> passengerOpt = passengerRepository.findById(passengerId);
        Passenger passenger = passengerOpt.get();
        List<Flight> flights = passenger.getFlights().stream().filter(f->f.getId() != id).toList();
        passenger.setFlights(flights);

        Flight updatedFlight = flightRepository.save(flight);
        passengerRepository.save(passenger);

        return updatedFlight;
    }
}
