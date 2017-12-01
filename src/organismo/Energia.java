package organismo;

public class Energia {
	int nivel = 100;
	int threshold = 60;
	LowLevelsCallback llCallback = null;
	
	final int MAX_ENERGIA = 2500;	
	final int MIN_ENERGIA = 0;
	
	public Energia(int nivel){
		setNivel(nivel);
	}
	
	public void setThreshold(int th){
		this.threshold = th;
	}
	public void setLowLevelsCallback(LowLevelsCallback cb){
		this.llCallback = cb;
	}
	public void setNivel(int nivel){
		if(nivel > MAX_ENERGIA)
			nivel = MAX_ENERGIA;
		else 
			if(nivel < MIN_ENERGIA)
				nivel = MIN_ENERGIA;
		
		if(nivel < threshold)
			this.llCallback.lowlevelAction(nivel);
		
		
		this.nivel = nivel;
	}
	public int getNivel(){
		return this.nivel;
	}
	
	public static interface LowLevelsCallback{
		public void lowlevelAction(int level);
	}
}
