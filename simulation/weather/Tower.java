package simulation.weather;

import java.util.*;

import simulation.aircraft.*;
import simulation.weather.*;

public class Tower
{
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) 
    {
        observers.add(flyable); 
        System.out.println("registers");
    }

    private void unregister(Flyable flyable) 
    {
        
    }
}