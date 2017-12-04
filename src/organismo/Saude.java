package organismo;

public class Saude {
	double nivel = 1000;
	int threshold = 500;
	
	LowHealthLevelListener llCallback = null;
	 healthLevelUpdateListener elCallback = null;
	
	final int MAX_SAUDE = 2500;	
	final int MIN_SAUDE = 0;
	
	public Saude(){}
	
	public void setThreshold(int th){
		this.threshold = th;
	}
	public void setLowHealthLevelCallback(LowHealthLevelListener cb){
		this.llCallback = cb;
	}
	public void setHealthLevelUpdateCallback( healthLevelUpdateListener cb){
		this.elCallback = cb;
	}
	public void setNivel(double nivel){
		nivel = Math.min(MAX_SAUDE, Math.max(MIN_SAUDE, nivel));
		
		if(this.elCallback != null)
			this.elCallback.healthLevelUpdate(nivel, MAX_SAUDE, MIN_SAUDE);
		if(nivel < threshold && this.llCallback != null)
			this.llCallback.lowHealthlevelAction(nivel, MAX_SAUDE, MIN_SAUDE);
		
		
		this.nivel = nivel;
	}
	public double getNivel(){
		return this.nivel;
	}
	
	public static interface LowHealthLevelListener{
		public void lowHealthlevelAction(double level, int max, int min);
	}
	public static interface healthLevelUpdateListener{
		public void healthLevelUpdate(double level, int max, int min);
	}
	public static interface healthLevelListener extends LowHealthLevelListener, healthLevelUpdateListener{}
}
