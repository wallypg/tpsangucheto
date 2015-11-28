package tallerweb.sangucheto.controllers;

import java.util.ArrayList;

public class Pajaro {
	private String nombre;
	private String tipo;
	private Boolean activo = false;
	
	public Pajaro(String nombre, String tipo, Boolean activo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.activo = activo;
	}
	

	public Pajaro(){}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
}
