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
 * @name Depositos.java
 * @package Dominio
 * @project Logistica-DAO
 */
package negocio.dominio;

/**
 * @author IVANB
 *
 */
public class Depositos extends Sucursales {

	/**
	 * 
	 */
	public Depositos() {
		// TODO Auto-generated constructor stub
	}

	/**
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
