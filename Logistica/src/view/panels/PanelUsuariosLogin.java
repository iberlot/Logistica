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
 * @name PanelUsuarios.java
 * @package view.panels
 * @project Logistica
 */
package view.panels;

import java.awt.LayoutManager;

import javax.swing.JPanel;

import interfaces.iPanels;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class PanelUsuariosLogin extends JPanel implements iPanels {

	/**
	 * 
	 */
	public PanelUsuariosLogin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param layout
	 */
	public PanelUsuariosLogin(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isDoubleBuffered
	 */
	public PanelUsuariosLogin(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public PanelUsuariosLogin(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getObjeto() {
		// TODO Auto-generated method stub
		return null;
	}

}
