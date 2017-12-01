package tio;

import gui.ISerVivoNoMundo;
import organismo.IMetabolismoEnergetico;

public class Tio implements ISerVivo, ILowEnergyListener{
	
	IMetabolismoEnergetico metEnergetico;
	ISerVivoNoMundo gui;
	
	public static void main(String[] args) {
		// criar objeto tio
		// criar objeto metabolismoenergetico e passar energia inicial, threshold e o proprio objeto tio
		// criar objeto interface grafica TioProMundo (eu devia ter planejado isso melhor haha)
		
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
	public void lowEnergyLevel(int level) {
		// Isso aqui vai ser chamado automaticamente sempre que os niveis de energia passarem um valor threshold
	}

}
