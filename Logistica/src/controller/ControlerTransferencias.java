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
 * @name ControlerTiendas.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.util.ArrayList;

import interfaces.IController;
import negocio.dominio.Depositos;
import negocio.dominio.Productos;
import negocio.dominio.Sucursales;
import view.panels.PanelTransferencias;

/**
 * @author IVANB
 *
 */
public class ControlerTransferencias implements IController {

	PanelTransferencias vista;

	/**
	 * 
	 */
	public ControlerTransferencias() {
		// TODO Auto-generated constructor stub
	}

	// XXX deberia traer los datos de por parametro o directamente del DAO?
	public Object initPanel(ArrayList<Sucursales> sucursales, ArrayList<Productos> productos) {
		vista = new PanelTransferencias(sucursales, productos);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	@Override
	public Object initPanel() {
		vista = new PanelTransferencias();
		this.vista.setVisible(true);

		return this.vista;
	}

	public void transferir(Depositos desde, Depositos hasta, Productos producto) {
		if (desde.transferir(hasta, producto)) {
			vista.confirmarTransferencia(producto, desde, hasta);

		} else {
			vista.falloTransferencia(producto, desde, hasta);
		}
		limpiar();
	}

	/**
	 * @return el campo vista
	 */
	public PanelTransferencias getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelTransferencias vista) {
		this.vista = vista;
	}

	public void limpiar() {

		vista.removeAll();
		vista.setVisible(false);
	}

}
