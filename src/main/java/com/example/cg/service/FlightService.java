package com.example.cg.service;

import java.util.List;

import com.example.cg.entity.Flight;
import com.example.cg.util.InvalidFlightException;



public interface FlightService {
	
int addFlight(Flight flight);
	
	List<Flight> getAll();

	Flight getByFlightNo(int no) throws InvalidFlightException;

	boolean removeFlight(int no) throws InvalidFlightException;
	
	void updateFlight(Flight flight);

	List<Flight> findByCarrier(String carrier);
	
	List<Flight> findBySource(String source);

	List<Flight> findByDestination(String destination);
	
	List<Flight> findByPrice(int price);
}
