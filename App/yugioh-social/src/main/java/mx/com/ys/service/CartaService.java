package mx.com.ys.service;

import java.util.List;

import mx.com.ys.datos.domain.Carta;

public interface CartaService {

	public List<Carta> listarCartas();
	
	public Carta recuperarCarta(Carta Carta);
	
	public void agregarCarta(Carta Carta);
	
	public void modificarCarta(Carta Carta);

	public void eliminarCarta(Carta Carta);
	
}
