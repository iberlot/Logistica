/*
 * Querido programador:
 * Cuando escribi este codigo, solo Dios y yo sabiamos como funcionaba.
 * Ahora, Solo Dios lo sabe!!!
 * Asi que, si esta tratando de 'optimizar' esta rutina y fracasa (seguramente),
 * por favor, incremente el siguiente contador como una advertencia para el
 * siguiente colega:
 * totalHorasPerdidasAqui = 0
 */
/**
 * @since 13 jun. 2021
 * @user IVANB
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
import view.panels.PanelDepositar;

/**
 * @author IVANB
 *
 */
public class ControlerDepositar implements IController {

	private ArrayList<Productos> productos;
	private ArrayList<Sucursales> sucursales;
	private PanelDepositar vista;

	/**
	 * 
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

	public void depositar(Sucursales desde, Sucursales hasta, Productos producto) {
		if (((Tiendas) desde).depositar(((Depositos) hasta), producto)) {
			vista.confirmarDeposito(producto, desde, hasta);

		} else {
			vista.falloDeposito(producto, desde, hasta);
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

}
