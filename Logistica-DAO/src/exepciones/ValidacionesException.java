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
 * @name ValidacionesException.java
 * @package exepciones
 * @project Logistica-DAO
 */
package exepciones;

import java.io.IOException;

/**
 * @author IVANB
 *
 */
public class ValidacionesException extends IOException {

	/**
	 * 
	 */
	public ValidacionesException() {
		// TODO Auto-generated constructor stub
	}

	/**
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

}
