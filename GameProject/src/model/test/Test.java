package model.test;

import java.util.ArrayList;

import model.algorithems.Action;
import model.algorithems.AstarHeuristicSearcher;

import model.algorithems.BFSCommonSearcher;
import model.algorithms.distances.AirDistance;
import model.domains.maze.MazeSearchDomain;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) 
	{
		
		// new random Maze sized 10 x 10 with 50 walls
		System.out.println("testing!");
		MazeSearchDomain m = new MazeSearchDomain(5);
		// print the problem for debug
		System.out.println(m.toString());
		AstarHeuristicSearcher aStar=new AstarHeuristicSearcher(m,new AirDistance(),new AirDistance());
		// to do: get the current time
		// start searching
		long aStarStartTime = System.nanoTime();
		ArrayList<Action> actionsAstar = aStar.search(m);
		//ArrayList<Action> actionsAstar = aStar.search(m);
		System.out.println("The time that takes Astar to search in our maze is: "+((System.nanoTime()-aStarStartTime)*0.000001) +" in mili seconds");
		System.out.println("\n \n \n *********************now printing Astar Solutions maze game domain***********************");
		for(Action a : actionsAstar)
		{
			
			System.out.println(a.getActionName());
			System.out.println("");
			
		}
		System.out.println("");
		System.out.println("\n \n \n *********************Finished Astar***********************");
		

		
		System.out.println("\n \n \n *********************now printing BFS for maze game domain***********************");
		BFSCommonSearcher bfs = new BFSCommonSearcher(m,new  AirDistance());
		long bfsStartTime = System.nanoTime();
		ArrayList<Action> actionsBFS = bfs.search(m);
		System.out.println("The time that takes BFS to search in our maze is: "+((System.nanoTime()-aStarStartTime)*0.000001) +" in mili seconds");
		// to do: get the current time and print the time difference
		// print the solution for debug
		//System.out.println(actionBFS.toString);
		
		 System.out.println("");
		
		
		
		for(Action a : actionsBFS)
			
		{
			System.out.println(a.getActionName());
			System.out.println();
		
		
		}
		
		System.out.println("\nDone.");
	
	}

}
