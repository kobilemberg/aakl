package model.algorithems;

import java.util.*;

public abstract class HeuristicSearcher extends AbsCommonSearcher {
	//HeuritiscsFuncForState HeuristicFuncAdapter;
	
	protected Distance h;
	protected Distance g;
	
	protected HashSet<String> existsInTheQueue = new HashSet<String>();
	
	
	
	public HeuristicSearcher(SearchDomain sd, Distance h, Distance g) 
	{
		super(sd);
		this.h = h;
		this.g = g;	
	}
	
	public HeuristicSearcher()
	{
		super();
	}
	public void setDistance(Distance h,Distance g) {
		this.h = h;
		this.g = g;
	}
	
	@Override
	public abstract ArrayList<Action> search(SearchDomain domain);

	public Distance getH() {
		return h;
	}

	public void setH(Distance h) {
		this.h = h;
	}

	public Distance getG() {
		return g;
	}

	public void setG(Distance g) {
		this.g = g;
	}

	public HashSet<String> getExistsInTheQueue() {
		return existsInTheQueue;
	}

	public void setExistsInTheQueue(HashSet<String> existsInTheQueue) {
		this.existsInTheQueue = existsInTheQueue;
	}
	

}
