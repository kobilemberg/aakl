package model;
import java.util.HashMap;

import model.algorithems.AstarHeuristicSearcher;
import model.algorithems.BFSCommonSearcher;
import model.algorithems.SearchDomain;
import model.domains.maze.MazeSearchDomain;
public class DomainFactory 
{
	public interface DomainCreator
	{
		public SearchDomain create();
	}
	private class MazeDomainCreator implements DomainCreator
	{
	 public SearchDomain create() 
	 {
	  return new MazeSearchDomain();
	}
}
	

HashMap<String,DomainCreator> domainCreator;

public DomainFactory() {
 domainCreator = new HashMap<String,DomainCreator>();
 domainCreator.put("BFS", (DomainCreator) new BFSCommonSearcher(null, null));
 domainCreator.put("Astar", (DomainCreator) new AstarHeuristicSearcher(null, null, null));
 // notice, takes O(n) memory
}


}
