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
 * @name EventosPanelDepositos.java
 * @package view.events
 * @project Logistica
 */
package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControlerDepositosListados;
import view.panels.PanelDepositosListado;

/**
 * @author IVANB
 *
 */
public class EventosPanelDepositosListado implements ActionListener {

	private PanelDepositosListado panel;
	private ControlerDepositosListados control;

	/**
	 * @param panelDepositosListado
	 */
	public EventosPanelDepositosListado(PanelDepositosListado panelDepositosListado) {
		this.panel = panelDepositosListado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.panel.getBtnCancelar())) {
			this.panel.removeAll();
			this.panel.setVisible(false);
		}
	}

	/**
	 * @return el campo panel
	 */
	public PanelDepositosListado getPanel() {
		return panel;
	}

	/**
	 * @return el campo control
	 */
	public ControlerDepositosListados getControl() {
		return control;
	}

	/**
	 * @param panel El parametro panel para setear
	 */
	public void setPanel(PanelDepositosListado panel) {
		this.panel = panel;
	}

	/**
	 * @param control El parametro control para setear
	 */
	public void setControl(ControlerDepositosListados control) {
		this.control = control;
	}

}
