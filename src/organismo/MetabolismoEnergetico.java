package organismo;


import organismo.metabolismo.Metabolismo;
import tio.ILowEnergyListener;

public class MetabolismoEnergetico implements IMetabolismoEnergetico, Runnable {
	
	protected Energia energia;
	protected ILowEnergyListener tio;
	protected Metabolismo metabolismo;

	
	/**
	 * Threshold [0, 100] é o nivel de "fome" onde o tio começa a perder saúde, até morrer..
	 * @param energiaInicial
	 * @param threshold
	 * @param tio
	 */
	public MetabolismoEnergetico(int energiaInicial, int threshold, ILowEnergyListener tio){
		this.tio = tio;		
		this.energia = initEnergia(energiaInicial, threshold, tio);
		this.metabolismo = Metabolismo.getInstance();
	}
	public Energia initEnergia(int energiaInicial, int threshold, ILowEnergyListener tio){
		Energia energia = new Energia(energiaInicial);
		energia.setThreshold(threshold);
		energia.setLowLevelsCallback(new Energia.LowLevelsCallback() {
			public void lowlevelAction(int level) {
				tio.lowEnergyLevel(level);
			}
		});
		return energia;
	}

	@Override
	public void comer(int calorias) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dormir(int minutos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exercitar(int minutos) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getEnergia() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void run() {
		System.out.println("Iniciando Metabolismo..");
		metabolismo.run();
		
	}
}
