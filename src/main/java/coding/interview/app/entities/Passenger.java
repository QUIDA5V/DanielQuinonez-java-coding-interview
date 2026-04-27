package coding.interview.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.List;

@Entity
public class Passenger {
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    List<Flight> flights;

    public Passenger(String name, List<Flight> flights){
        this.name = name;
        this.flights = flights;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
