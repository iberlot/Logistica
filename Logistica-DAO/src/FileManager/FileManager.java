package FileManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase de archivos
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 * @param <T>
 */
public abstract class FileManager<T> {

	/**
	 * Archivo con el que se va a trabajar
	 *
	 * @var File file
	 */
	protected File file;

	/**
	 * Constructor de la clase
	 *
	 * @param name - Nombre que se usa para abrir el archivo
	 * @throws IOException
	 */
	public FileManager(String name) throws IOException {
		file = new File(name);
		nuevoArchivo();
	}

	/**
	 * Guarda el objeto en el archivo
	 *
	 * @param object
	 */
	abstract public void saveOnFile(T object);

	/**
	 * retorna una lista con los datos del archivo
	 *
	 * @return
	 */
	abstract public ArrayList<T> getFileList();

	/**
	 * crea un nuevo archivo en caso de no existir
	 *
	 * @throws IOException
	 */
	public void nuevoArchivo() throws IOException {
		// Si el archivo no existe es creado
		if (!file.exists()) {
			file.createNewFile();

			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("");
			bw.flush();
			bw.close();
		}

	}
}
