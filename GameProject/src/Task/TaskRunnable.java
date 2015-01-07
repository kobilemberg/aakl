package Task;

import model.Model;


public class TaskRunnable implements Runnable 
{

	private Task t;
	
	public TaskRunnable(Task t) 
	{
		this.t = t;
	}

	public void run() {
		t.doTask();
		
	}

}
