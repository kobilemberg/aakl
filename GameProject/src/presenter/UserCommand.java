package presenter;

import java.util.HashMap;

import model.Model;
import model.MyModel;
import Task.TaskRunnable;

public class UserCommand {

	private HashMap<String, Command> commands = 
			new HashMap<String,Command>();
	
	public UserCommand()
	{
		commands.put("SelectDomain", new SelectDomainCommand());
		commands.put("SelectAlgorithm", new SelectAlgorithmCommand());
		commands.put("SolveDomain", new SolveDomainCommand());
		commands.put("SolveDomainInThread", new SolveDomainInThread());
	}
	
//	public void doCommand(Model model, String commandName, String args)
//	{
//		Command command = commands.get(commandName);
//		if (command != null)
//		{
//			command.doCommand(model, args);
//		}
//	}
	
	public Command selectCommand(String commandName)
	{
		Command command = commands.get(commandName);
		return command;
	}
	
	public interface Command
	{
		Model doCommand(Model model, String args);
	}
	
	private class SelectDomainCommand implements Command
	{
		public Model doCommand(Model model, String args) {
			Model m = new MyModel();
			m.selectDomain(args);	
			return m;
		}		
	}
	
	private class SelectAlgorithmCommand implements Command
	{
		public Model doCommand(Model model, String args) {
			model.selectalgorithm(args);
			return model;
		}		
	}
	
	private class SolveDomainCommand implements Command
	{
		public Model doCommand(Model model, String args) {
			model.solveDomain();	
			return model;
		}		
	}
	
	private class SolveDomainInThread implements Command
	{

		public Model doCommand(Model model, String args) 
		{
			Thread t = new Thread(new TaskRunnable(model));
			t.start();
			return model;
		}
		
	}
	
	
	
	
}
