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
 * @name ControlerReportesDestino.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.util.ArrayList;

import interfaces.IController;
import negocio.dominio.Sucursales;
import negocio.dominio.Transacciones;
import view.panels.PanelReportesDestino;

/**
 * @author IVANB
 *
 */
public class ControlerReportesDestino implements IController {

	PanelReportesDestino vista;

	/**
	 * 
	 */
	public ControlerReportesDestino() {
		// TODO Auto-generated constructor stub
	}

	public Object initPanel(ArrayList<Transacciones> transacciones, ArrayList<Sucursales> sucursales) {
		vista = new PanelReportesDestino(transacciones, sucursales);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	@Override
	public Object initPanel() {
		vista = new PanelReportesDestino();
		this.vista.setVisible(true);

		return this.vista;
	}

	/**
	 * @return el campo vista
	 */
	public PanelReportesDestino getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelReportesDestino vista) {
		this.vista = vista;
	}

}
