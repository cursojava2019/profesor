package es.indra.academia.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ALUMNO")

public class Alumno implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String nif;
	private String telefono;
	private String correo;
	private Boolean repetidor;
	@Column(name = "fechaalta")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date fechaAlta;
	@Column(name = "fechabaja")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date fechaBaja;
	private String observaciones;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Boolean getRepetidor() {
		if (this.repetidor == null) {
			return false;
		} else {
			return this.repetidor;
		}
	}

	public void setRepetidor(Boolean repetidor) {
		this.repetidor = repetidor;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + this.id + ", nombre=" + this.nombre + ", apellido1=" + this.apellido1 + ", apellido2="
				+ this.apellido2 + ", nif=" + this.nif + ", telefono=" + this.telefono + ", correo=" + this.correo
				+ ", repetidor=" + this.repetidor + ", fechaAlta=" + this.fechaAlta + ", fechaBaja=" + this.fechaBaja
				+ ", observaciones=" + this.observaciones + "]";
	}

}
