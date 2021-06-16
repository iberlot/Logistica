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
 * @name ValidacionesException.java
 * @package exepciones
 * @project Logistica-DAO
 */
package exepciones;

import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Clase de manejo de excepciones propio con la posibilidad de mostrar los
 * mensajes en Alerts del sistema
 *
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class ValidacionesException extends IOException {

	/**
	 * Constructor de la clase
	 *
	 */
	public ValidacionesException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 *
	 * @param message
	 */
	public ValidacionesException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ValidacionesException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ValidacionesException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Muestra un dialog con el mensaje de error
	 *
	 * @param e Excepcion
	 */
	public static void mostrarMensaje(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}
}
