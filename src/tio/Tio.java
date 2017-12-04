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
		
		mEnergetico.setEnergia(energia);
		
		Tio tio = new Tio(gui, mEnergetico);
		
		energia.setEnergyLevelUpdateCallback(tio);
		energia.setLowEnergyLevelCallback(tio);
		
		mEnergetico.start();
		

	}
	public Tio(FrameTiogotchi gui, MetabolismoEnergetico mEnergetico){
		this.gui = gui;
		this.mEnergetico = mEnergetico;
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

	
	public synchronized void lowEnergylevelAction(double level) {
				
	}

	public synchronized void energyLevelUpdate(double level) {
		System.out.println("Energia:" + level);		
		
	}

}
