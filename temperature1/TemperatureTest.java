// Yousef Al Taher 
//260314786
//Assignment 2 (Testing of Assignment 1)
package Assignment1TemperatureUnitTest;
import junit.framework.TestCase; 

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Assignment1.TemperatureUnitTest.Temperature;
import Assignment1.TemperatureUnitTest.Temperature.Units;

public class TemperatureTest {
	
	private Temperature temperature; 
	private Temperature temperature2;
	private Temperature temperature3; 
	private Temperature temp4; // used this to test 'equals()' method from FAHRENHEIT to CELCIUS or KELVIN
	
	
	@Before
	public void setUp() throws Exception {
		
		temperature = new Temperature(0, Temperature.Units.KELVIN);
		temperature2 = new Temperature(10, Temperature.Units.FAHRENHEIT);
		temperature3 = new Temperature(-10, Temperature.Units.CELCIUS);
		temp4 = new Temperature(32, Temperature.Units.FAHRENHEIT); // used this to test 'equals()' method from FAHRENHEIT to CELCIUS or KELVIN
		
	}

	@Test
	public void testGetValue() {
		double iValue = 0; 
		double iValue2 = 10; 
		double iValue3 = -10; 
		assertEquals("", iValue, temperature.getValue());
		assertEquals("", iValue2, temperature2.getValue());
		assertEquals("", iValue3, temperature3.getValue());
		
		
 	}
 
	@Test
	public void testGetUnits() {
		Units string1 = Temperature.Units.KELVIN; 
		Units string2 = Temperature.Units.FAHRENHEIT;
		Units string3 = Temperature.Units.CELCIUS;
		
		 assertTrue(string1.equals(temperature.getUnits()));
		 assertTrue(string2.equals(temperature2.getUnits())); 
		 assertTrue(string3.equals(temperature3.getUnits()));
 	}
	
	
	// converting from CECLIUS to KELVIN or FAHRENHEIT gives a failure
	@Test
	public void testChangeUnits() {
		
		//Kelvin to Fahrenheit Test (SUCCESS)
		Units string1 = Temperature.Units.FAHRENHEIT;
		 temperature.changeUnits(Temperature.Units.FAHRENHEIT);
		 assertTrue (string1.equals(temperature.getUnits()));
		 assertEquals("", -459.67, temperature.getValue());
		 
		 // Kelvin to Celcius test (SUCCESS)
		 Units string2 = Temperature.Units.CELCIUS;
		 temperature.changeUnits(Temperature.Units.CELCIUS);
		 assertTrue (string2.equals(temperature.getUnits()));
		 assertEquals("", -273.15, temperature.getValue()); 
		 
		 //Fahrenheit to kelvin test (SUCCESS)
		 Units string3 = Temperature.Units.KELVIN;
		 temperature2.changeUnits(Temperature.Units.KELVIN);
		 assertTrue (string3.equals(temperature2.getUnits()));
		 assertEquals("", 260.928, temperature2.getValue()); 
		 
		 //fahrenheit to celcius test (SUCCESS)
		  Units string4 = Temperature.Units.CELCIUS;
		 temperature2.changeUnits(Temperature.Units.CELCIUS);
		 assertTrue (string4.equals(temperature2.getUnits()));
		 assertEquals("", -12.2222, temperature2.getValue()); 
		 
		 //Celcius to Kelvin  (SUCCESS)
		 Units string5 = Temperature.Units.KELVIN;
		 temperature3.changeUnits(Temperature.Units.KELVIN);
		  assertTrue (string5.equals(temperature3.getUnits()));
		  assertEquals("", 263.15, temperature3.getValue()); 
		 
		 //Celcius to Fahrenheit (SUCCESS)
		  Units string6 = Temperature.Units.FAHRENHEIT;
		  temperature3.changeUnits(Temperature.Units.FAHRENHEIT);
		  assertTrue (string6.equals(temperature3.getUnits()));
		  assertEquals("", 14 , temperature3.getValue()); 
		 
		
 	} 

	@Test
	public void testEqualsObject() {
		 
		// Testing 'equals() method from KELVIN to KELVIN
		Temperature temperature4 = new Temperature(0, Temperature.Units.KELVIN); 
		 assertTrue("", temperature.equals(temperature4)  );
			
		 // Testing 'equals() method from KELVIN to CELCIUS
		 Temperature temperature5 = new Temperature(-273.15, Temperature.Units.CELCIUS); 
		 assertTrue("", temperature.equals(temperature4)  );
		
			// Testing 'equals() method from KELVIN to FAHRENHEIT
		 Temperature temperature6 = new Temperature(-459.67, Temperature.Units.FAHRENHEIT); 
		 assertTrue("", temperature.equals(temperature4)  );
		 
		 // Testing 'equals() method from CELCIUS to KELVIN
		 Temperature temperature7 = new Temperature( 263.15, Temperature.Units.KELVIN ); 
		assertTrue("", temperature3.equals(temperature7)  ); 
		
		// Testing 'equals() method from CELCIUS to FAHRENHEIT
		Temperature temperature8 = new Temperature(14, Temperature.Units.FAHRENHEIT); 
		assertTrue("", temperature3.equals(temperature8)  ); 
		
		// Testing 'equals() method from CELCIUS to CELCIUS
		Temperature temperature9 = new Temperature(-10, Temperature.Units.CELCIUS); 
		assertTrue("", temperature3.equals(temperature9)  ); 
		
		// Testing 'equals() method from FAHRENHEIT to FAHRENHEIT
		Temperature temperature10 = new Temperature(10, Temperature.Units.FAHRENHEIT); 
		assertTrue("", temperature2.equals(temperature10)  ); 
		
		// Testing 'equals() method from FAHRENHEIT to KELVIN
		Temperature temperature11 = new Temperature(273.15, Temperature.Units.KELVIN); 
		assertTrue("", temp4.equals(temperature11)  ); 
		
		// Testing 'equals() method from FAHRENHEIT to CELCIUS
		Temperature temperature12 = new Temperature(0, Temperature.Units.CELCIUS); 
		assertTrue("", temp4.equals(temperature12)  ); 
	}
}
/*Testing explanation
 * Note: the objects 'temperature', 'temperature2', 'temperature3' and 'temp4' were the set
 * Temperatures used for all the comparisons. 
 * temperature: 0K
 * temperature2: 10F
 * temperature3: -10C
 * temp4: 32F
  
- getValue() test: I just tested to see if the values of temperature, tempreature1, and temperature2 were returned properly (TOTAL 3 TESTS)
- getUnits() test: I just tested to see if the units temperature, temperature1 and temperature2 were returned properly (TOTAL 3 TESTS)
- ChangeUnits() test: I tested to see if units converted from K to F and K to C. (TOTAL 6 TESTS)
					  I then tested to see if units converted from F to K and F to C
					  I then tested to see if units converted from C to K and C to F
- equals() test: I  tested to see a temperature in one unit is equal to the same temperature in a different unit (TOTAL 9 TESTS)
 				 NOTE: temperature4 - temperature12 are objects used for the sole purpose for the 'equals()' method
 				 */