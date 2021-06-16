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
 * @name ControlerProductos.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.util.ArrayList;

import interfaces.IController;
import negocio.dominio.Depositos;
import negocio.dominio.Productos;
import negocio.dominio.Sucursales;
import negocio.dominio.Tiendas;
import negocio.dominio.Transacciones;
import negocio.dominio.Usuarios;
import view.panels.PanelDepositar;

/**
 * Clase controladora de las funcionalidades de la ventana Depositar
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 */
public class ControlerDepositar implements IController {

	/*
	 * @var ArrayList<Transacciones> transacciones
	 */
	private ArrayList<Transacciones> transacciones;

	/**
	 * @var Usuarios usuario
	 */
	private Usuarios usuario;
	private ArrayList<Productos> productos;
	private ArrayList<Sucursales> sucursales;
	private PanelDepositar vista;

	/**
	 * Constructor de la clase sin datos
	 */
	public ControlerDepositar() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object initPanel() {
		vista = new PanelDepositar(sucursales, productos);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	/**
	 * Realiza un deposito y muestra un mensaje con el resultado
	 *
	 * @param desde    Tienda desde la que se envia el producto
	 * @param hasta    Deposito a donde se envia el producto
	 * @param producto Producto que se debe enviar
	 */
	public void depositar(Sucursales desde, Sucursales hasta, Productos producto) {
		if (((Tiendas) desde).depositar(((Depositos) hasta), producto)) {
			transacciones.add(new Transacciones(desde, hasta, producto, usuario, "depositar"));
			vista.confirmarDeposito(producto, desde, hasta);

		} else {
			vista.falloDeposito(producto, desde, hasta);
		}
		limpiar();
	}

	/**
	 * Limpia la vista para cerrar la ventana
	 */
	public void limpiar() {

		vista.removeAll();
		vista.setVisible(false);
	}

	/**
	 * @return el campo vista
	 */
	public PanelDepositar getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelDepositar vista) {
		this.vista = vista;
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

	/**
	 * @return el campo sucursales
	 */
	public ArrayList<Sucursales> getSucursales() {
		return sucursales;
	}

	/**
	 * @param sucursales El parametro sucursales para setear
	 */
	public void setSucursales(ArrayList<Sucursales> sucursales) {
		this.sucursales = sucursales;
	}

	/**
	 * @return el dato de transacciones
	 */
	public ArrayList<Transacciones> getTransacciones() {
		return transacciones;
	}

	/**
	 * @param transacciones para cargar en transacciones
	 */
	public void setTransacciones(ArrayList<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}

	/**
	 * @return el dato de usuario
	 */
	public Usuarios getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario para cargar en usuario
	 */
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}
