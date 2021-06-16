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
 * @since 15 jun. 2021
 * @user IVANB
 * @name BinariosDao.java
 * @package negocio.dao.implementacion.binario
 * @project Logistica-DAO
 */
package negocio.dao.implementacion.binario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import FileManager.ByteFileManager;
import negocio.dao.iDAO;

/**
 * @author IVANB
 *
 */
public abstract class BinariosDao<T> implements iDAO<T> {

	protected ByteFileManager<T> manejador;
	protected String rutaArchivo;

	/**
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	protected BinariosDao(String paramProp) throws FileNotFoundException, IOException {

		Properties propiedades = new Properties();

		propiedades.load(new FileReader("config.propierties"));

		rutaArchivo = propiedades.getProperty("rutaBases") + propiedades.getProperty(paramProp);

		manejador = new ByteFileManager<T>(this.rutaArchivo);
	}

	@Override
	public void saveLista(ArrayList lista) {
		manejador.setObjects(lista);
		manejador.saveListOnfile();
	}

	@Override
	public ArrayList<T> getLista() {
		return (ArrayList<T>) manejador.getObjects();
	}

	@Override
	public void saveOnFile(ArrayList<T> cosas) {
		// TODO Auto-generated method stub

	}
}
