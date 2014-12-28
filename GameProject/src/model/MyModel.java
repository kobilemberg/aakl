package model;

import java.util.ArrayList;
import java.util.Observable;

import model.DomainFactory.DomainCreator;
import model.SearcherFactory.SearcherCreator;
import model.algorithems.Action;
import model.algorithems.SearchDomain;
import model.algorithems.Searcher;
import model.domains.maze.MazeSearchDomain;




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
	
	public void selectDomain(String args) {
		// TODO Auto-generated method stub
		// domain = domainFactory.createDomain(domainName)
		String[] arr = args.split(":");
		String domainName = arr[0];
		String domainArgs = arr[1];
		searchDomain = new MazeSearchDomain(10);
	}
	/*public void selectalgorithm(String algorithmName) 
	{
		SearcherFactory algorithm  = new SearcherFactory();
		SearcherCreator algorithmSearcher = algorithm.searcherCreator.get(algorithmName);
		if (algorithmSearcher!=null)
				algorithmSearcher.create();
		//AstarHeuristicSearcher searcher = new AstarHeuristicSearcher();
		//System.out.println(searcher.getSd().toString());
		
	}*/
	public void selectAlgorithm(String algorithmName) {
		// TODO Auto-generated method stub
		System.out.println("Done!!!");
		 searcher = searcherFactory.createAlgorithm(algorithmName);
	}
	
	public void solveDomain() {	
		String problemDescription = searchDomain.getProblemDescription();
		System.out.println(problemDescription);
		this.solution = solutionManager.getSolution(problemDescription);
		
		if (solution == null) {	
			System.out.println(searchDomain);
			System.out.println(searchDomain.getStartState());
			System.out.println(searchDomain.getGoalState());
			System.out.println(searcher==null);
			ArrayList<Action> actions = searcher.search(searchDomain);
			System.out.println(searchDomain);
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

	public void selectalgorithm(String algorithmName) {
		// TODO Auto-generated method stub
		Searcher searcher = searcherFactory.createAlgorithm(algorithmName);
		
	}

	

}
