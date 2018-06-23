package simulation.weather;

import java.util.*;

import simulation.aircraft.*;
import simulation.weather.*;

public class Tower
{
    private List<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> unregistered = new ArrayList<Flyable>();

    public void register(Flyable flyable) 
    {
        if (observers.contains(flyable)) {
			return ;
		}
        observers.add(flyable); 
        //System.out.println(flyable);
    }

    public void unregister(Flyable flyable) 
    {
        if (unregistered.contains(flyable))
        {
            return ;
        }
        unregistered.add(flyable);
    }

    protected void conditionsChanged() 
    {
        for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
		observers.removeAll(unregistered);
    }
}