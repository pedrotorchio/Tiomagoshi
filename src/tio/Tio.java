package tio;

import gui.FrameTiogotchi;
import organismo.Energia;
import organismo.Energia.EnergyLevelListener;
import organismo.MetabolismoEnergetico;
import organismo.ServivoComNescessidades;

public class Tio implements ServivoComNescessidades, EnergyLevelListener{
	private FrameTiogotchi gui;
	private MetabolismoEnergetico mEnergetico;
	
	public static void main(String[] args) {
		FrameTiogotchi gui = new FrameTiogotchi();
		MetabolismoEnergetico mEnergetico = new MetabolismoEnergetico();
		Energia energia = new Energia();
		Tio tio = new Tio();
		
		
		mEnergetico.setEnergia(energia);
		
		
		tio.setMetabolismoEnergetico(mEnergetico);
		tio.setGui(gui);
		
		energia.setNivel(1200);
		energia.setThreshold(600);
		energia.setEnergyLevelUpdateCallback(tio);
		energia.setLowEnergyLevelCallback(tio);
		
		tio.start();
		
	}
	public void start(){
		mEnergetico.start();
		gui.setVisible(true);
	}
	public Tio(){}
	public void setMetabolismoEnergetico(MetabolismoEnergetico m){
		this.mEnergetico = m;
	}
	public void setGui(FrameTiogotchi gui){
		this.gui = gui;
	}
	@Override
	public void comer(double fatorAnabolico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dormir(double minutos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exercitar(double minutos) {
		// TODO Auto-generated method stub
		
	}

	
	public synchronized void lowEnergylevelAction(double level, int max, int min) {
		gui.setHumor(gui.HUMOR_FAMINTO);
	}

	public synchronized void energyLevelUpdate(double level, int max, int min) {
		
		double percent = level*100/max;	
		gui.setEnergiaLvl(percent);
	}

}
