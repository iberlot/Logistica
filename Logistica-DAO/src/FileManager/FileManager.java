/**
 * Tal y como estaba en la consigna se puede elegir entre usar una persistencia en
 * archivos de tipo Byte o String. Para hacer se esto algo versatil se utiliza la
 * herencia.
 */
package FileManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FileManager<T> {
	protected File file;

	public FileManager(String name) throws IOException {
		file = new File(name);
		nuevoArchivo();
	}

	abstract public void saveOnFile(T object);

	abstract public ArrayList<T> getFileList();

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
