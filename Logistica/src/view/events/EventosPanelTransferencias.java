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
 * @name EventosPanelTiendas.java
 * @package view.events
 * @project Logistica
 */
package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControlerTransferencias;
import negocio.dominio.Depositos;
import negocio.dominio.Productos;
import view.panels.PanelTransferencias;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class EventosPanelTransferencias implements ActionListener {

	private PanelTransferencias panel;
	private ControlerTransferencias control;

	/**
	 * @param panelTransferencias
	 */
	public EventosPanelTransferencias(PanelTransferencias panelTransferencias) {
		panel = panelTransferencias;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.panel.getBtnCancelar())) {
			this.panel.removeAll();
			this.panel.setVisible(false);
		} else if (e.getSource().equals(this.panel.getBtnAceptar())) {

			control.transferir(((Depositos) this.panel.getComboDesde().getSelectedItem()),
					((Depositos) this.panel.getComboHasta().getSelectedItem()),
					((Productos) this.panel.getComboProductos().getSelectedItem()));

		}

	}

	/**
	 * @return el campo panel
	 */
	public PanelTransferencias getPanel() {
		return panel;
	}

	/**
	 * @param panel El parametro panel para setear
	 */
	public void setPanel(PanelTransferencias panel) {
		this.panel = panel;
	}

	/**
	 * @return el campo control
	 */
	public ControlerTransferencias getControl() {
		return control;
	}

	/**
	 * @param control El parametro control para setear
	 */
	public void setControl(ControlerTransferencias control) {
		this.control = control;
	}

}
