package simulation.weather;

import java.util.*;

import simulation.aircraft.*;
import simulation.weather.*;

public class Tower
{
    private List<Flyable> observers = new ArrayList<Flyable>();
    //private List<Flyable> landed = new ArrayList<Flyable>();

    public void register(Flyable flyable) 
    {
        if (observers.contains(flyable)) {
			return ;
		}
        observers.add(flyable); 
        //System.out.println(flyable);
    }

    private void unregister(Flyable flyable) 
    {
        
    }

    protected void conditionsChanged() 
    {
        int i = 1;
        for (Flyable flyable : observers) {
			flyable.updateConditions();
			/*if(flyable.getCoordinates().getHeight() <= 0)
				landed.add(flyable);*/
		}
		//observers.removeAll(landed);
    }
}