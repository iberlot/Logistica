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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import controller.ControlerReportesFecha;
import view.panels.PanelReportesFecha;

/**
 * @author IVANB
 *
 */
public class EventosPanelReportesFecha implements ActionListener, FocusListener {

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
		} else if ((e.getSource().equals(this.panel.getNroTienda()))
				|| (e.getSource().equals(this.panel.getFechaDesde()))
				|| (e.getSource().equals(this.panel.getFechaHasta()))) {

			int nTienda = 0;
			String fDesde = null;
			String fHasta = null;

			if (this.panel.getNroTienda().getText().length() > 0) {
				nTienda = Integer.parseInt(this.panel.getNroTienda().getText());
			}
			if (((this.panel.getFechaDesde().getText()).replace(" ", "")).length() > 2) {
				fDesde = this.panel.getFechaDesde().getText();
			}
			if (((this.panel.getFechaHasta().getText()).replace(" ", "")).length() > 2) {
				fHasta = this.panel.getFechaHasta().getText();
			}

			control.rellenaTabla(nTienda, fDesde, fHasta);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		if ((e.getSource().equals(this.panel.getNroTienda())) || (e.getSource().equals(this.panel.getFechaDesde()))
				|| (e.getSource().equals(this.panel.getFechaHasta()))) {

			int nTienda = 0;
			String fDesde = null;
			String fHasta = null;

			if (this.panel.getNroTienda().getText().length() > 0) {
				nTienda = Integer.parseInt(this.panel.getNroTienda().getText());
			}
			if (((this.panel.getFechaDesde().getText()).replace(" ", "")).length() > 2) {
				fDesde = this.panel.getFechaDesde().getText().replace("/", "");
			}
			if (((this.panel.getFechaHasta().getText()).replace(" ", "")).length() > 2) {
				fHasta = this.panel.getFechaHasta().getText().replace("/", "");
			}

			control.rellenaTabla(nTienda, fDesde, fHasta);
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
