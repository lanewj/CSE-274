/**
 * 
 */
package project1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author vanilly
 *
 *
 *methods that i believe work: addcity, removeCity,containsCity, getCityCount, getCity, getDirectlyConnectedCities(however its sometimes prints the same city twice
 *								connect, disconnect, are directly connect
 *methods that dont work; degreesOfSeperation, are connected
 *
 *
 *
 */
public class RoadNetwork 
{
	private ArrayList network;
	private int count;
	public RoadNetwork()//constructor
	{
		network= new ArrayList<City>();
	}
	public boolean addCity(String name)
	{
		City c = new City(name);
		if(containsCity(name)==false)//checks to make sure it isnt already i network
		{
		network.add(c);
		count++; //increases count
		return true;
		}
		else 
			return false;
	}
	public void removeCity(String name)
	{
		City c = getCity(name);
		network.remove(c); //removes city
		count--;
	}
	public boolean containsCity(String name)
	{
		for(int i=0;i<network.size();i++)
		{
			if(((City) network.get(i)).getName().equals(name)) //seraches the network to see if city is present
			{
				return true;
			}
		}
		return false;
	}
	public int getCityCount()
	{
		return count; //very simple method
	}
	public String[] getCities()
	{
		String[] all = new String[count];
		for(int i=0; i< all.length;i++)
		{
			all[i]=((City) network.get(i)).getName(); //adds all cities to a string
		}
		return all;
	}
	public String[] getDirectlyConnectedCities()
	{
		String[] cities = new String[count];
		int num=0;
		
		for(int i =0; i<count; i++)
			for(int w=1;w<count;w++)
			{
				if(areDirectlyConnected(((City) network.get(i)).getName(),((City) network.get(w)).getName()))// utilises my aredirectly connect method
				{
					
					cities[num]=((City) network.get(i)).getName();
					num++;
				}
			}
		ArrayList<String> ret= new ArrayList<String>();
		
		for(int q=0;q<cities.length;q++)
		{
			if(!ret.contains(cities[q]))
					{
				
					if(cities[q]!=null)
					{
						ret.add(cities[q]);
					}
					}                                       //this is my attempt at deleting null values and duplicate cities
		}
		cities = new String[ret.size()];
		
		for(int p=0;p<ret.size();p++)
		{
			cities[p]=ret.get(p);
		}
				
		return cities;
		
	}
	public boolean connect(String city1, String city2)
	{
		City c = getCity(city1);
		City c2= getCity(city2);
		if(network.contains(city1)&&network.contains(city2))
		
		 //c = getCity(city1);
		//c2 = getCity(city2);
		
		if(areDirectlyConnected(city1,city2)==false)
		{return false;}
		else
		
		c.addLink(city2);
		//System.out.println("ya");
		c2.addLink(city1);
		c.addLink(city2);
		
		
		return true;
	}
	public void disconnect(String city1, String city2)
	{
		
		City c = getCity(city1);
		City c2= getCity(city2);
		
		
		if(network.contains(city1)&&network.contains(city2))
		
		c.removeLink(city2);
		//System.out.println("ya");
		c2.removeLink(city1);
		c.removeLink(city2);
			
	}
	public boolean areDirectlyConnected(String city1, String city2)
	{
		City c = getCity(city1);
		City c2= getCity(city2);
		ArrayList<String> links = new ArrayList<String>();
		links = c.getLinks();
		
		
			for(int i = 0;i<links.size();i++)
			{
				if(links.get(i).equals(c2.getName()))
				{
					return true;
				}
			}
		
			return false;
	}
	public boolean areConnected(String city1, String city2)
	{
		return true;
	}
	public int degreesOfSeparation(String city1, String city2)
	{
		return 0;
	}
	public String toString()
	{
		String ret = "";
		City c;
		ArrayList links;
		for(int i=0; i<network.size();i++)
		{
			c= (City) network.get(i);
			links = c.getLinks();
			ret = ret + c.getName() +  "  links: ";
			
			for(int w=0; w<links.size();w++)
			{
				ret = ret + links.get(w) + " ";
				
			}
			ret = ret +  "\n";
		}
		return ret;
	}
	public City getCity(String name)// i added this method to return the city object when given the name of the city
	{
		City city;
		for(int i=0;i<network.size();i++)
		{
			if(((City) network.get(i)).getName().equals(name))
			{
				city = (City)network.get(i);
				return city;
			}
		}
		return null;
	}
	
	
	
	
	
}
