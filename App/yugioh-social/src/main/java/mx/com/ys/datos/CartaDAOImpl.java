package mx.com.ys.datos;

import java.util.List;


import mx.com.ys.datos.domain.Carta;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartaDAOImpl implements CartaDAO {
	
	SessionFactory sessionFactory;
	
	@Autowired
	public CartaDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession(){		
		return sessionFactory.getCurrentSession();
	}
	
	public void insertCarta(Carta carta) {
		currentSession().saveOrUpdate(carta);
	}

	public void updateCarta(Carta carta) {
		currentSession().update(carta);

	}

	public void deleteCarta(Carta carta) {
		currentSession().delete(carta);
	}

	public Carta findCartaById(Integer idCarta) {
		return (Carta) currentSession().get(Carta.class, idCarta);		
	}

	@SuppressWarnings("unchecked")
	public List<Carta> findAllCartas() 	{		
		System.out.println("findAllCartas Method");			
		return currentSession().createQuery("from Carta").list();		
	}

	public long contadorCartas() {
		Long contador = (Long)currentSession().createCriteria(Carta.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		return contador.longValue();
	}

	public Carta getCartaByNombre(Carta carta) {
		Example cartaEjemplo = Example.create(carta);
		return (Carta) currentSession().createCriteria(Carta.class)
				.add(cartaEjemplo).uniqueResult();
	}
}	
