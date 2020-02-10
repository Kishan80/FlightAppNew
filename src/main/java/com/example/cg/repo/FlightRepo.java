package com.example.cg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.cg.entity.Flight;

public interface FlightRepo extends CrudRepository<Flight, Integer> {

	@Query("FROM Flight WHERE carrier = :carr")
	public List<Flight> findByCarrier(@Param("carr") String carr);

	@Query("FROM Flight WHERE source = :sor")
	public List<Flight> findBySource(@Param("sor") String sor);

	@Query("FROM Flight WHERE destination = :dest")
	public List<Flight> findByDestination(@Param("dest") String dest);

	@Query("FROM Flight WHERE price = :prce")
	public List<Flight> findByPrice(@Param("prce") int dest);

}
