package launcher.aircraft;

import launcher.aircraft.*;
import launcher.weather.*;
import launcher.writer.*;

/*
    Parent Class for all the Flyable types, takes the name and coordinates and also creates a special ID for each flyable created
*/

public class Aircraft
{
    protected Long id;
    private static Long idCounter = 0L;
    protected String name;
    protected Coordinates coordinates;
    protected WriteToFile writr = new WriteToFile();

    protected Aircraft(String name, Coordinates coordinates) 
    {
        this.id = nextId();
        this.coordinates = coordinates;
        this.name = name;
    }

    private Long nextId() 
    {
        return (++this.idCounter);    
    }
}