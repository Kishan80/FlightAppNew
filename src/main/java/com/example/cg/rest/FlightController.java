package com.example.cg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cg.entity.Flight;
import com.example.cg.service.FlightService;
import com.example.cg.util.InvalidFlightException;

@RestController
public class FlightController {
	
	@Autowired
	private FlightService service;
	
	
	@GetMapping(value = "/getAllFlight", produces = "application/json")
	public List<Flight> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value = "/getFlight/{no}", produces = "application/json")
	public Flight get(@PathVariable int no) throws InvalidFlightException{
		return service.getByFlightNo(no);
		
	}

	@PostMapping(value = "/addFlight", consumes = "application/json")
	public String add(@RequestBody Flight flight) {
		service.addFlight(flight);
		return "Flight saved";
	}
	
	@DeleteMapping(value = "/deleteFlight/{no}")
	public String delete(@PathVariable int no) throws InvalidFlightException {
		service.removeFlight(no);
		return "Flight Deleted";
		
	}
	
	@PutMapping(value = "/updateFlight", consumes = "application/json")
	public String update(@RequestBody Flight flight) {
		service.updateFlight(flight);
		return "Flight updated";
	}
	
	@GetMapping(value="/findByCarrier",produces="application/json")
	public List<Flight> findByCarrier(@RequestParam("name") String name){
		return service.findByCarrier(name);
	}
	
	@GetMapping(value="/findBySource",produces="application/json")
	public List<Flight> findBySource(@RequestParam("name") String name){
		return service.findBySource(name);
	}
	
	@GetMapping(value="/findByDestination",produces="application/json")
	public List<Flight> findByDestination(@RequestParam("name") String name){
		return service.findByDestination(name);
	}
	
	@GetMapping(value="/findByPrice",produces="application/json")
	public List<Flight> findByPrice(@RequestParam("price") int price){
		return service.findByPrice(price);
	}
}
