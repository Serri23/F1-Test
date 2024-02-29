package org.example;

import java.util.List;

import org.example.exceptions.DistintaMarcaNeumaticosException;
import org.example.exceptions.DistintoPorcentajeDeVidaNeumaticosException;
import org.example.exceptions.NumeroNeumaticosMayorQueCuatroException;
import org.example.utils.EstrategiaUtil;

public class Estrategia extends EstrategiaOrigen{
	public Estrategia(Combustible combustible, float combustiblePorKmRecorrido, List<Neumatico> neumaticos,
			float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido, float kilometrosARecorrer) throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		super(combustible,combustiblePorKmRecorrido,neumaticos,porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido,kilometrosARecorrer);
		if(neumaticos.size() > 4) throw new NumeroNeumaticosMayorQueCuatroException();
		if(!EstrategiaUtil.comprobarMarcaNeumaticos(neumaticos,neumaticos.get(0).getMarca())) throw new DistintaMarcaNeumaticosException();
		if(!EstrategiaUtil.comprobarPorcentajeDeVidaNeumaticos(neumaticos,neumaticos.get(0).getPorcentajeDeVida())) throw new DistintoPorcentajeDeVidaNeumaticosException();	
	}
	
	public boolean esViable() {
		EstrategiaUtil.calcularRecursos(this);
		if(this.getCombustible().getLitros() >= 0f 
				&&  this.getNeumaticos().get(0).getPorcentajeDeVida() >= 0f) {
			return true;
		}
		return false;
	}
}
