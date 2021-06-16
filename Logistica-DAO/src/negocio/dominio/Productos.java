/*
 * Querido programador:
 * Cuando escribi este codigo, solo Dios y yo sabiamos como funcionaba.
 * Ahora, Solo Dios lo sabe!!!
 * Asi que, si esta tratando de 'optimizar' esta rutina y fracasa (seguramente),
 * por favor, incremente el siguiente contador como una advertencia para el
 * siguiente colega:
 * totalHorasPerdidasAqui = 60
 */
/**
 * @since 13 jun. 2021
 * @user iBerlo <@> iberlot@usal.edu.ar
 * @name Productos.java
 * @package Dominio
 * @project Logistica-DAO
 */
package negocio.dominio;

import java.io.Serializable;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class Productos implements Serializable {

	/**
	 * Version del la clase, requerido para que la seralizacion funcione sin
	 * problemas
	 */
	private static final long serialVersionUID = 10;

	/**
	 * @var String - nombre
	 */
	protected String nombre;

	/**
	 * @var String - descripcion
	 */
	protected String descripcion;

	/**
	 * @var float - precio
	 */
	protected float precio;

	/**
	 * Constructor de la clase
	 * 
	 */
	public Productos() {
	}

	/**
	 * Constructor de la clase
	 *
	 * @param nombre
	 * @param descripcion
	 * @param precio
	 */
	public Productos(String nombre, String descripcion, float precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	/**
	 * @return el campo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre El parametro nombre para setear
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el campo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion El parametro descripcion para setear
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return el campo precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio El parametro precio para setear
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
