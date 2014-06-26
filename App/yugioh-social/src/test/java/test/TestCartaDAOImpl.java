package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import mx.com.ys.datos.CartaDAO;
import mx.com.ys.datos.domain.Carta;

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

public class TestCartaDAOImpl {
	private static Log logger = LogFactory.getLog("TestcartaDAOImpl");

	@Autowired
	CartaDAO cartaDAO;

	@Test
	@Transactional
	@Ignore
	public void deberiaMostrarCartas() {
		try {
			logger.info("Inicio del test deberiaMostrarCartas");
			List<Carta> cartas = cartaDAO.findAllCartas();
			int contadorCartas = 0;
			for (Carta carta : cartas) {
				logger.info("Carta: " + carta);
				contadorCartas++;
			}
			assertEquals(contadorCartas, cartaDAO.contadorCartas());
			// logger.info(contadorCartas);
			logger.info("Fin del test deberiaMostrarCartas");
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}

	@Test
	@Transactional
	@Ignore
	public void deberiaMostrarCartasById() {
		Integer idCarta = 1;
		Carta carta = cartaDAO.findCartaById(idCarta);
		logger.info("Carta recuperada: " + carta);
	}

	@Test
	@Transactional
	@Ignore
	public void deberiaInsertarCarta() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaInsertarCarta");

			Carta carta = new Carta();
			carta.setNombre("Ejemplo Carta 3");
			carta.setDescripcion("Ejemplo Carta 3");
			cartaDAO.insertCarta(carta);
			// Recuperamos a la Carta recien insertada por su email
			carta = cartaDAO.getCartaByNombre(carta);
			logger.info("Carta insertada: " + carta);
			// Deberia haber ya cuatro Cartas

			logger.info("Fin del test deberiaInsertarCarta");
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}

	@Test
	@Transactional
	@Ignore
	public void deberiaActualizarCarta() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaActualizarCarta");
			int idCarta = 1;
			
			Carta carta = cartaDAO.findCartaById(idCarta);
			
			logger.info("Carta a modificar (id=" + idCarta + "): "
					+ carta);
			
			carta.setNombre("Carta Actualizada");											
			cartaDAO.updateCarta(carta);
			
			carta = cartaDAO.findCartaById(idCarta);			
			
			logger.info("Carta  modificada  (id=" + idCarta + "):  "
					+ carta);
			
			logger.info("Fin del test deberiaActualizarCarta");
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}
	
	@Test
	@Transactional
	//@Ignore
	public void deberiaEliminarPersona() {
		try {
			
			logger.info("Inicio del test deberiaEliminarPersona");
			int idCarta = 2;
			Carta carta = cartaDAO.findCartaById(idCarta);
			logger.info("Persona a eliminar (id=" + idCarta + "): " + carta);
			cartaDAO.deleteCarta(carta);
			carta = cartaDAO.findCartaById(idCarta);
			assertNull(carta);
			logger.info("Nuevo listado de personas:");
			List<Carta> personas = cartaDAO.findAllCartas();
			int contadorPersonas = 0;
			for (Carta persona2 : personas) {
				logger.info("Persona: " + persona2);
				contadorPersonas++;
			}
			assertEquals(contadorPersonas, cartaDAO.contadorCartas());
			logger.info("Fin del test deberiaEliminarPersona");
			System.out.println();
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}
}

