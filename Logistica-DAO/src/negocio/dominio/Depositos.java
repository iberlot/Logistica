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
 * @name Depositos.java
 * @package Dominio
 * @project Logistica-DAO
 */
package negocio.dominio;

/**
 * Clase de administracion de los depositos
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 */
public class Depositos extends Sucursales {

	/**
	 * Version del la clase, requerido para que la seralizacion funcione sin
	 * problemas
	 */
	private static final long serialVersionUID = 15;

	/**
	 * Constructor de la clase
	 */
	public Depositos() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase
	 *
	 * @param siguiente_identificado
	 * @param string
	 * @param string2
	 * @param string3
	 */
	public Depositos(int siguiente_identificado, String string, String string2, String string3) {
		super(siguiente_identificado, string, string2, string3);
	}

	/**
	 * @param deposito_hasta
	 * @param producto
	 * @return
	 * @throws Exception
	 */
	public boolean transferir(Depositos deposito_hasta, Productos producto) {

		if (productos.contains(producto)) {

			if (quitarPrducto(producto)) {
				if (deposito_hasta.agregarPrducto(producto)) {
					return true;
				} else {
					agregarPrducto(producto);
				}
			}
		}
		return false;

	}

}
