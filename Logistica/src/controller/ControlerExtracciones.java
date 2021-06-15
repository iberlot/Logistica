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
import view.panels.PanelExtracciones;

/**
 * @author IVANB
 *
 */
public class ControlerExtracciones implements IController {

	PanelExtracciones vista;

	/**
	 * 
	 */
	public ControlerExtracciones() {
		// TODO Auto-generated constructor stub
	}

	public Object initPanel(ArrayList<Sucursales> sucursales, ArrayList<Productos> productos) {
		vista = new PanelExtracciones(sucursales, productos);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	public void extraer(Sucursales desde, Sucursales hasta, Productos producto) {
		if (((Tiendas) desde).extraccion(((Depositos) hasta), producto)) {
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

	@Override
	public Object initPanel() {
		vista = new PanelExtracciones();
		this.vista.setVisible(true);

		return this.vista;
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

}
