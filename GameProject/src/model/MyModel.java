package model;



public class MyModel implements Model 
{

	@Override
	public void selectDomain(String domainName) 
	{
		DomainFactory domainCreater = new DomainFactory();
		DomainCreator name = domainCreater.DomainCreator.get(domainName);
		if (name!=null)name.create();
		return;
	}

	@Override
	public void selectalgorithm(String algorithmName) {
		SearcherFactory algorithm = new SearcherFactory();
		Creator algorithmN = algorithm.SearcherCreator.get(algorithmName);
		if (algorithmN!=null)algorithmN.create();
		return;

	}

	@Override
	public void solveDomain() {
		
	}

	//@Override
	//public Solution getSolution() {
	//	// TODO Auto-generated method stub
	//	return algorithmN(D());
	//}

}
