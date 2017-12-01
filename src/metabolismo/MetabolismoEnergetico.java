package metabolismo;

import tio.ILowEnergyListener;

public class MetabolismoEnergetico implements IMetabolismoEnergetico {
	
	protected Energia energia;
	protected ILowEnergyListener tio;
	public MetabolismoEnergetico(int energiaInicial, int threshold, ILowEnergyListener tio){
		this.tio = tio;
		initEnergia(energiaInicial, threshold, tio);
	}
	public void initEnergia(int energiaInicial, int threshold, ILowEnergyListener tio){
		energia = new Energia(energiaInicial);
		energia.setThreshold(threshold);
		energia.setLowLevelsCallback(new Energia.LowLevelsCallback() {
			public void lowlevelAction(int level) {
				tio.lowEnergyLevel(level);
			}
		});
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

}
