package org.example;

import org.example.enums.TipoCombustibleEnum;

public class Combustible {
	
	private TipoCombustibleEnum tipoCombustible;
	private float litros;
	
	public Combustible(TipoCombustibleEnum tipoCombustible, float litros) {
		super();
		this.tipoCombustible = tipoCombustible;
		this.litros = litros;
	}
	
	public float getLitros() {
		return litros;
	}

	public void setLitros(float litros) {
		this.litros = litros;
	}	
}
