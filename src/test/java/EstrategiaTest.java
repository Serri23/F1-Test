import static org.junit.jupiter.api.Assertions.*;

import org.example.Combustible;
import org.example.Estrategia;
import org.example.MarcaNeumatico;
import org.example.Neumaticos;
import org.example.TipoCombustible;
import org.junit.jupiter.api.Test;

class EstrategiaTest {

	private final float combustiblePorKmRecorrido = 2.5f;
	
	//66 vueltas => 305km
	//230km consumen el 100% de vida de los neumaticos
	//1km consumen el 0,43% de vida de los neumaticos
	private final float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido = 0.43f;
	
	private final float kilometrosARecorrer = 305f;
	
	private final float litros = 762.5f;
	
	private final float porcentajeDeVida = 100f;
	
	
	//Probar segun el tipo de combustible y neumaticos
	//Probar cambiando limites de litros de combustible y porcentaje de vida
	//DUDA: Si las clases tienen que tener 20 o menos lineas, la clase estrategia
	//habria que modificarla para que solo se use o constructor o getter/setter
	@Test
	void esViableTest() {
		//Given
		Combustible combustible = new Combustible(TipoCombustible.DIESEL,litros);
		Neumaticos neumaticos = new Neumaticos(MarcaNeumatico.PIRELLI, porcentajeDeVida);
		Estrategia estrategia = new Estrategia(combustible,combustiblePorKmRecorrido,neumaticos,porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido,kilometrosARecorrer);
		
		//When & Then
		assertTrue(estrategia.esViable());
	}
}
