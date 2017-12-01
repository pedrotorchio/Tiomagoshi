package metabolismo;

import java.util.Timer;
import java.util.TimerTask;

import Submetabolismos.Anabolismo;
import Submetabolismos.Catabolismo;

public class Metabolismo{
	public static final int periodo = 1000; 
	Energia energia;
	
	Anabolismo anabolismo;
	Catabolismo catabolismo;
	
	final int MAX_ENERGIA = 2000;
	
	int balancoAnabolico0a100 = 20; 
	
	public Metabolismo(Energia e){
		this.energia = e;
	}
	public void run(){
		catabolismo = new Catabolismo(energia);
		anabolismo  = new Anabolismo(energia);
	}
	private int getAnabolismo(){
		return balancoAnabolico0a100;
	}
	private int getCatabolismo(){
		return 100 - getAnabolismo();
	}
}
