package view;

import java.util.Observable;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class BasicWindow extends Observable implements Runnable {
	Display display;
	Shell shell;
	
	public BasicWindow(int width, int height, String title) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(width,height);
		shell.setText(title);
		
	}
	
	// All heirs must implement this function. 
	abstract void initWidgets();
	
	public void run() {
		//init widgets
		initWidgets();
		
		// open the shell
		shell.open();
		
		// main event loop
		while(!shell.isDisposed()){ // window isn't closed
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		
		display.dispose(); // dispose OS components.

	
	}
}