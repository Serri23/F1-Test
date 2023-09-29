package org.example;

import org.example.enums.MarcaNeumaticoEnum;

public class Neumatico {

	private MarcaNeumaticoEnum marca;
	private float porcentajeDeVida;
	
	public Neumatico(MarcaNeumaticoEnum marca, float porcentajeDeVida) {
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
	public MarcaNeumaticoEnum getMarca() {
		return marca;
	}
}
