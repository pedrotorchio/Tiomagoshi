package Submetabolismos;

import java.util.Timer;
import java.util.TimerTask;

import metabolismo.Energia;

public abstract class AbsSubmetabolismo extends TimerTask{
	
	protected Energia energia;
	public AbsSubmetabolismo(Energia energia){
		this.energia = energia;
	}
	public void start(){
		Timer timer = new Timer(true);
		  	  timer.scheduleAtFixedRate(this, 0, Submetabolismos.periodo);
	}
	public void run(){
		loop();		  
	}
	public abstract void loop();
}
