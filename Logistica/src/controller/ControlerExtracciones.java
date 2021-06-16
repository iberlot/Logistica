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
 * @name ControlerSucursales.java
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
import view.panels.PanelExtracciones;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class ControlerExtracciones implements IController {

	/**
	 * @var ArrayList<Transacciones> transacciones
	 */
	private ArrayList<Transacciones> transacciones;
	/**
	 * @var Usuarios usuario
	 */
	private Usuarios usuario;
	private ArrayList<Productos> productos;
	private ArrayList<Sucursales> sucursales;
	private PanelExtracciones vista;

	/**
	 *
	 */
	public ControlerExtracciones() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object initPanel() {
		vista = new PanelExtracciones(sucursales, productos);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	public void extraer(Sucursales desde, Sucursales hasta, Productos producto) {
		if (((Tiendas) desde).extraccion(((Depositos) hasta), producto)) {
			transacciones.add(new Transacciones(desde, hasta, producto, usuario, "extraer"));

			vista.confirmarExtraxion(producto, desde, hasta);

		} else {
			vista.falloExtraxion(producto, desde, hasta);
		}
		limpiar();
	}

	public void limpiar() {

		vista.removeAll();
		vista.setVisible(false);
	}

	/**
	 * @return el campo vista
	 */
	public PanelExtracciones getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelExtracciones vista) {
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
