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
 * @name FactoriDAO.java
 * @package negocio.dao.factory
 * @project Logistica-DAO
 */
package negocio.dao.factory;

import negocio.dao.iDAO;
import negocio.dao.implementacion.binario.DepositosDAO;
import negocio.dao.implementacion.binario.ProductosDAO;
import negocio.dao.implementacion.binario.SucursalesDAO;
import negocio.dao.implementacion.binario.TiendasDAO;
import negocio.dao.implementacion.binario.TransaccionesDAO;
import negocio.dao.implementacion.binario.UsuariosDAO;
import negocio.dao.implementacion.texto.DepositosDAO_txt;
import negocio.dao.implementacion.texto.ProductosDAO_txt;
import negocio.dao.implementacion.texto.SucursalesDAO_txt;
import negocio.dao.implementacion.texto.TiendasDAO_txt;
import negocio.dao.implementacion.texto.TransaccionesDAO_txt;
import negocio.dao.implementacion.texto.UsuariosDAO_txt;
import negocio.dominio.Depositos;
import negocio.dominio.Productos;
import negocio.dominio.Sucursales;
import negocio.dominio.Tiendas;
import negocio.dominio.Transacciones;
import negocio.dominio.Usuarios;

/**
 * @author IVANB dao = FactoriDAO.getDao("usuarios_db");
 */
public class FactoriDAO {

	private static String otro;

	public static iDAO getDao(String elemento) throws Exception {
		if (elemento.equalsIgnoreCase("Depositos")) {
			return new DepositosDAO<Depositos>();
		} else if (elemento.equalsIgnoreCase("Productos")) {
			return new ProductosDAO<Productos>();
		} else if (elemento.equalsIgnoreCase("Tiendas")) {
			return new TiendasDAO<Tiendas>();
		} else if (elemento.equalsIgnoreCase("Transacciones")) {
			return new TransaccionesDAO<Transacciones>();
		} else if (elemento.equalsIgnoreCase("Usuarios")) {
			return new UsuariosDAO<Usuarios>();
		} else if (elemento.equalsIgnoreCase("Sucursales")) {
			return new SucursalesDAO<Sucursales>();
		} else if (elemento.equalsIgnoreCase("Sucursales_txt")) {
			return new SucursalesDAO_txt<Sucursales>();
		} else if (elemento.equalsIgnoreCase("Depositos_txt")) {
			return new DepositosDAO_txt<Depositos>();
		} else if (elemento.equalsIgnoreCase("productos_txt")) {
			return new ProductosDAO_txt<Productos>(otro);
		} else if (elemento.equalsIgnoreCase("tiendas_txt")) {
			return new TiendasDAO_txt<Tiendas>();
		} else if (elemento.equalsIgnoreCase("transacciones_txt")) {
			return new TransaccionesDAO_txt<Transacciones>(otro);
		} else if (elemento.equalsIgnoreCase("usuarios_txt")) {
			return new UsuariosDAO_txt<Usuarios>();
		} else {
			throw new Exception("El elemento no pertenece a alguno de los definidos.");
		}
	}

	/**
	 * @return el campo elemento
	 */
	public String getElemento() {
		return otro;
	}

	/**
	 * @param elemento El parametro elemento para setear
	 */
	public void setElemento(String elemento) {
		this.otro = elemento;
	}
}
