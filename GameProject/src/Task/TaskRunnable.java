package Task;

import model.Model;


public class TaskRunnable implements Runnable 
{

	private Task t;
	
	public TaskRunnable(Model model) 
	{
		this.t = (Task)model;
	}

	public void run() {
		t.doTask();
		
	}

}
