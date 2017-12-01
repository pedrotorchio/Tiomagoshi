package organismo.metabolismo;

import organismo.Energia;

public class Anabolismo extends Submetabolismo {
	
	public Anabolismo(Energia energia, Metabolismo metabolismo) {
		super(energia, metabolismo);

	}

	
	protected int alteraEnergia(int nivelEnergetico, int nivelMetabolico){
		nivelEnergetico += (nivelMetabolico/100) * energiaPasso;
		
		return nivelEnergetico;
	}
	protected int alteraNivelMetabolico(int nivelMetabolico) {
		return --nivelMetabolico;
	}
	protected void setNivelMetabolico(int nivel) {
		metabolismo.setAnabolismo(nivel);
	}
	protected int getNivelMetabolico() {
		return metabolismo.getAnabolismo();
	}

}
