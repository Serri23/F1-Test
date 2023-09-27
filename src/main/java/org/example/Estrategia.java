package org.example;

import java.util.List;

public class Estrategia {
	private final Combustible combustible;
	private final float combustiblePorKmRecorrido;
	private final List<Neumatico> neumaticos;
	private float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido;
	private float kilometrosARecorrer;
	
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
	public List<Neumatico> getNeumaticos() {
		return neumaticos;
	}
	
	public Estrategia(Combustible combustible, float combustiblePorKmRecorrido, List<Neumatico> neumaticos,
			float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido, float kilometrosARecorrer) throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		super();
		this.combustible = combustible;
		this.combustiblePorKmRecorrido = combustiblePorKmRecorrido;
		if(neumaticos.size() > 4) throw new NumeroNeumaticosMayorQueCuatroException();
		if(!comprobarMarcaNeumaticos(neumaticos,neumaticos.get(0).getMarca())) throw new DistintaMarcaNeumaticosException();
		if(!comprobarPorcentajeDeVidaNeumaticos(neumaticos,neumaticos.get(0).getPorcentajeDeVida())) throw new DistintoPorcentajeDeVidaNeumaticosException();
		this.neumaticos = neumaticos;
		this.porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido = porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido;
		this.kilometrosARecorrer = kilometrosARecorrer;
	}

	private boolean comprobarMarcaNeumaticos(List<Neumatico> neumaticos, MarcaNeumatico marca) {
		boolean resultado = false;
		for(Neumatico neumatico : neumaticos) {
			if(neumatico.getMarca().equals(marca)) {
				resultado = true;
			}else {
				resultado = false;
			}
		}
		return resultado;
	}

	private boolean comprobarPorcentajeDeVidaNeumaticos(List<Neumatico> neumaticos, float porcentajeDeVida) {
		boolean resultado = false;
		for(Neumatico neumatico : neumaticos) {
			if(neumatico.getPorcentajeDeVida() == (porcentajeDeVida)) resultado = true;
		}
		return resultado;
	}
	
	public boolean esViable() {
		boolean viable = false;
		calcularRecursos();
		if(this.getCombustible().getLitros() >= 0f 
				&&  this.getNeumaticos().get(0).getPorcentajeDeVida() >= 0f) {
			viable = true;
		}
		return viable;
	}
	
	private void calcularRecursos() {
		float litros = this.getCombustible().getLitros() - (this.getCombustiblePorKmRecorrido() * this.getKilometrosARecorrer());
		float porcentajeVidaNeumaticos= this.getNeumaticos().get(0).getPorcentajeDeVida() - (this.getPorcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido() * this.getKilometrosARecorrer());
		this.getCombustible().setLitros(litros);
		for(Neumatico neumatico : this.getNeumaticos()) {
			neumatico.setPorcentajeDeVida(porcentajeVidaNeumaticos);
		}
	}
}
