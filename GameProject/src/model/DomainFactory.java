package model;

import java.util.HashMap;

import model.algorithems.SearchDomain;
import model.domains.maze.MazeSearchDomain;



public class DomainFactory {
	private HashMap<String, DomainCreator> Domain;
	
	public DomainFactory()
	{
		Domain = new HashMap<String, DomainCreator>();
		Domain.put("MazeGameDomain", new MazeGameDomainCreator());
		
	}
	
	public SearchDomain CreateDomain(String DomainName)
	{
		DomainCreator creator = Domain.get(DomainName);
		SearchDomain Domain = null;
		if (creator != null)  {
			Domain = creator.create();			
		}
		return Domain;
	}
	
	private interface DomainCreator
	{
		SearchDomain create();
	}
	
	private class MazeGameDomainCreator implements DomainCreator
	{
		public SearchDomain create() 
		{
			// TODO Auto-generated method stub
			return new MazeSearchDomain();
		}		
	}
	
	
}
