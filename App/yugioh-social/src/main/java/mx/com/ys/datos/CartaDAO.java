package mx.com.ys.datos;

import java.util.List;
import mx.com.ys.datos.domain.Carta;

public interface CartaDAO {		

	void insertCarta(Carta carta);

	void updateCarta(Carta carta);

	void deleteCarta(Carta carta);

	Carta findCartaById(Integer idCarta);

	List<Carta> findAllCartas();

	long contadorCartas();

	Carta getCartaByNombre(Carta carta);

}
