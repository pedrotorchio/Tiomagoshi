package organismo.metabolismo;

import organismo.Energia;

public class Catabolismo extends Submetabolismo {

	public Catabolismo(Energia energia, Metabolismo metabolismo) {
		super(energia, metabolismo, "Catabolismo");
	}

	
	protected double alteraEnergia(double nivelEnergetico, double nivelMetabolico){

		nivelEnergetico -= alteracaoLinearEnergia();
		
		return nivelEnergetico;	
				
	}
	protected double alteraNivelMetabolico(double nivelMetabolico) {
		return ++nivelMetabolico;
	}
	protected void setNivelMetabolico(double nivel) {
		metabolismo.setCatabolismo(nivel);
	}
	protected double getNivelMetabolico() {
		return metabolismo.getCatabolismo();
	}

}
