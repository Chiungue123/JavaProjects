package com.courseendprojects.JUnit1;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class SpeedTest {

	@Test
	@Timeout(value=6, unit=TimeUnit.MILLISECONDS)
	void testHeavyProcess(){
		
		Speed.process();
		
	}
}