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
 * @name ControlerReportesTipo.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.util.ArrayList;

import interfaces.IController;
import negocio.dominio.Transacciones;
import view.panels.PanelReportesTipo;

/**
 * @author IVANB
 *
 */
public class ControlerReportesTipo implements IController {

	PanelReportesTipo vista;

	/**
	 * 
	 */
	public ControlerReportesTipo() {
		// TODO Auto-generated constructor stub
	}

	public Object initPanel(ArrayList<Transacciones> transacciones) {
		vista = new PanelReportesTipo(transacciones);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	@Override
	public Object initPanel() {
		vista = new PanelReportesTipo();
		this.vista.setVisible(true);

		return this.vista;
	}

	/**
	 * @return el campo vista
	 */
	public PanelReportesTipo getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelReportesTipo vista) {
		this.vista = vista;
	}

}
