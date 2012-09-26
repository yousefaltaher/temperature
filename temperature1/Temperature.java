package Assignment1.TemperatureUnitTest;




public class Temperature implements Comparable<Temperature> {
 

 	  public static enum Units { FAHRENHEIT, CELCIUS, KELVIN }
 	  private double value; 
	  private Temperature.Units unit1;
	    
	  public Temperature (double value, Temperature.Units unit) {
	       this.unit1 = unit; 
	       this.value = value;
	       
	  }
 	   
	  public double getValue() { 
		   
	    return value; 
	  }
 	  
	  public Units getUnits() {
	    
		  return unit1; 
		  
		  
	  }

	   
	  public void changeUnits(Units units) {
	     
		 
		  double tempValue = value;  // setting our actual value to a temporary value to use
		  double valueCelsius   ; // initialze valueCelsius for conversions to celsius
		  
		 //if Same units, then keep units 
		  if (unit1 == units) {			  
			  return ; 
 		  }
		  // if unit that comes in is fahrenheit, then convert to celsius 
		  if (unit1.toString().matches("FAHRENHEIT")){
			  
			  valueCelsius = ((tempValue-32)*5) / (9);
			  unit1=units;  // to adjust the units correctly
			   
			  
		  }
		  // if unit that comes in is kelvin, then convert to celsius as well
		  else if (unit1.toString().matches("KELVIN")){
	 
			   valueCelsius = tempValue - 273.15; 
			  unit1= units; // To adjust the units correctly
  
		  } 
			  else    
			 	
			valueCelsius = tempValue; 
		    unit1 = units; 
		  
		if (units.toString().matches("KELVIN")){
			   value = valueCelsius + 273.15;
			  return;
		  }
		  
		  // if requested unit is fahrenheit, then convert celsius value to fahrenheit
		else if (units.toString().matches("FAHRENHEIT")){
			   value = ((valueCelsius)*(9.0/5.0) + 32.0);
			   return;
			   
		  }
		else
		{   value = valueCelsius ; 
		   return ;
		  } 
	  
	  }
 
	  public String toString() {
		 // output is what printoutput of the expression   
		String expressionOutput, tempSymbol=null; 
		//translates unit to its symbol
		  if (unit1.toString().matches("CELCIUS")){
			  tempSymbol = "¡C";
		  }
		  
		  if (unit1.toString().matches("FAHRENHEIT"))
			  tempSymbol = "¡F";
		  
		  if (unit1.toString().matches("KELVIN"))
			  tempSymbol = "K";
		  
		  expressionOutput = "The Temperature is  " +  value + "  " + tempSymbol;
		  
		  return expressionOutput; 
	  }	   
	  /*@Override*/
	  public int compareTo (Temperature temperature) {
		  Temperature.Units tempUnit = temperature.getUnits();
		  
		  // checks to see if units are the same, if not, then converts
		  if (unit1 == temperature.unit1){
			  
		  }
		else
			  temperature.changeUnits(unit1);
		   
		  // makes the comparison
		  if (value< temperature.value)
		  { 
			  
			  temperature.changeUnits( tempUnit);
			  return -1;
			  
		  }
		  else if (value> temperature.value)
		  { 
			  temperature.changeUnits( tempUnit);
			  return 1;
			  
		  }
		  else
		  {  // if neither greater nor less than, then equals therefore 0 
		  temperature.changeUnits( tempUnit);
		  return 0;
		  } 
	  }

	  /**
	   * Indicates whether some object is "equal" to this one.
	   * To maintain consistency, whenever a class overrdes 
	   * {@code compareTo}, it must override {@code equals} so 
	   * that
	    <pre>
	       <code>o1.compareTo(o2) == 0</code> implies <code>o1.equals(o2) == true</code>
	     </pre>
	   * See the API documentation of {@code Object} class for more details.
	   */
	  
	     
		public boolean equals (Temperature o){
			
			if (o.compareTo(this) < 0) {
				return false;
			}
				else if (o.compareTo(this)>0){
					return false;
				}
				else
					return true;
				}
			 
	  @Override
	  // used Used http://www.coderanch.com/t/514972/java/java/Explation-Object-Identity#2330779 to get this  
	  public int hashCode() {
		  int temperatureStore; 
		  
		  temperatureStore = /*value.hashCode() + */ unit1.hashCode(); //WHY ISNT IT ACCEPTING PRIMITIVE TYPE?!?!
		  return temperatureStore; 
		  
		  
		 	  }
	}

