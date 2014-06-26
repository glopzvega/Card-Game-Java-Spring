package mx.com.ys.datos.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Detalles {

	private Integer idcarta;
	private String imagen;
	private String max;
	private Carta carta;
//	private String folio;
//	private String edicion;
//	private String valor;


	public Detalles() {

	}

	public Detalles(String imagen, String max){
		this.imagen = imagen;
		this.max = max;
	}
	
	public Detalles(Carta carta) {
		this.carta = carta;
	}

	//@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "carta"))
	//@GeneratedValue(generator = "generator")
	@Id	
	//@GeneratedValue
	//@Column(name = "idcarta", unique = true, nullable = false)
	public Integer getIdcarta() {
		return idcarta;
	}

	public void setIdcarta(Integer idcarta) {
		this.idcarta = idcarta;
	}

	public String getimagen() {
		return imagen;
	}

	public void setimagen(String imagen) {
		this.imagen = imagen;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	//@OneToOne(fetch = FetchType.LAZY)
	//@PrimaryKeyJoinColumn	
	//@Fetch(FetchMode.SELECT)	default
	@OneToOne
	//@JoinColumn(name="idcarta")
	@PrimaryKeyJoinColumn
	public Carta getCarta() {
		return carta;
	}

	public void setcarta(Carta carta) {
		this.carta = carta;
	}

	@Override
	public String toString() {
		return "Detalles [imagen=" + imagen + ", max=" + max +"]";
	}	

	
	

}
