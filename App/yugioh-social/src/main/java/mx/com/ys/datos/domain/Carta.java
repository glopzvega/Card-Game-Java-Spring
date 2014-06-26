package mx.com.ys.datos.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Carta {

	private Integer idcarta;
	private String nombre;
	private String descripcion;
	private Detalles detalles;
//	private int categoria;
//	private int atributo;
//	private int tipo;
//	private int speed;
//	private int level;
//	private int ATK;
//	private int DEF;
//	private boolean effect;
//	private boolean tuner;
	

	public Carta(){		
	}
	
	public Carta(int idcarta){
		this.idcarta = idcarta;
	}	
	
	public Carta(String nombre, String descripcion){
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Carta(String nombre, String descripcion, Detalles detalles){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.detalles = detalles;
	}

	@Id
	//@GeneratedValue
	//@Column(name = "idcarta", unique = true, nullable = false)
	public Integer getIdcarta() {
		return idcarta;
	}

	public void setIdcarta(Integer idcarta) {
		this.idcarta = idcarta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	//@OneToOne(mappedBy = "carta", cascade = CascadeType.ALL /*default, fetch = FetchType.LAZY*/)
	//@Fetch(FetchMode.SELECT)
	@OneToOne(mappedBy = "carta", cascade = CascadeType.ALL)	
	public Detalles getDetalles() {
		return detalles;
	}

	public void setDetalles(Detalles detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Carta [idcarta=" + idcarta + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", detalles=" + detalles
				+ "]";
	}
	
	
	
}