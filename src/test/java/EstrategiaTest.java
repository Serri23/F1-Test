import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.example.Combustible;
import org.example.Estrategia;
import org.example.Neumatico;
import org.example.enums.MarcaNeumaticoEnum;
import org.example.enums.TipoCombustibleEnum;
import org.example.exceptions.DistintaMarcaNeumaticosException;
import org.example.exceptions.DistintoPorcentajeDeVidaNeumaticosException;
import org.example.exceptions.NumeroNeumaticosMayorQueCuatroException;
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
		"0.4833333,	0.3166635, true",  //Clase 1
		"0.4833333,	0.3499999, false", //Clase 2
		"0.4833333,	0.3333333, true",  //Clase 3
		"0.5166666,	0.3166635, false", //Clase 4
		"0.5166666,	0.3499999, false", //Clase 5
		"0.5166666,	0.3333333, false", //Clase 6
		"0.5,		0.3333333, true",  //Clase 7
		"0.5,		0.3166635, true",  //Clase 8
		"0.5,		0.3499999, false", //Clase 9
	})
	void testEsViableParametrizado(float combustiblePorKmRecorrido,float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido,boolean resultado) throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		Estrategia estrategia = generarEstrategia(combustiblePorKmRecorrido,porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido);
		assertEquals(resultado,estrategia.esViable());
	}
	
	@Test
	void unaEstrategiaNoPuedeTenerMasDeCuatroNeumaticos() throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		Combustible combustible = new Combustible(TipoCombustibleEnum.DIESEL,LITROS);
		List<Neumatico> neumaticos = new ArrayList<Neumatico>();
		for(int i = 0 ; i < 5; i++) {
			Neumatico neumatico = new Neumatico(MarcaNeumaticoEnum.PIRELLI, PORCENTAJE_DE_VIDA);
			neumaticos.add(neumatico);
		}
		assertThrows(Exception.class, () -> new Estrategia(combustible, 0, neumaticos, 0, KILOMETROS_A_RECORRER));
	}
	
	@Test
	void unaEstrategiaNoPuedeTenerNeumaticosDeDistintasMarcas() {
		Combustible combustible = new Combustible(TipoCombustibleEnum.DIESEL,LITROS);
		List<Neumatico> neumaticos = new ArrayList<Neumatico>();
		for(int i = 0 ; i < 3; i++) {
			Neumatico neumatico = new Neumatico(MarcaNeumaticoEnum.PIRELLI, PORCENTAJE_DE_VIDA);
			neumaticos.add(neumatico);
		}
		neumaticos.add(new Neumatico(MarcaNeumaticoEnum.BRIDGESTONE, PORCENTAJE_DE_VIDA));
		assertThrows(Exception.class, () -> new Estrategia(combustible, 0, neumaticos, 0, KILOMETROS_A_RECORRER));
	}
	
	@Test
	void unaEstrategiaNoPuedeTenerNeumaticosConPorcentajesDeVidaDistintos() {
		Combustible combustible = new Combustible(TipoCombustibleEnum.DIESEL,LITROS);
		List<Neumatico> neumaticos = new ArrayList<Neumatico>();
		for(int i = 0 ; i < 3; i++) {
			Neumatico neumatico = new Neumatico(MarcaNeumaticoEnum.PIRELLI, PORCENTAJE_DE_VIDA);
			neumaticos.add(neumatico);
		}
		neumaticos.add(new Neumatico(MarcaNeumaticoEnum.PIRELLI, 0f));
		assertThrows(Exception.class, () -> new Estrategia(combustible, 0, neumaticos, 0, KILOMETROS_A_RECORRER));
	}
	
	private Estrategia generarEstrategia(float combustiblePorKmRecorrido, float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido) throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		
		Combustible combustible = new Combustible(TipoCombustibleEnum.DIESEL,LITROS);
		List<Neumatico> neumaticos = new ArrayList<Neumatico>();
		for(int i = 0 ; i < 4; i++) {
			Neumatico neumatico = new Neumatico(MarcaNeumaticoEnum.PIRELLI, PORCENTAJE_DE_VIDA);
			neumaticos.add(neumatico);
		}
		Estrategia estrategia = new Estrategia(combustible,combustiblePorKmRecorrido,neumaticos,porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido,KILOMETROS_A_RECORRER);

		return estrategia;
	}
}
