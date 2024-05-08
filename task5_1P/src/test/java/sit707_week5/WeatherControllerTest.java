package sit707_week5;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class WeatherControllerTest {
	
//    @Before
//    public void setUp() {
//        // Initialize mock clock
//        mockClock = mock(Clock.class);
//        
//        // Create WeatherController instance with the mock clock
//        weatherController = new WeatherController(mockClock);
//    }

	@Test
	public void testStudentIdentity() {
		String studentId = "223558537";
		Assert.assertNotNull("Student ID is not null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Niwanthi";
		Assert.assertNotNull("Student name is null", studentName);
	}

//	@Test
//	public void testTemperatureMin() {
//		System.out.println("+++ testTemperatureMin +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		// Retrieve all the hours temperatures recorded as for today
//		int nHours = wController.getTotalHours();
//		double minTemperature = 1000;
//		for (int i=0; i<nHours; i++) {
//			// Hour range: 1 to nHours
//			double temperatureVal = wController.getTemperatureForHour(i+1); 
//			if (minTemperature > temperatureVal) {
//				minTemperature = temperatureVal;
//			}
//		}
//		
//		// Should be equal to the min value that is cached in the controller.
//		Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
//		
//		// Shutdown controller
//		wController.close();		
//	}
//	
//	@Test
//	public void testTemperatureMax() {
//		System.out.println("+++ testTemperatureMax +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		// Retrieve all the hours temperatures recorded as for today
//		int nHours = wController.getTotalHours();
//		double maxTemperature = -1;
//		for (int i=0; i<nHours; i++) {
//			// Hour range: 1 to nHours
//			double temperatureVal = wController.getTemperatureForHour(i+1); 
//			if (maxTemperature < temperatureVal) {
//				maxTemperature = temperatureVal;
//			}
//		}
//		
//		// Should be equal to the min value that is cached in the controller.
//		Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
//		
//		// Shutdown controller
//		wController.close();
//	}
//
//	@Test
//	public void testTemperatureAverage() {
//		System.out.println("+++ testTemperatureAverage +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		// Retrieve all the hours temperatures recorded as for today
//		int nHours = wController.getTotalHours();
//		double sumTemp = 0;
//		for (int i=0; i<nHours; i++) {
//			// Hour range: 1 to nHours
//			double temperatureVal = wController.getTemperatureForHour(i+1); 
//			sumTemp += temperatureVal;
//		}
//		double averageTemp = sumTemp / nHours;
//		
//		// Should be equal to the min value that is cached in the controller.
//		Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
//		
//		// Shutdown controller
//		wController.close();
//	}
	
	@Test
    public void testTemperaturePersist() {
        // Arrange: Initialize controller and define input parameters
        WeatherController wController = WeatherController.getInstance(); // Initialize WeatherController instance
        
        int hour = 10; // Define the hour
        double temperature = 19.5; // Define the temperature
        
        // Act: Invoke the method under test
        String persistTime = wController.persistTemperature(hour, temperature); // Persist temperature
        
        // Get the current time
        String now = new SimpleDateFormat("H:m:s").format(new Date()); // Get current time
        
        System.out.println("Persist time: " + persistTime + ", now: " + now);
        
        // Assert: Verify the outcome of the method under test
        // Compare the persisted time with the current time (ignoring milliseconds for better repeatability)
        Assert.assertEquals("Persisted time should match current time", now.substring(0, 5), persistTime.substring(0, 5));
        
        // Cleanup: Close the controller
        wController.close();
    }
}
