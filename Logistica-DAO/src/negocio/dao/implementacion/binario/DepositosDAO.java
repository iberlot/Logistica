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
 * @name DepositosDAO.java
 * @package negocio.dao
 * @project Logistica-DAO
 */
package negocio.dao.implementacion.binario;

import java.io.FileNotFoundException;
import java.io.IOException;

import negocio.dao.iDAO;

/**
 * Clase de
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 * @param <T>
 */
public class DepositosDAO<T> extends SucursalesDAO implements iDAO {

	/**
	 * Constructor de la clase
	 *
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public DepositosDAO() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object add(Object elemento) {

		return elemento;
	}

	@Override
	public Object get(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

}
