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
 * @name Transacciones.java
 * @package negocio.dominio
 * @project Logistica-DAO
 */
package negocio.dominio;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Clase de
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class Transacciones implements Comparable<Transacciones>, Serializable {

	/**
	 * Version del la clase, requerido para que la seralizacion funcione sin
	 * problemas
	 */
	private static final long serialVersionUID = 12;

	/**
	 * @var Calendar fecha
	 */
	private Calendar fecha;

	/**
	 * @var Sucursales desde
	 */
	private Sucursales desde;

	/**
	 * @var Sucursales hasta
	 */
	private Sucursales hasta;

	/**
	 * @var Productos producto
	 */
	private Productos producto;

	/**
	 * @var Usuarios usuario
	 */
	private Usuarios usuario;

	/**
	 * @var String tipo
	 */
	private String tipo;

	/**
	 * Tipos permitidos de transacciones (no voy a hacer 3 clases, NO.)
	 *
	 * @var String[] tipos
	 */
	private static String tipos[] = { "transferir", "extraer", "depositar" };

	/**
	 * Constructor de la clase
	 *
	 */
	public Transacciones() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 *
	 * @param desde
	 * @param hasta
	 * @param producto
	 * @param usuario
	 * @param tipo
	 */
	public Transacciones(Sucursales desde, Sucursales hasta, Productos producto, Usuarios usuario, String tipo) {
		this.fecha = Calendar.getInstance();
		this.desde = desde;
		this.hasta = hasta;
		this.producto = producto;
		this.usuario = usuario;
		this.tipo = tipo;
	}

	/**
	 * Constructor de la clase
	 *
	 * @param fecha
	 * @param desde
	 * @param hasta
	 * @param producto
	 * @param usuario
	 * @param tipo
	 */
	public Transacciones(Calendar fecha, Sucursales desde, Sucursales hasta, Productos producto, Usuarios usuario,
			String tipo) {
		this.fecha = fecha;
		this.desde = desde;
		this.hasta = hasta;
		this.producto = producto;
		this.usuario = usuario;
		this.tipo = tipo;
	}

	/**
	 * @return devuelve un string con la fecha formateada paa mostrar por pantalla
	 */
	public String getFechaString() {
		return String.format("%04d-%02d-%02d", this.getFecha().get(Calendar.YEAR),
				this.getFecha().get(Calendar.MONTH) + 1, this.getFecha().get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * @return devuelve un string con la fecha formateada
	 */
	public String getFechaNumero() {
		return String.format("%04d%02d%02d", this.getFecha().get(Calendar.YEAR),
				this.getFecha().get(Calendar.MONTH) + 1, this.getFecha().get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * @return el campo fecha
	 */
	public Calendar getFecha() {
		return fecha;
	}

	/**
	 * @param fecha El parametro fecha para setear
	 */
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return el campo desde
	 */
	public Sucursales getDesde() {
		return desde;
	}

	/**
	 * @param desde El parametro desde para setear
	 */
	public void setDesde(Sucursales desde) {
		this.desde = desde;
	}

	/**
	 * @return el campo hasta
	 */
	public Sucursales getHasta() {
		return hasta;
	}

	/**
	 * @param hasta El parametro hasta para setear
	 */
	public void setHasta(Sucursales hasta) {
		this.hasta = hasta;
	}

	/**
	 * @return el campo producto
	 */
	public Productos getProducto() {
		return producto;
	}

	/**
	 * @param producto El parametro producto para setear
	 */
	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	/**
	 * @return el campo usuario
	 */
	public Usuarios getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario El parametro usuario para setear
	 */
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return el campo tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo El parametro tipo para setear
	 * @throws Exception
	 */
	public void setTipo(String tipo) throws Exception {

		boolean ok = false;

		for (String string : tipos) {
			if (string.equals(tipo)) {
				ok = true;
			}
		}

		if (ok == true) {
			this.tipo = tipo;
		} else {
			throw new Exception("Tipo de transaccion no admitido.");
		}
	}

	/**
	 * @return el campo tipos
	 */
	public static String[] getTipos() {
		return tipos;
	}

	@Override
	public int compareTo(Transacciones o) {
		return getFecha().compareTo(o.getFecha());
	}

}
