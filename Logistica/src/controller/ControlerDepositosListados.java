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
 * @name ControlerDepositos.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.util.ArrayList;

import interfaces.IController;
import negocio.dao.factory.FactoriDAO;
import negocio.dao.implementacion.binario.DepositosDAO;
import negocio.dominio.Sucursales;
import view.panels.PanelDepositosListado;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class ControlerDepositosListados implements IController {

	private PanelDepositosListado vista;
	private FactoriDAO modelo;

	public ControlerDepositosListados(PanelDepositosListado panel, DepositosDAO modelo) {
		this.vista = panel;
//		this.modelo = modelo;
	}

	public Object initPanelTransferir() {

		this.vista.setVisible(true);
		return this.vista;
	}

	public Object initPanel(ArrayList<Sucursales> sucursales) {
		vista = new PanelDepositosListado(sucursales);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	@Override
	public Object initPanel() {
		vista = new PanelDepositosListado();
		this.vista.setVisible(true);

		return this.vista;
	}

	/**
	 * @return el campo vista
	 */
	public PanelDepositosListado getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelDepositosListado vista) {
		this.vista = vista;
	}

	/**
	 * @return el campo modelo
	 */
	public FactoriDAO getModelo() {
		return modelo;
	}

	/**
	 * @param modelo El parametro modelo para setear
	 */
	public void setModelo(FactoriDAO modelo) {
		this.modelo = modelo;
	}

}
