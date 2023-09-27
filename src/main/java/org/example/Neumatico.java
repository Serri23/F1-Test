package org.example;

public class Neumatico {

	private MarcaNeumatico marca;
	private float porcentajeDeVida;
	
	public Neumatico(MarcaNeumatico marca, float porcentajeDeVida) {
		super();
		this.marca = marca;
		this.porcentajeDeVida = porcentajeDeVida;
	}
	public float getPorcentajeDeVida() {
		return porcentajeDeVida;
	}
	public void setPorcentajeDeVida(float porcentajeDeVida) {
		this.porcentajeDeVida = porcentajeDeVida;
	}
	public MarcaNeumatico getMarca() {
		return marca;
	}
}
