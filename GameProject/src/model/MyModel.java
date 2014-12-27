package model;

import model.DomainFactory.DomainCreator;
import model.SearcherFactory.SearcherCreator;




public class MyModel implements Model 
{

	
	public void selectDomain(String domainName)
	{
		DomainFactory domainCreator = new DomainFactory();
		DomainCreator name = domainCreator.domainCreator.get(domainName);
		if (name!=null)
			name.create();
		
	}

	
	public void selectalgorithm(String algorithmName) 
	{
		SearcherFactory algorithm = new SearcherFactory();
		SearcherCreator algorithmSearcher = algorithm.searcherCreator.get(algorithmName);
		if (algorithmSearcher!=null)
				algorithmSearcher.create();
	}

	@Override
	public void solveDomain() 
	{
		
	}

	//@Override
	//public Solution getSolution() {
	//	// TODO Auto-generated method stub
	//	return algorithmN(D());
	//}

}
