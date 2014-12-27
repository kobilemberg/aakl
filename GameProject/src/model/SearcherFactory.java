package model;

import java.util.HashMap;

import model.algorithems.AstarHeuristicSearcher;
import model.algorithems.BFSCommonSearcher;
import model.algorithems.Searcher;

public class SearcherFactory 
{
	
	public interface SearcherCreator
	{
		public Searcher create();
	}
	private class BFSSearcherCreator implements SearcherCreator
	{
		public Searcher create() 
		{
			return new BFSCommonSearcher(null, null);
		}
	}
	private class AstarSearcherCreator implements SearcherCreator
	{
		public Searcher create() 
		{
			return new AstarHeuristicSearcher(null, null, null);
		}
	}
	public HashMap<String,SearcherCreator> searcherCreator;

	public SearcherFactory() 
	{
		searcherCreator = new HashMap<String,SearcherCreator>();
		searcherCreator.put("BFS", (SearcherCreator) new BFSCommonSearcher(null, null));
		searcherCreator.put("Astar", (SearcherCreator) new AstarHeuristicSearcher(null, null, null));
 
	}

}
