package organismo.metabolismo;

import organismo.Energia;

public class Metabolismo implements Runnable{
	public static final int PERIODO = 500;
	
	public static final int MAX_NIVEL= 100;
	public static final int MIN_NIVEL= 0;
	protected static Metabolismo instance = null;
	Energia energia;
	
	Anabolismo anabolismo;
	Catabolismo catabolismo;
	
	private double balancoAnabolico0a100 = 80; 
	
	
	
	private Metabolismo(){}
	public static Metabolismo getInstance(Energia energia){
		if(instance == null)
			instance = new Metabolismo();
		
		instance.setEnergia(energia);
		
		return instance;
	}
	public void run(){
		(catabolismo = new Catabolismo(energia, this)).start();
		(anabolismo  = new Anabolismo(energia, this)).start();
	}
	public void setEnergia(Energia energia){
		this.energia = energia;
	}
	
	public void setAnabolismo(double nivel){
		nivel = keepWithinRange(nivel);
		balancoAnabolico0a100 = nivel;
	}
	public void setCatabolismo(double nivel){
		nivel = keepWithinRange(nivel);
		
		balancoAnabolico0a100 = 100 - nivel;
	}
	public double getAnabolismo(){
		return balancoAnabolico0a100;
	}
	public double getCatabolismo(){
		return 100 - getAnabolismo();
	}
	public double keepWithinRange(double value){
		// mantém entre max e min
		value = Math.min(MAX_NIVEL, Math.max(MIN_NIVEL, value));
		
		return value;
	}
}
