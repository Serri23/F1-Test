package org.example;

public class Neumaticos {

	private MarcaNeumatico marca;
	private float porcentajeDeVida;
	
	public Neumaticos(MarcaNeumatico marca, float porcentajeDeVida) {
		super();
		this.marca = marca;
		this.porcentajeDeVida = porcentajeDeVida;
	}
	
	public MarcaNeumatico getMarca() {
		return marca;
	}
	public void setMarca(MarcaNeumatico marca) {
		this.marca = marca;
	}
	public float getPorcentajeDeVida() {
		return porcentajeDeVida;
	}
	public void setPorcentajeDeVida(float porcentajeDeVida) {
		this.porcentajeDeVida = porcentajeDeVida;
	}
}
