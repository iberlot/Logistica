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
 * @name ControlerReportesFecha.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.text.ParseException;
import java.util.ArrayList;

import interfaces.IController;
import negocio.dominio.Sucursales;
import negocio.dominio.Transacciones;
import view.panels.PanelReportesFecha;

/**
 * @author IVANB
 *
 */
public class ControlerReportesFecha implements IController {

	PanelReportesFecha vista;

	/**
	 * 
	 */
	public ControlerReportesFecha() {
		// TODO Auto-generated constructor stub
	}

	public Object initPanel(ArrayList<Transacciones> transacciones, ArrayList<Sucursales> sucursales)
			throws ParseException {
		vista = new PanelReportesFecha(sucursales, transacciones);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	@Override
	public Object initPanel() {
		vista = new PanelReportesFecha();
		this.vista.setVisible(true);

		return this.vista;
	}

	/**
	 * @return el campo vista
	 */
	public PanelReportesFecha getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelReportesFecha vista) {
		this.vista = vista;
	}

}
