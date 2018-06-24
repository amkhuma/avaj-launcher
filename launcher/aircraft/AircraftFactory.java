package launcher.aircraft;

import launcher.aircraft.*;
import launcher.weather.*;
import launcher.writer.*;

/*
	the name itself shows that this is where a flyable is created and all the necessary details are passed
*/

public class AircraftFactory 
{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) 
    {
		if (longitude >= 0 && latitude >= 0 && height >= 1)
		{
			Coordinates coordinates = new Coordinates(longitude, latitude, height);

			String uName = type.toUpperCase();
        	if (uName.equals("BALOON")) 
        	{
				return new Baloon(name, coordinates);
			}
        	else if (uName.equals("JETPLANE")) 
        	{
				return new JetPlane(name, coordinates);
			}
        	else if (uName.equals("HELICOPTER")) 
        	{
            	return new Helicopter(name, coordinates);
			} 
			else 
			{
				System.out.println("Wrong Flyable type");
				System.exit(1);
				return null;
			}
		}
		else 
		{
			System.out.println("Invalid number, should not be negative or contain non-numeric characters");
			System.exit(1);
			return null;
		}
	}
}