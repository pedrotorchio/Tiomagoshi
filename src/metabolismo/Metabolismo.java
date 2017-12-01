package metabolismo;

import organismo.Energia;

public class Metabolismo implements Runnable{
	public static final int periodo = 1000;
	protected static Metabolismo instance = null;
	Energia energia;
	
	Anabolismo anabolismo;
	Catabolismo catabolismo;
	
	final int MAX_ENERGIA = 2000;
	
	private int balancoAnabolico0a100 = 20; 
	
	private Metabolismo(){}
	public static Metabolismo getInstance(){
		if(instance == null)
			instance = new Metabolismo();
		
		return instance;
	}
	public void run(){
		(catabolismo = new Catabolismo(energia)).start();
		(anabolismo  = new Anabolismo(energia)).start();
	}
	public void setEnergia(Energia energia){
		this.energia = energia;
	}
	public void setAnabolismo(int de0a100){
		balancoAnabolico0a100 = de0a100;
	}
	public void setCatabolismo(int de0a100){
		balancoAnabolico0a100 = 100 - de0a100;
	}
	public int getAnabolismo(){
		return balancoAnabolico0a100;
	}
	public int getCatabolismo(){
		return 100 - getAnabolismo();
	}
}
