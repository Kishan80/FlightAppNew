package com.example.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cg.entity.Flight;
import com.example.cg.repo.FlightRepo;
import com.example.cg.util.InvalidFlightException;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightRepo repo;

	@Override
	public int addFlight(Flight flight) {
		repo.save(flight);
		return flight.getFlightNo();
	}

	@Override
	public List<Flight> getAll() {
		return (List)repo.findAll();
	}

	@Override
	public Flight getByFlightNo(int no) throws InvalidFlightException {
		return repo.findById(no).orElseThrow(InvalidFlightException :: new);
	}

	@Override
	public boolean removeFlight(int no) throws InvalidFlightException {
		try {
			if(repo.findById(no).get()!=null)
			 repo.deleteById(no);
			return true;
			}
			catch(Exception e) {
			throw new InvalidFlightException ("No such flight");
			}
	}

	@Override
	public void updateFlight(Flight flight) {
		repo.save(flight);

	}

	@Override
	public List<Flight> findByCarrier(String carrier) {
		return repo.findByCarrier(carrier);
	}

	@Override
	public List<Flight> findBySource(String source) {
		return repo.findBySource(source);
	}

	@Override
	public List<Flight> findByDestination(String destination) {
		return repo.findByDestination(destination);
	}

	@Override
	public List<Flight> findByPrice(int price) {
		return repo.findByPrice(price);
	}

}
