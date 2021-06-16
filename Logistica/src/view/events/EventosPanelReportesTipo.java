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
 * @name EventosPanelReportesTipo.java
 * @package view.events
 * @project Logistica
 */
package view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControlerReportesTipo;
import view.panels.PanelReportesTipo;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class EventosPanelReportesTipo implements ActionListener {

	private PanelReportesTipo panel;
	private ControlerReportesTipo control;

	/**
	 * @param panelReportesTipo
	 */
	public EventosPanelReportesTipo(PanelReportesTipo panelReportesTipo) {
		this.panel = panelReportesTipo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.panel.getBtnCancelar())) {
			this.panel.removeAll();
			this.panel.setVisible(false);
		} else if (e.getSource().equals(this.panel.getComboTipos())) {

			control.rellenaTabla(this.panel.getComboTipos().getSelectedItem());
		} else if (e.getSource().equals(this.panel.getBtnExportar())) {
			try {
				control.expontar(this.panel.getComboTipos().getSelectedItem());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * @return el campo panel
	 */
	public PanelReportesTipo getPanel() {
		return panel;
	}

	/**
	 * @param panel El parametro panel para setear
	 */
	public void setPanel(PanelReportesTipo panel) {
		this.panel = panel;
	}

	/**
	 * @return el campo control
	 */
	public ControlerReportesTipo getControl() {
		return control;
	}

	/**
	 * @param control El parametro control para setear
	 */
	public void setControl(ControlerReportesTipo control) {
		this.control = control;
	}

}
