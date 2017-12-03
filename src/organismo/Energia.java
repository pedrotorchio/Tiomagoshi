package organismo;

public class Energia {
	double nivel = 1000;
	int threshold = 500;
	
	LowEnergyLevelListener llCallback = null;
	EnergyLevelUpdateListener elCallback = null;
	
	final int MAX_ENERGIA = 2500;	
	final int MIN_ENERGIA = 0;
	
	public Energia(){}
	
	public void setThreshold(int th){
		this.threshold = th;
	}
	public void setLowEnergyLevelCallback(LowEnergyLevelListener cb){
		this.llCallback = cb;
	}
	public void setEnergyLevelUpdateCallback(EnergyLevelUpdateListener cb){
		this.elCallback = cb;
	}
	public void setNivel(double nivel){
		nivel = Math.min(MAX_ENERGIA, Math.max(MIN_ENERGIA, nivel));
		
		if(this.elCallback != null)
			this.elCallback.energyLevelUpdate(nivel);
		if(nivel < threshold && this.llCallback != null)
			this.llCallback.lowEnergylevelAction(nivel);
		
		
		this.nivel = nivel;
	}
	public double getNivel(){
		return this.nivel;
	}
	
	public static interface LowEnergyLevelListener{
		public void lowEnergylevelAction(double level);
	}
	public static interface EnergyLevelUpdateListener{
		public void energyLevelUpdate(double level);
	}
	public static interface EnergyLevelListener extends LowEnergyLevelListener, EnergyLevelUpdateListener{}
}
