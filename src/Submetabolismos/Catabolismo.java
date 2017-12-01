package Submetabolismos;

import metabolismo.Energia;

public class Catabolismo extends AbsSubmetabolismo {

	public Catabolismo(Energia energia) {
		super(energia);
	}

	public void loop() {
		System.out.println("anabolismo loop");
	}

}
