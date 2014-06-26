package test;

import java.util.List;

import mx.com.ys.datos.CartaDAO;
import mx.com.ys.datos.domain.Carta;
import mx.com.ys.service.CartaService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:datasource-test.xml",
		"classpath:applicationContext.xml" })
public class TestCartaServiceImpl {

	private static Log logger = LogFactory.getLog("TestCartaServiceImpl");
	
	@Autowired
	private CartaService cartaService;
	
	@Autowired
	private CartaDAO cartaDAO;

	@Test
	@Transactional
	@Ignore
	public void deberiaMostrarCartas() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaMostrarCartas");
			int contadorCartas = this.desplegarCartas();

			assertEquals(contadorCartas, cartaDAO.contadorCartas());
			logger.info("Fin del test deberiaMostrarCartas");
			System.out.println();
		} catch (Exception e) {
			logger.error("Error Servicio", e);
		}
	}

	private int desplegarCartas() {
		List<Carta> cartas = cartaService.listarCartas();
		int contadorCartas = 0;
		for (Carta carta : cartas) {
			logger.info("Carta: " + carta);
			contadorCartas++;
		}
		return contadorCartas;
	}

	@Test
	@Transactional
	//@Ignore
	public void testOperaciones() {
		try {
			System.out.println();
			logger.info("Inicio del test testOperaciones");
			
			Carta Carta1 = new Carta();			
			Carta1.setNombre("Andrea");		
			Carta1.setDescripcion("Andrea");
			cartaService.agregarCarta(Carta1);
			
			Carta Carta2 = cartaService.recuperarCarta(new Carta(1));
			Carta2.setNombre("Administrador");
			cartaService.modificarCarta(Carta2);
			this.desplegarCartas();
			
			logger.info("Fin del test testOperaciones");
			System.out.println();
		} catch (Exception e) {
			logger.error("Error Servicio", e);
		}
	}

	@Test
	@Transactional
	@Ignore
	public void testCompruebaOperaciones() {
		try {
			System.out.println();
			logger.info("Fin del test testCompruebaOperaciones");
			assertEquals(2, cartaDAO.contadorCartas());
			this.desplegarCartas();
			logger.info("Fin del test testCompruebaOperaciones");
			System.out.println();
		} catch (Exception e) {
			logger.error("Error Servicio", e);
		}
	}
}
