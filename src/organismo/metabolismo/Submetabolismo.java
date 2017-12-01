package organismo.metabolismo;

import java.util.Timer;
import java.util.TimerTask;

import organismo.Energia;

public abstract class Submetabolismo extends TimerTask{
	
	protected Energia energia;
	protected Metabolismo metabolismo;
	protected int energiaPasso = 10; // o quanto altera caso metabolismo esteja a 100%
	
	public Submetabolismo(Energia energia, Metabolismo metabolismo){
		this.energia = energia;
		this.metabolismo = metabolismo;
	}
	public void start(){
		Timer timer = new Timer(true);
		  	  timer.scheduleAtFixedRate(this, 0, Metabolismo.periodo);
	}
	public final void run(){
		inicioDeCiclo();
		
		energia.setNivel(
				alteraEnergia(
						energia.getNivel(), getNivelMetabolico()));
		setNivelMetabolico(
				alteraNivelMetabolico(
						getNivelMetabolico()));
		
		fimDeCiclo();
	}
	protected abstract int alteraNivelMetabolico(int nivelMetabolico);
	protected abstract int alteraEnergia(int energiaAtual, int nivelMetabolico);
	
	protected abstract void setNivelMetabolico(int nivel);
	protected abstract int getNivelMetabolico();
	
	protected void fimDeCiclo(){};
	protected void inicioDeCiclo(){};
}
