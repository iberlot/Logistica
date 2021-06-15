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
 * @name Tiendas.java
 * @package Dominio
 * @project Logistica-DAO
 */
package negocio.dominio;

import java.util.ArrayList;

/**
 * @author IVANB
 *
 */
public class Tiendas extends Sucursales {

	/**
	 * 
	 */
	public Tiendas() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nombre
	 * @param provincia
	 * @param localidades
	 * @param productos
	 */
	public Tiendas(int id, String nombre, String provincia, String localidades, ArrayList<Productos> productos) {
		super(id, nombre, provincia, localidades, productos);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param siguiente_identificado
	 * @param string
	 * @param string2
	 * @param string3
	 */
	public Tiendas(int siguiente_identificado, String string, String string2, String string3) {
		super(siguiente_identificado, string, string2, string3);
	}

	/**
	 * @param producto
	 * @return
	 */
	public boolean extraccion(Depositos deposito_desde, Productos producto) {
		if (agregarPrducto(producto)) {
			if (deposito_desde.quitarPrducto(producto)) {
				return true;
			} else {
				quitarPrducto(producto);
			}
		}
		return false;
	}

	/**
	 * Extrae un producto de la tienda y lo deposita en un deposito. En caso de
	 * exito retorna true. Si no una excepcion.
	 * 
	 * @param deposito_hasta - Deposito donde se desea depositar el produto.
	 * @param producto       - Producto a depositar.
	 * @return true en caso de exito.
	 * @throws Exception Mensaje de error de que no se pudo realizar el deposito.
	 */
	public boolean depositar(Depositos deposito_hasta, Productos producto) {
		if (quitarPrducto(producto)) {
			if (deposito_hasta.agregarPrducto(producto)) {
				return true;
			} else {
				agregarPrducto(producto);
			}
		}
		return false;
	}

}
