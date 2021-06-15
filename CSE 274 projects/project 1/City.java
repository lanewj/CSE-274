package project1;

import java.util.ArrayList;

public class City 
{
	private String name;
	private ArrayList<String> links;
	
	public City(String n)
	{
		name=n;
		links = new ArrayList<String>();
	}
	public String getName()
	{
		return name;
	}
	public ArrayList<String> getLinks()
	{
		return links;
	}
	public void addLink(String l)
	{
		links.add(l);
	}
	public void removeLink(String l)
	{
		links.remove(l);
	}
	public String toString()
	{
		String ret="";
		for(int i=0;i<links.size();i++)
		{
			ret = ret + links.get(i);
		}
		return name+ " " +ret;
	}
	
}
