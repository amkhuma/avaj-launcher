package simulation.aircraft;

import simulation.aircraft.*;
import simulation.weather.*;

public class Aircraft
{
    protected Long id;
    private Long idCounter = 0L;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(String name, Coordinates coordinates) 
    {
        this.idCounter = nextId();
        this.id = this.idCounter;
        this.coordinates = coordinates;
        this.name = name;
    }

    private Long nextId() 
    {
        return (++idCounter);    
    }
}