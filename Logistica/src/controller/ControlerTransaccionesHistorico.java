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
 * @name ControlerTransacciones.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.util.ArrayList;

import interfaces.IController;
import negocio.dominio.Transacciones;
import view.panels.PanelTransaccionesHistorico;

/**
 * @author IVANB
 *
 */
public class ControlerTransaccionesHistorico implements IController {

	PanelTransaccionesHistorico vista;

	/**
	 */
	public ControlerTransaccionesHistorico() {
		// TODO Auto-generated constructor stub
	}

	public Object initPanel(ArrayList<Transacciones> transacciones) {
		vista = new PanelTransaccionesHistorico(transacciones);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	@Override
	public Object initPanel() {
		vista = new PanelTransaccionesHistorico();
		this.vista.setVisible(true);

		return this.vista;
	}

	/**
	 * @return el campo vista
	 */
	public PanelTransaccionesHistorico getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelTransaccionesHistorico vista) {
		this.vista = vista;
	}

}
