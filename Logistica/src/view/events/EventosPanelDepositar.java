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
 * @name EventosPanelProductos.java
 * @package view.events
 * @project Logistica
 */
package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControlerDepositar;
import negocio.dominio.Depositos;
import negocio.dominio.Productos;
import negocio.dominio.Tiendas;
import view.panels.PanelDepositar;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class EventosPanelDepositar implements ActionListener {

	private PanelDepositar panel;
	private ControlerDepositar control;

	/**
	 * @param panelDepositar
	 */
	public EventosPanelDepositar(PanelDepositar panelDepositar) {
		this.panel = panelDepositar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.panel.getBtnCancelar())) {
			this.panel.removeAll();
			this.panel.setVisible(false);
		} else if (e.getSource().equals(this.panel.getBtnAceptar())) {

			control.depositar(((Tiendas) this.panel.getComboDesdeTienda().getSelectedItem()),
					((Depositos) this.panel.getComboHastaDeposito().getSelectedItem()),
					((Productos) this.panel.getComboProductos().getSelectedItem()));
		}
	}

	/**
	 * @return el campo panel
	 */
	public PanelDepositar getPanel() {
		return panel;
	}

	/**
	 * @param panel El parametro panel para setear
	 */
	public void setPanel(PanelDepositar panel) {
		this.panel = panel;
	}

	/**
	 * @return el campo control
	 */
	public ControlerDepositar getControl() {
		return control;
	}

	/**
	 * @param control El parametro control para setear
	 */
	public void setControl(ControlerDepositar control) {
		this.control = control;
	}

}
