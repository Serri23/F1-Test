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
	
	/*
	 *  
	 * 
	 */
	@ParameterizedTest
	@CsvSource({
		"5f , 5f , true",   //Clase 1
		"5f , -5f, false",  //Clase 2 
		"5f , 0f , true",   //Clase 3
		"-5f, 5f , false",  //Clase 4
		"-5f, -5f, false",  //Clase 5
		"-5f, 0f , false",  //Clase 6
		"0f , 0f , true",   //Clase 7
		"0f , 5f , true",   //Clase 8
		"0f , -5f, false",  //Clase 9
	})
	void testEsViableParametrizado(float litrosRestantes,float porcentajeDeVidaRestante,boolean resultado) throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		Estrategia estrategia = generarEstrategia(litrosRestantes,porcentajeDeVidaRestante);
		assertEquals(resultado,estrategia.esViable());
	}
	
	@Test
	void testCeroCero() throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		//Given
		float litrosRestantes = 5f;
		float porcentajeDeVidaRestante = 5f;
		Estrategia estrategia = generarEstrategia(litrosRestantes,porcentajeDeVidaRestante);

		//When & Then
		assertTrue(estrategia.esViable());
	}
	
	//Clase 1
	@Test
	void testLitrosCombustibleMayorQueCeroYPorcentajeDeVidaNeumaticosMayorQueCero() throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		//Given
		float litrosRestantes = 5f;
		float porcentajeDeVidaRestante = 5f;
		Estrategia estrategia = generarEstrategia(litrosRestantes,porcentajeDeVidaRestante);

		//When & Then
		assertTrue(estrategia.esViable());
	}
	
	//Clase 2
	@Test
	void testLitrosCombustibleMayorQueCeroYPorcentajeDeVidaNeumaticosMenorQueCero() throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		//Given
		float litrosRestantes = 5f;
		float porcentajeDeVidaRestante = -5f;
		Estrategia estrategia = generarEstrategia(litrosRestantes,porcentajeDeVidaRestante);
		
		//When & Then
		assertFalse(estrategia.esViable()); 
	}
	
	//Clase 3
	@Test
	void testLitrosCombustibleMayorQueCeroYPorcentajeDeVidaNeumaticosIgualACero() throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		//Given
		float litrosRestantes = 5f;
		float porcentajeDeVidaRestante = 0f;
		Estrategia estrategia = generarEstrategia(litrosRestantes,porcentajeDeVidaRestante);

		//When & Then
		assertTrue(estrategia.esViable()); 
	}
	
	//Clase 4
	@Test
	void testLitrosCombustibleMenorQueCeroYPorcentajeDeVidaNeumaticosMayorQueCero() throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		//Given
		float litrosRestantes = -5f;
		float porcentajeDeVidaRestante = 5f;
		Estrategia estrategia = generarEstrategia(litrosRestantes,porcentajeDeVidaRestante);

		//When & Then
		assertFalse(estrategia.esViable()); 
	}
	
	//Clase 5
	@Test
	void testLitrosCombustibleMenorQueCeroYPorcentajeDeVidaNeumaticosMenorQueCero() throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		//Given
		float litrosRestantes = -5f;
		float porcentajeDeVidaRestante = -5f;
		Estrategia estrategia = generarEstrategia(litrosRestantes,porcentajeDeVidaRestante);

		//When & Then
		assertFalse(estrategia.esViable()); 
	}
	
	//Clase 6
	@Test
	void testLitrosCombustibleMenorQueCeroYPorcentajeDeVidaNeumaticosIgualACero() throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		//Given
		float litrosRestantes = -5f;
		float porcentajeDeVidaRestante = 0f;
		Estrategia estrategia = generarEstrategia(litrosRestantes,porcentajeDeVidaRestante);

		//When & Then
		assertFalse(estrategia.esViable()); 
	}
	
	//Clase 7
	@Test
	void testLitrosCombustibleIgualACeroYPorcentajeDeVidaNeumaticosIgualACero() throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		//Given
		float litrosRestantes = 0f;
		float porcentajeDeVidaRestante = 0f;
		Estrategia estrategia = generarEstrategia(litrosRestantes,porcentajeDeVidaRestante);

		//When & Then
		assertTrue(estrategia.esViable()); 
	}
	
	//Clase 8
	@Test
	void testLitrosCombustibleIgualACeroYPorcentajeDeVidaNeumaticosMayorQueCero() throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		//Given
		float litrosRestantes = 0f;
		float porcentajeDeVidaRestante = 5f;
		Estrategia estrategia = generarEstrategia(litrosRestantes,porcentajeDeVidaRestante);

		//When & Then
		assertTrue(estrategia.esViable()); 
	}

	//Clase 9
	@Test
	void testLitrosCombustibleIgualACeroYPorcentajeDeVidaNeumaticosMenorQueCero() throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		//Given
		float litrosRestantes = 0f;
		float porcentajeDeVidaRestante = -5f;
		Estrategia estrategia = generarEstrategia(litrosRestantes,porcentajeDeVidaRestante);

		//When & Then
		assertFalse(estrategia.esViable()); 
	}
	
	private Estrategia generarEstrategia(float litrosRestantes, float porcentajeDeVidaRestante) throws NumeroNeumaticosMayorQueCuatroException, DistintaMarcaNeumaticosException, DistintoPorcentajeDeVidaNeumaticosException {
		float combustiblePorKmRecorrido = 0.5f;
		
		float porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido = 0.3333333333333333333333333f;
		
		Combustible combustible = new Combustible(TipoCombustible.DIESEL,litrosRestantes);
		List<Neumatico> neumaticos = new ArrayList<Neumatico>();
		for(int i = 0 ; i < 4; i++) {
			Neumatico neumatico = new Neumatico(MarcaNeumatico.PIRELLI, porcentajeDeVidaRestante);
			neumaticos.add(neumatico);
		}
		Estrategia estrategia = new Estrategia(combustible,combustiblePorKmRecorrido,neumaticos,porcentajeDeVidaDeNeumaticosConsumidoPorKmRecorrido,KILOMETROS_A_RECORRER);

		return estrategia;
	}
}
