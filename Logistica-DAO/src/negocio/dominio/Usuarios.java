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
 * @name Usuarios.java
 * @package Dominio
 * @project Logistica-DAO
 */
package negocio.dominio;

import java.io.Serializable;

/**
 * Clase de
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class Usuarios implements Serializable {

	/**
	 * Version del la clase, requerido para que la seralizacion funcione sin
	 * problemas
	 */
	private static final long serialVersionUID = 11;

	/**
	 * @var String - nombre
	 */
	private String nombre;

	/**
	 * @var String - apellido
	 */
	private String apellido;

	/**
	 * @var long - dni
	 */
	private long dni;

	/**
	 * @var Sucursales - sucursal
	 */
	private Sucursales sucursal;

	/**
	 * Constructor de la clase
	 * 
	 */
	public Usuarios() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 *
	 * @param nombre
	 * @param apellido
	 * @param dni
	 */
	public Usuarios(String nombre, String apellido, long dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	/**
	 * Constructor de la clase
	 *
	 * @param nombre
	 * @param apellido
	 * @param dni
	 * @param sucursal
	 */
	public Usuarios(String nombre, String apellido, long dni, Sucursales sucursal) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sucursal = sucursal;
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
	 * @return el campo apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido El parametro apellido para setear
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return el campo dni
	 */
	public long getDni() {
		return dni;
	}

	/**
	 * @param dni El parametro dni para setear
	 */
	public void setDni(long dni) {
		this.dni = dni;
	}

	/**
	 * @return el campo sucursal
	 */
	public Sucursales getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal El parametro sucursal para setear
	 */
	public void setSucursal(Sucursales sucursal) {
		this.sucursal = sucursal;
	}

	@Override
	public String toString() {
		return apellido + "," + nombre;
	}
}
