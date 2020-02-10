package com.example.cg.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(public * com.example.cg.rest.FlightController.getAll())")
	public void log() {
		LOGGER.info("getAll method called from aspect");
	}
	
	@Before("execution(public * com.example.cg.rest.FlightController.get(int))")
	public void getFlightById() {
		LOGGER.info("getFlight method called from aspect");
	}
}
