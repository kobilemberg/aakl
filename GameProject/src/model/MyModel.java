package model;

import java.util.ArrayList;
import java.util.Observable;


import model.SearcherFactory.SearcherCreator;
import model.algorithems.Action;
import model.algorithems.SearchDomain;
import model.algorithems.Searcher;




public class MyModel extends Observable implements Model 
{
	private SearchDomain searchDomain;
	private Searcher searcher;
	private SearcherFactory searcherFactory;
	private Solution solution;
	private SolutionManager solutionManager;
	private DomainFactory domainFactory;
	
	public MyModel()
	{
		searcherFactory = new SearcherFactory();
		solutionManager = SolutionManager.getInstance();
		domainFactory = new DomainFactory();
	}
	
	public void selectDomain(String args) 
	{
		// TODO Auto-generated method stub
		String[] arr = args.split(":");
		String domainName = arr[0];
		String domainArgs = arr[1];
		searchDomain = domainFactory.CreateDomain(domainName);
		
		
	}

	
	public void selectalgorithm(String algorithmName) 
	{
		SearcherFactory algorithm = new SearcherFactory();
		SearcherCreator algorithmSearcher = algorithm.searcherCreator.get(algorithmName);
		if (algorithmSearcher!=null)
				algorithmSearcher.create();
	}

	
	public void solveDomain() {	
		String problemDescription = searchDomain.getProblemDescription();
		this.solution = solutionManager.getSolution(problemDescription);
		
		if (solution == null) {		
			ArrayList<Action> actions = searcher.search(searchDomain);
			solution = new Solution();
			solution.setActions(actions);
			solutionManager.addSolution(solution);
		}
		
		this.setChanged();
		this.notifyObservers();
	}

	public Solution getSolution() {
		// TODO Auto-generated method stub
		return solution;
	}

	public void doTask() {
		// TODO Auto-generated method stub
		solveDomain();
	}

}
