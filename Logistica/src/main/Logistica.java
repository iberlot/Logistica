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
 * @name Logistica.java
 * @package main
 * @project Logistica
 */
package main;

import java.awt.EventQueue;

import controller.ControlerPrincipal;
import exepciones.ValidacionesException;

/**
 * Clase inicial del sistema
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
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
					ControlerPrincipal principal = new ControlerPrincipal();

					principal.initPanel();

				} catch (Exception e) {
					ValidacionesException.mostrarMensaje(e);
				}
			}
		});
	}

}
