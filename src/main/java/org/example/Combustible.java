package org.example;

public class Combustible {
	
	private TipoCombustible tipoCombustible;
	private float litros;
	
	public Combustible(TipoCombustible tipoCombustible, float litros) {
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

	public TipoCombustible getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(TipoCombustible tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}	
}
