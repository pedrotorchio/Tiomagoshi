package organismo.metabolismo;

import organismo.Energia;

public class Anabolismo extends Submetabolismo {
	
	
	
	public Anabolismo(Energia energia, Metabolismo metabolismo) {
		super(energia, metabolismo, "Anabolismo");

	}

	
	protected double alteraEnergia(double nivelEnergetico, double nivelMetabolico){
		
		nivelEnergetico += alteracaoLinearEnergia();
			
		
		return nivelEnergetico;	
				
	}
	protected double alteraNivelMetabolico(double nivelMetabolico) {
		return --nivelMetabolico;
	}
	protected void setNivelMetabolico(double nivel) {
		metabolismo.setAnabolismo(nivel);
	}
	protected double getNivelMetabolico() {
		return metabolismo.getAnabolismo();
	}
}
