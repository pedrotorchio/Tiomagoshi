package organismo.metabolismo;

import java.util.Timer;
import java.util.TimerTask;

import organismo.Energia;

public abstract class Submetabolismo extends TimerTask{
	
	protected Energia energia;
	protected Metabolismo metabolismo;
	protected int energiaPasso = 50; // o quanto altera caso metabolismo esteja a 100%
	protected String titulo = "Submetabolismo";
	protected boolean cycleInfo = false;
	
	public Submetabolismo(Energia energia, Metabolismo metabolismo, String titulo){
		this(energia, metabolismo);
		this.titulo = titulo;		
	}
	public Submetabolismo(Energia energia, Metabolismo metabolismo){
		this.energia = energia;
		this.metabolismo = metabolismo;
	}
	
	public void start(){
		Timer timer = new Timer(true);
		  	  timer.scheduleAtFixedRate(this, 0, Metabolismo.PERIODO);
	}
	public final void run(){
		synchronized(metabolismo){
			inicioDeCiclo();
			double nrg = alteraEnergia(
					energia.getNivel(), getNivelMetabolico());
			
			energia.setNivel(nrg);
			setNivelMetabolico(
					alteraNivelMetabolico(
							getNivelMetabolico()));
			
			fimDeCiclo();	
		}
	}
	protected double alteracaoLinearEnergia(){
		double metab = getNivelMetabolico();
		double mPer100 = metab/100;
		double cStep   = mPer100 * energiaPasso;
		
		return cStep;
	}
	protected abstract double alteraNivelMetabolico(double nivelMetabolico);
	protected abstract double alteraEnergia(double energia, double nivelMetabolico);
	
	protected abstract void setNivelMetabolico(double nivel);
	protected abstract double getNivelMetabolico();
	protected void setCycleInfo(boolean bool){
		cycleInfo = bool;
	}
	protected void fimDeCiclo(){
		if(cycleInfo)
			System.out.println(toString());
	};
	protected void inicioDeCiclo(){};
	public String toString(){
		return String.format(
					  "<%s>\n"
					+ "Energia:%f\n"
					+ "Metabolismo:%f\n"
					+ "</%s>\n"
				
					,titulo, energia.getNivel(), getNivelMetabolico(), titulo);
	}
}
