package Submetabolismos;

import java.util.Timer;
import java.util.TimerTask;

import metabolismo.Metabolismo;

public abstract class Submetabolismo extends Thread{

	public void run(){
		Timer timer = new Timer(true);
		  timer.scheduleAtFixedRate(new TimerTask(){
			  
			  
			  public void run(){
				loop();  
			  }
			  
			  
		  }, 0, Metabolismo.periodo);
	}
	public abstract void loop();
}
