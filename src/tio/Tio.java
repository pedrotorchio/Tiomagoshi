package tio;

import gui.FrameTiogotchi;
import organismo.Energia;
import organismo.Energia.EnergyLevelListener;
import organismo.MetabolismoEnergetico;
import organismo.Saude;
import organismo.Saude.HealthLevelListener;
import organismo.ServivoComNescessidades;

public class Tio implements ServivoComNescessidades, EnergyLevelListener, HealthLevelListener{
	private FrameTiogotchi gui;
	private MetabolismoEnergetico mEnergetico;
	private Saude life;
	
	public static void main(String[] args) {
		FrameTiogotchi gui = new FrameTiogotchi();
		MetabolismoEnergetico mEnergetico = new MetabolismoEnergetico();
		Saude life = new Saude();
		Energia energia = new Energia();
		Tio tio = new Tio();
		
		
		mEnergetico.setEnergia(energia);
		
		gui.setTio(tio);
		
		tio.setMetabolismoEnergetico(mEnergetico);
		tio.setGui(gui);
		tio.setSaude(life);
		
		energia.setNivel(1400);
		energia.setThreshold(1000);
		energia.setEnergyLevelUpdateCallback(tio);
		energia.setLowEnergyLevelCallback(tio);

		life.setHealthLevelUpdateCallback(tio);
		life.setLowHealthLevelCallback(tio);
		life.setNivel(2000);

		
		tio.start();
		
	}
	public void start(){
		mEnergetico.start();
		gui.setVisible(true);
	}
	public Tio(){}
	public void setSaude(Saude life){
		this.life = life;
	}
	public void setMetabolismoEnergetico(MetabolismoEnergetico m){
		this.mEnergetico = m;
	}
	public void setGui(FrameTiogotchi gui){
		this.gui = gui;
	}
	
	@Override
	public void comer(double fatorAnabolico) {
		mEnergetico.comer(fatorAnabolico);
	}

	@Override
	public void dormir(double minutos) {
		double currLife = life.getNivel();
			   currLife += minutos/60 * Saude.MAX_SAUDE * .01; 
			   System.out.println(currLife);
			   life.setNivel(currLife);
			   
			   mEnergetico.dormir(minutos);
	}

	@Override
	public void exercitar(double minutos) {

		double currLife = life.getNivel();
		   currLife += minutos/60 * Saude.MAX_SAUDE * .1; 
		   life.setNivel(currLife);
		   
		   mEnergetico.exercitar(minutos);
	}

	
	public synchronized void lowEnergylevelAction(double level, int max, int min) {
		
		gui.setFome(true);
		
		
		double curr = life.getNivel();
			   curr = curr - (Saude.MAX_SAUDE - Saude.MIN_SAUDE)/100;
			   
		life.setNivel(curr);
	}

	public synchronized void energyLevelUpdate(double level, int max, int min) {
		
		double percent = level*100/(max-min);	
		gui.setEnergiaLvl(percent);
		
		gui.setFome(false);
	}
	@Override
	public void lowHealthlevelAction(double level, int max, int min) {
		if(level == 0)
			gui.setMorto();	
	}
	@Override
	public void healthLevelUpdate(double level, int max, int min) {
		double percent = level*100/max;	
		
		int humor = -1;
		
		if(percent > 95)
			humor = FrameTiogotchi.HUMOR_FELIZ;
		else if (percent > 50)
			humor = FrameTiogotchi.HUMOR_OK;
		else 
			humor = FrameTiogotchi.HUMOR_TRISTE;
		
		gui.setHumor(humor);
		gui.setSaudeLvl(percent);
	}

}
