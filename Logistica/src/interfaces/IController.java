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
 * @name IController.java
 * @package controller
 * @project Logistica
 */
package interfaces;

/**
 * Interface con lo basico que debe tener un controlador
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public interface IController {

	/**
	 * Funcion que va a iniciar la ventana.
	 *
	 * @return
	 * @throws Exception
	 */
	public Object initPanel() throws Exception;

}
