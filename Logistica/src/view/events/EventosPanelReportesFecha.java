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
 * @name EventosPanelReportesFecha.java
 * @package view.events
 * @project Logistica
 */
package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControlerReportesFecha;
import view.panels.PanelReportesFecha;

/**
 * @author IVANB
 *
 */
public class EventosPanelReportesFecha implements ActionListener {

	private PanelReportesFecha panel;
	private ControlerReportesFecha control;

	/**
	 * @param panelReportesFecha
	 */
	public EventosPanelReportesFecha(PanelReportesFecha panelReportesFecha) {
		this.panel = panelReportesFecha;
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
	public PanelReportesFecha getPanel() {
		return panel;
	}

	/**
	 * @param panel El parametro panel para setear
	 */
	public void setPanel(PanelReportesFecha panel) {
		this.panel = panel;
	}

	/**
	 * @return el campo control
	 */
	public ControlerReportesFecha getControl() {
		return control;
	}

	/**
	 * @param control El parametro control para setear
	 */
	public void setControl(ControlerReportesFecha control) {
		this.control = control;
	}

}
