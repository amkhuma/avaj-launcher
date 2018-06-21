package simulation.aircraft;

import simulation.aircraft.*;
import simulation.weather.*;

public class AircraftFactory 
{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) 
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
		} else {
			return null;
		}
	}
}