package model.algorithems;
import java.util.ArrayList;

public interface Searcher 
{
	public ArrayList<Action> search(SearchDomain domain);
	public int getNumOfEvaluatedNodes();

}
