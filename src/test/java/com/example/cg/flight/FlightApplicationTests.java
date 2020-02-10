package com.example.cg.flight;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.cg.entity.Flight;
import com.example.cg.repo.FlightRepo;
import com.example.cg.service.FlightServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FlightApplicationTests {

//	@Test
//	public void contextLoads() {
//	}
//
	@MockBean
	private FlightRepo repo;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FlightServiceImpl flightService;

	String exampleFlight = "{\n" + "	\"carrier\":\"Indigo\",\n" + "	\"source\":\"Mumbai\",\n"
			+ "	\"destination\":\"Nagpur\",\n" + "	\"price\":500\n" + "}";

	@Test
	public void addFlight() throws Exception {
		Flight mockFlight = new Flight(1, "Indigo", "Mumbai", "Nagpur", 500);

		Mockito.when(flightService.addFlight(Mockito.any(Flight.class))).thenReturn(mockFlight.getFlightNo());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addFlight").accept(MediaType.APPLICATION_JSON)
				.content(exampleFlight).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals("Flight saved", response.getContentAsString());

//		assertEquals("http://localhost/addFlight",
//				response.getHeader(HttpHeaders.LOCATION));
	}

//	@Test
//	public void addFlightTest() throws Exception {
//		Flight mockFlight = new Flight(1, "Indigo", "Mumbai", "Nagpur", 500);
//		Mockito.when(flightService.addFlight(mockFlight)).thenReturn(mockFlight.getFlightNo());
//		assertEquals(mockFlight, flightService.addFlight(mockFlight));
//	}

	@Test
	public void getAllTest() throws Exception {
//		Flight mockFlight = new Flight(1,"Indigo","Mumbai","Nagpur",500);
//				new Flight(1,"kingfisher","Delhi","Pune",1000);
		Mockito.when(flightService.getAll())
				.thenReturn(
						(List<Flight>) Stream
								.of(new Flight(1, "Indigo", "Mumbai", "Nagpur", 500),
										new Flight(1, "kingfisher", "Delhi", "Pune", 1000))
								.collect(Collectors.toList()));
		assertEquals(2, flightService.getAll().size());
	}

//	@Test
//	public void FindByNo() throws Exception {
//		int no = 1;
//		Mockito.when(flightService.getByFlightNo(no)).thenReturn(
//				(Flight) Stream.of(new Flight(1, "Indigo", "Mumbai", "Nagpur", 500)).collect(Collectors.toList()));
//		assertEquals(1, ((List<Flight>) flightService.getByFlightNo(no)).size());
//	}

	@Test
	public void FindByCarrierTest() throws Exception {
		String carrier = "Indigo";
		Mockito.when(flightService.findByCarrier(carrier))
				.thenReturn(Stream.of(new Flight(1, "Indigo", "Mumbai", "Nagpur", 500)).collect(Collectors.toList()));
		assertEquals(1, flightService.findByCarrier(carrier).size());
	}

	@Test
	public void FindBySourceTest() throws Exception {
		String source = "Nagpur";
		Mockito.when(flightService.findBySource(source))
				.thenReturn(Stream.of(new Flight(1, "Indigo", "Mumbai", "Nagpur", 500)).collect(Collectors.toList()));
		assertEquals(1, flightService.findBySource(source).size());
	}

	@Test
	public void FindByDestinationTest() throws Exception {
		String destination = "Mumbai";
		Mockito.when(flightService.findByDestination(destination))
				.thenReturn(Stream.of(new Flight(1, "Indigo", "Mumbai", "Nagpur", 500)).collect(Collectors.toList()));
		assertEquals(1, flightService.findByDestination(destination).size());
	}

	@Test
	public void FindByPriceTest() throws Exception {
		int price = 500;
		Mockito.when(flightService.findByPrice(price))
				.thenReturn(Stream.of(new Flight(1, "Indigo", "Mumbai", "Nagpur", 500)).collect(Collectors.toList()));
		assertEquals(1, flightService.findByPrice(price).size());
	}

	@Test
	public void deleteTest() throws Exception {
		int no = 1;
		when(flightService.removeFlight(no)).thenReturn(true);
//		verify(flightService, times(1)).removeFlight(no);
		assertEquals(true, flightService.removeFlight(no));
	}

	@Test
	public void updateTest() throws Exception {
		Flight mockFlight = new Flight(1, "Indigo", "Mumbai", "Nagpur", 500);
		Mockito.when(repo.save(mockFlight)).thenReturn(mockFlight);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateFlight").accept(MediaType.APPLICATION_JSON)
				.content(exampleFlight).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals("Flight updated", response.getContentAsString());
	}
}
