package org.example;

public class Estrategia {
	private final Combustible combustible;
	private final float combustiblePorKmRecorrido;
	private final Neumaticos neumaticos;
	private float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido;
	private float kilometrosARecorrer;
	
	public Estrategia(Combustible combustible, float combustiblePorKmRecorrido, Neumaticos neumaticos,
			float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido, float kilometrosARecorrer) {
		super();
		this.combustible = combustible;
		this.combustiblePorKmRecorrido = combustiblePorKmRecorrido;
		this.neumaticos = neumaticos;
		this.porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido = porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido;
		this.kilometrosARecorrer = kilometrosARecorrer;
	}

	public float getPorcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido() {
		return porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido;
	}
	public float getKilometrosARecorrer() {
		return kilometrosARecorrer;
	}
	public Combustible getCombustible() {
		return combustible;
	}
	public float getCombustiblePorKmRecorrido() {
		return combustiblePorKmRecorrido;
	}
	public Neumaticos getNeumaticos() {
		return neumaticos;
	}
	
	public boolean esViable() {
		boolean viable = false;
		calcularRecursos();
		if(this.getCombustible().getLitros() >= 0f 
				&&  this.getNeumaticos().getPorcentajeDeVida() >= 0f) {
			viable = true;
		}
		return viable;
	}
	
	private void calcularRecursos() {
		float litros = this.getCombustible().getLitros() - (this.getCombustiblePorKmRecorrido() * this.getKilometrosARecorrer());
		float porcentajeVidaNeumaticos= this.getNeumaticos().getPorcentajeDeVida() - (this.getPorcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido() * this.getKilometrosARecorrer());
		this.getCombustible().setLitros(litros);
		this.getNeumaticos().setPorcentajeDeVida(porcentajeVidaNeumaticos);
	}
}
