package Submetabolismos;

import metabolismo.Energia;

public class Anabolismo extends AbsSubmetabolismo {
	
	public Anabolismo(Energia energia) {
		super(energia);

	}

	
	public void loop() {
		System.out.println("anabolismo loop");
		
	}

}
