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
 * @name EventosPanelReportesDestino.java
 * @package view.events
 * @project Logistica
 */
package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControlerReportesDestino;
import view.panels.PanelReportesDestino;

/**
 * @author IVANB
 *
 */
public class EventosPanelReportesDestino implements ActionListener {

	private PanelReportesDestino panel;

	private ControlerReportesDestino control;

	/**
	 * @param panelReportesDestino
	 */
	public EventosPanelReportesDestino(PanelReportesDestino panelReportesDestino) {
		this.panel = panelReportesDestino;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.panel.getBtnCancelar())) {
			this.panel.removeAll();
			this.panel.setVisible(false);
		} else if (e.getSource().equals(this.panel.getComboDestino())) {

			control.rellenaTabla(this.panel.getComboDestino().getSelectedItem());
		} else if (e.getSource().equals(this.panel.getBtnExportar())) {
			try {
				control.expontar(this.panel.getComboDestino().getSelectedItem());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * @return el campo panel
	 */
	public PanelReportesDestino getPanel() {
		return panel;
	}

	/**
	 * @param panel El parametro panel para setear
	 */
	public void setPanel(PanelReportesDestino panel) {
		this.panel = panel;
	}

	/**
	 * @return el campo control
	 */
	public ControlerReportesDestino getControl() {
		return control;
	}

	/**
	 * @param control El parametro control para setear
	 */
	public void setControl(ControlerReportesDestino control) {
		this.control = control;
	}

}
