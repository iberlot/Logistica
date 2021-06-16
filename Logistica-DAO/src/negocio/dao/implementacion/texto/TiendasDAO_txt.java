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
 * @name TiendasDAO.java
 * @package negocio.dao
 * @project Logistica-DAO
 */
package negocio.dao.implementacion.texto;

import java.io.FileNotFoundException;
import java.io.IOException;

import FileManager.ByteFileManager;
import negocio.dao.iDAO;
import negocio.dao.implementacion.binario.SucursalesDAO;

/**
 * @author IVANB
 *
 */
public class TiendasDAO_txt<T> extends SucursalesDAO implements iDAO {

	private ByteFileManager<T> manejador;

	/**
	 * 
	 */
	public TiendasDAO_txt() throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub
	}

}
