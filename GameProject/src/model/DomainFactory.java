package model;

import java.util.HashMap;

import model.algorithems.SearchDomain;
import model.domains.maze.MazeSearchDomain;



public class DomainFactory {
	public HashMap<String, DomainCreator> domainCreator;
	
	public DomainFactory()
	{
		domainCreator = new HashMap<String, DomainCreator>();
		domainCreator.put("MazeGameDomain", new MazeGameDomainCreator());
		
	}
	
	public SearchDomain CreateDomain(String DomainName)
	{
		DomainCreator creator = domainCreator.get(DomainName);
		SearchDomain Domain = null;
		if (creator != null)  {
			Domain = creator.create();			
		}
		return Domain;
	}
	
	public interface DomainCreator
	{
		SearchDomain create();
	}
	
	private class MazeGameDomainCreator implements DomainCreator
	{
		public SearchDomain create() 
		{
			// TODO Auto-generated method stub
			MazeSearchDomain domain = new MazeSearchDomain();
			domain.printMaze();
			return domain;
			
		}		
	}
	
	
}
