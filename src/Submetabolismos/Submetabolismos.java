package Submetabolismos;

import metabolismo.Energia;

public class Submetabolismos implements Runnable{
	public static final int periodo = 1000; 
	Energia energia;
	
	Anabolismo anabolismo;
	Catabolismo catabolismo;
	
	final int MAX_ENERGIA = 2000;
	
	int balancoAnabolico0a100 = 20; 
	
	public Submetabolismos(Energia e){
		this.energia = e;
	}
	public void run(){
		(catabolismo = new Catabolismo(energia)).run();;
		(anabolismo  = new Anabolismo(energia)).run();
	}
	private int getAnabolismo(){
		return balancoAnabolico0a100;
	}
	private int getCatabolismo(){
		return 100 - getAnabolismo();
	}
}
