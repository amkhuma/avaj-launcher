package simulation.aircraft;

import simulation.aircraft.*;
import simulation.weather.*;

public class Aircraft
{
    protected Long id;
    private static Long idCounter = 0L;
    protected String name;
    protected Coordinates coordinates;

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