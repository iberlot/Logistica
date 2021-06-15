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
import negocio.dao.binario.DepositosDAO;
import negocio.dao.binario.ProductosDAO;
import negocio.dao.binario.TiendasDAO;
import negocio.dao.binario.TransaccionesDAO;
import negocio.dao.binario.UsuariosDAO;
import negocio.dao.texto.DepositosDAO_txt;
import negocio.dao.texto.ProductosDAO_txt;
import negocio.dao.texto.TiendasDAO_txt;
import negocio.dao.texto.TransaccionesDAO_txt;
import negocio.dao.texto.UsuariosDAO_txt;

/**
 * @author IVANB dao = FactoriDAO.getDao("usuarios_db");
 */
public class FactoriDAO {

	public static iDAO getDao(String elemento) throws Exception {
		if (elemento.equalsIgnoreCase("depositos")) {
			return new DepositosDAO();
		} else if (elemento.equalsIgnoreCase("productos")) {
			return new ProductosDAO();
		} else if (elemento.equalsIgnoreCase("tiendas")) {
			return new TiendasDAO();
		} else if (elemento.equalsIgnoreCase("transacciones")) {
			return new TransaccionesDAO();
		} else if (elemento.equalsIgnoreCase("usuarios")) {
			return new UsuariosDAO();
		} else if (elemento.equalsIgnoreCase("depositos_txt")) {
			return new DepositosDAO_txt();
		} else if (elemento.equalsIgnoreCase("productos_txt")) {
			return new ProductosDAO_txt();
		} else if (elemento.equalsIgnoreCase("tiendas_txt")) {
			return new TiendasDAO_txt();
		} else if (elemento.equalsIgnoreCase("transacciones_txt")) {
			return new TransaccionesDAO_txt();
		} else if (elemento.equalsIgnoreCase("usuarios_txt")) {
			return new UsuariosDAO_txt();
		} else {
			throw new Exception("El elemento no pertenece a alguno de los definidos.");
		}
	}
}
