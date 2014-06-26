package mx.com.ys.service;

import java.util.List;

import mx.com.ys.datos.CartaDAO;
import mx.com.ys.datos.domain.Carta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cartaService")
@Transactional
public class CartaServiceImpl implements CartaService {

	@Autowired
	private CartaDAO cartaDAO;
	
	public List<Carta> listarCartas() {
		return cartaDAO.findAllCartas();
	}

	public Carta recuperarCarta(Carta carta) {
		return cartaDAO.findCartaById(carta.getIdcarta());
	}

	public void agregarCarta(Carta carta) {
		cartaDAO.insertCarta(carta);
	}

	public void modificarCarta(Carta carta) {
		cartaDAO.updateCarta(carta);
	}

	public void eliminarCarta(Carta carta) {
		cartaDAO.deleteCarta(carta);
	}

}
