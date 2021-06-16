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
 * @name EventosPanelSucursales.java
 * @package view.events
 * @project Logistica
 */
package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControlerExtracciones;
import negocio.dominio.Depositos;
import negocio.dominio.Productos;
import negocio.dominio.Tiendas;
import view.panels.PanelExtracciones;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class EventosPanelExtracciones implements ActionListener {

	private PanelExtracciones panel;
	private ControlerExtracciones control;

	/**
	 * @param panelExtracciones
	 */
	public EventosPanelExtracciones(PanelExtracciones panelExtracciones) {
		this.panel = panelExtracciones;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.panel.getBtnCancelar())) {
			this.panel.removeAll();
			this.panel.setVisible(false);
		} else if (e.getSource().equals(this.panel.getBtnAceptar())) {

			control.extraer(((Tiendas) this.panel.getComboTiendas().getSelectedItem()),
					((Depositos) this.panel.getComboDepositos().getSelectedItem()),
					((Productos) this.panel.getComboProductos().getSelectedItem()));

		}
	}

	/**
	 * @return el campo panel
	 */
	public PanelExtracciones getPanel() {
		return panel;
	}

	/**
	 * @param panel El parametro panel para setear
	 */
	public void setPanel(PanelExtracciones panel) {
		this.panel = panel;
	}

	/**
	 * @return el campo control
	 */
	public ControlerExtracciones getControl() {
		return control;
	}

	/**
	 * @param control El parametro control para setear
	 */
	public void setControl(ControlerExtracciones control) {
		this.control = control;
	}

}
