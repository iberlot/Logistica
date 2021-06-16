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
 * @name Sucursal.java
 * @package Dominio
 * @project Logistica-DAO
 */
package negocio.dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase de implementacion de las sucursales.
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
/**
 * Clase de
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public abstract class Sucursales implements Serializable {

	/**
	 * Version del la clase, requerido para que la seralizacion funcione sin
	 * problemas
	 */
	private static final long serialVersionUID = 14;
	/**
	 * @var int - id
	 */
	protected int id;

	/**
	 * @var String - nombre
	 */
	protected String nombre;

	/**
	 * @var String - provincia
	 */
	protected String provincia;

	/**
	 * @var String - localidades
	 */
	protected String localidades;

	/**
	 * @var ArrayList<Productos> - productos
	 */
	protected ArrayList<Productos> productos = new ArrayList<>();

	/**
	 * @var int - ultimo_identificador
	 */
	protected static int ultimo_identificador;

	/**
	 * Constructor de la clase
	 *
	 */
	public Sucursales() {
	}

	/**
	 * Constructor de la clase
	 *
	 * @param id
	 * @param nombre
	 * @param provincia
	 * @param localidades
	 * @param productos
	 */
	public Sucursales(int id, String nombre, String provincia, String localidades, ArrayList<Productos> productos) {
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
		this.localidades = localidades;
		this.productos = productos;
	}

	/**
	 * Constructor de la clase
	 *
	 * @param id
	 * @param nombre
	 * @param provincia
	 * @param localidades
	 */
	public Sucursales(int id, String nombre, String provincia, String localidades) {
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
		this.localidades = localidades;
	}

	/**
	 * @return el campo ultimo_identificador
	 */
	public static int getUltimo_identificador() {
		return ultimo_identificador;
	}

	/**
	 * @param ultimo_identificador El parametro ultimo_identificador para setear
	 */
	public static void setUltimo_identificador(int ultimo_identificador) {
		Sucursales.ultimo_identificador = ultimo_identificador;
	}

	/**
	 * @param ultimo_identificador El parametro ultimo_identificador para setear
	 */
	public static void agregaUltimo_identificador() {
		Sucursales.ultimo_identificador++;
	}

	/**
	 * Agrega uno al cultimo dentificador y lo devuelve
	 *
	 * @return int ultimo identificador
	 */
	public static int siguiente_identificado() {
		agregaUltimo_identificador();
		return getUltimo_identificador();
	}

	/**
	 * Agrega un producto al array de productos de la sucursal
	 *
	 * @param producto
	 * @return true
	 */
	public boolean agregarPrducto(Productos producto) {

		this.productos.add(producto);

		return true;
	}

	/**
	 * Quita un producto del array de productos de la sucursal
	 *
	 * @param producto
	 * @return
	 */
	public boolean quitarPrducto(Productos producto) {
		return this.productos.remove(producto);
	}

	/**
	 * @return el campo id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id El parametro id para setear
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return el campo provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia El parametro provincia para setear
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return el campo localidades
	 */
	public String getLocalidades() {
		return localidades;
	}

	/**
	 * @param localidades El parametro localidades para setear
	 */
	public void setLocalidades(String localidades) {
		this.localidades = localidades;
	}

	/**
	 * @return el campo productos
	 */
	public ArrayList<Productos> getProductos() {
		return productos;
	}

	/**
	 * @param productos El parametro productos para setear
	 */
	public void setProductos(ArrayList<Productos> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return id + " - " + nombre;
	}

}
