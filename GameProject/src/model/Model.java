package model;

import java.util.Observer;

import Task.Task;

public interface Model extends Task

{
	void selectDomain(String domainName);
	void selectAlgorithem(String algorithemName);
	void solveDomain();
	Solution getSolution();
	void addObserver(Observer o);
	
	/*
	 * import java.util.Observer;

public interface Model {
	void selectDomain(String domainName);
	void selectAlgorithm(String algorithmName);
	void solveDomain();
	Solution getSolution();	
	void addObserver(Observer o);
}

	 */
	
}
