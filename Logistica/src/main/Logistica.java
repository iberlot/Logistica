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
 * @name Logistica.java
 * @package main
 * @project Logistica
 */
package main;

import java.awt.EventQueue;
import java.io.FileReader;
import java.util.Properties;

import javax.swing.JOptionPane;

import controller.ControlerPrincipal;

/**
 * @author IVANB
 *
 */
public final class Logistica {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {

					Properties propiedades = new Properties();
					propiedades.load(new FileReader("config.propierties"));

					ControlerPrincipal principal = new ControlerPrincipal();
					principal.setPropiedades(propiedades);

					principal.initFrame();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

}
