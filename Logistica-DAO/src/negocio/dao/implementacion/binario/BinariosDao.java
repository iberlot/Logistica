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
 * @since 15 jun. 2021
 * @user iBerlo <@> iberlot@usal.edu.ar
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
 * Clase de padre para la creacion de DAOs binarios
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 * @param <T>
 */
public abstract class BinariosDao<T> implements iDAO<T> {

	/**
	 * @var ByteFileManager<T> manejador
	 */
	protected ByteFileManager<T> manejador;

	/**
	 * @var String rutaArchivo
	 */
	protected String rutaArchivo;

	/**
	 * Constructor de la clase
	 *
	 * @param paramProp
	 * @throws FileNotFoundException
	 * @throws IOException
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
