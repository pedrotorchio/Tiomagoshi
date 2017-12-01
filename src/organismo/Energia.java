package organismo;

public class Energia {
	int nivel = 100;
	int threshold = 60;
	LowLevelsCallback llCallback = null;
	
	public Energia(int nivel){
		this.nivel = nivel;
	}
	
	public void setThreshold(int th){
		this.threshold = th;
	}
	public void setLowLevelsCallback(LowLevelsCallback cb){
		this.llCallback = cb;
	}
	public void setNivel(int nivel){
		
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
