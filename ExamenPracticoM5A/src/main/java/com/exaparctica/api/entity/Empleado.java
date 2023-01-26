package com.exaparctica.api.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable {


private static final long serialVersionUID = 4626912300073047023L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(length = 45,nullable=false)
	@Size(min=1,max=45,message="El numero de caracteres debe ser como maximo 45 caracteres")
	@NotEmpty(message="*Campo Obligatorio, no debe estar vacio")
	private String nombre;
	
	@Column(length = 45,nullable=false)
	@Size(min=1,max=45,message="El numero de caracteres debe ser como maximo 45 caracteres")
	@NotEmpty(message="*Campo Obligatorio, no debe estar vacio")
	private String apellido;
	
	@Column(length = 15,nullable=false)
	@Size(min=1,max=15,message="El numero de caracteres debe ser como maximo 15 caracteres")
	@NotEmpty(message="*Campo Obligatorio, no debe estar vacio")
	private String telefono;
	
	@Column(length = 45,nullable=false)
	@Size(min=1,max=45,message="El numero de caracteres debe ser como maximo 45 caracteres")
	@NotEmpty(message="*Campo Obligatorio, no debe estar vacio")
	private String direccion;
	
	@Column(nullable=false)
	private Date fecha_nacimiento;
	
	@Column(nullable=false)
	@NotEmpty(message="*Campo Obligatorio, no debe estar vacio")
	private String observacion;
	
	@Column(nullable=false)
	private Integer dias_trabajados;
	
	@Column(nullable=false)
	private Double sueldo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getDias_trabajados() {
		return dias_trabajados;
	}

	public void setDias_trabajados(Integer dias_trabajados) {
		this.dias_trabajados = dias_trabajados;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		sueldo= (double) (dias_trabajados*15);
		double bono;
			if (dias_trabajados>=20 && dias_trabajados<30 ) {
				bono=sueldo*0.02;
				sueldo=bono+sueldo;
			}else if (dias_trabajados>=30) {
				
				bono=sueldo*0.05;
				sueldo=bono+sueldo;
			}else {
				
			}
		
		this.sueldo = sueldo;
	}
	
	
	
	
	
	
}
