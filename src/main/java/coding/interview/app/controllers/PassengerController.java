package coding.interview.app.controllers;

import coding.interview.app.dto.PassengerDTO;
import coding.interview.app.entities.Flight;
import coding.interview.app.entities.Passenger;
import coding.interview.app.requests.UpdateFlightRequest;
import coding.interview.app.services.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService){
        this.passengerService = passengerService;
    }

    @PostMapping("/passenger")
    public ResponseEntity<Passenger> createPassenger(@RequestBody PassengerDTO passengerDTO) {
        return ResponseEntity.ok( passengerService.createPassenger(passengerDTO));
    }


    @GetMapping("/passengers")
    public ResponseEntity<List<Passenger>> getPassengers(@RequestBody PassengerDTO passengerDTO) {
        return ResponseEntity.ok( passengerService.getPassengers());
    }
}
