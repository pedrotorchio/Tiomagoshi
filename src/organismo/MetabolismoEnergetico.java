package organismo;


import organismo.metabolismo.Metabolismo;

public class MetabolismoEnergetico implements ServivoComNescessidades {
	
	protected Energia energia;
	protected Metabolismo metabolismo;

	
	/**
	 * Threshold [0, 100] é o nivel de "fome" onde o tio começa a perder saúde, até morrer..
	 * @param energiaInicial
	 * @param threshold
	 * @param tio
	 */
	public MetabolismoEnergetico(){}
	
	public void setEnergia(Energia energia){
		this.energia = energia;
		this.metabolismo = Metabolismo.getInstance(energia);
	}
	
	public void iniciar() throws Exception {
		if(energia == null || metabolismo == null){
			System.out.println("ERRO: "
					+ "Metabolismo Não pode iniciar sem um organismo.Energia. \n"
					+ "Utilizar método setEnergia");
			return;
		}
			
		System.out.println("Iniciando Metabolismo..");
		metabolismo.run();		
	}
	
	
	public void comer(double fatorAnabolico) {
		System.out.println("++" + fatorAnabolico + "% Anabolismo");		
		
		double nivelMet = metabolismo.getAnabolismo();
			   nivelMet = nivelMet + fatorAnabolico;
	
	   metabolismo.setAnabolismo(nivelMet);
	}
	public void dormir(double minutos) {
		catabolismoXtempo(.1, minutos);		
	}
	public void exercitar(double minutos) {
		catabolismoXtempo(1, minutos);
	}
	private void catabolismoXtempo(double taxa, double min){
		
		double nivelMet = metabolismo.getCatabolismo();
			   nivelMet += min * taxa;		
	
		metabolismo.setCatabolismo(nivelMet);
	}

}
