import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.example.Combustible;
import org.example.DistintaMarcaNeumaticosException;
import org.example.DistintoPorcentajeDeVidaNeumaticosException;
import org.example.Estrategia;
import org.example.MarcaNeumatico;
import org.example.Neumatico;
import org.example.NumeroNeumaticosMayorQueCuatroException;
import org.example.TipoCombustible;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EstrategiaTest {
	
	private final float KILOMETROS_A_RECORRER = 300f;
	
	private final float LITROS = 150f;
	
	private final float PORCENTAJE_DE_VIDA = 100f;
	
	/*
	 * Calculos reales
	 * ===============
	 * combustiblePorKmRecorrido = 0,7l
	 * porcentajeDeVidaConsumidoPorKmRecorrido = 0,43%
	 * kilometrosARecorrer = 305km 
	 * litros = 145l
	 * porcentajeDeVida = 100%
	 */
	
	@ParameterizedTest
	@CsvSource({
		"0.4833333f,	0.3166635, true",  //Clase 1
		"0.4833333f,	0.3499999, false", //Clase 2
		"0.4833333f,	0.3333333, true",  //Clase 3
		"0.5166666f,	0.3166635, false", //Clase 4
		"0.5166666f,	0.3499999, false", //Clase 5
		"0.5166666f,	0.3333333, false", //Clase 6
		"0.5f,			0.3333333, true",  //Clase 7
		"0.5f,			0.3166635, true",  //Clase 8
		"0.5f,			0.3499999, false", //Clase 9
	})
	void testEsViableParametrizado(float combustiblePorKmRecorrido,float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido,boolean resultado) throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		Estrategia estrategia = generarEstrategia(combustiblePorKmRecorrido,porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido);
		assertEquals(resultado,estrategia.esViable());
	}
	
	@Test
	void unaEstrategiaNoPuedeTenerMasDeCuatroNeumaticos() {
		
	}
	
	@Test
	void unaEstrategiaNoPuedeTenerNeumaticosDeDistintasMarcas() {
		
	}
	
	@Test
	void unaEstrategiaNoPuedeTenerNeumaticosConPorcentajesDeVidaNegativos() {
		
	}
	
	private Estrategia generarEstrategia(float combustiblePorKmRecorrido, float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido) throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		
		Combustible combustible = new Combustible(TipoCombustible.DIESEL,LITROS);
		List<Neumatico> neumaticos = new ArrayList<Neumatico>();
		for(int i = 0 ; i < 4; i++) {
			Neumatico neumatico = new Neumatico(MarcaNeumatico.PIRELLI, PORCENTAJE_DE_VIDA);
			neumaticos.add(neumatico);
		}
		Estrategia estrategia = new Estrategia(combustible,combustiblePorKmRecorrido,neumaticos,porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido,KILOMETROS_A_RECORRER);

		return estrategia;
	}
}
