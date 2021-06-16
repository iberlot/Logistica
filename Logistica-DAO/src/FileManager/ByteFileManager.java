package FileManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de manejo de archivos de tipo bite
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 * @param <T>
 */
public class ByteFileManager<T> extends FileManager<T> {

	/**
	 * Para simplificar el tebajo con listas
	 *
	 * @var ArrayList<T> objects
	 */
	private ArrayList<T> objects;

	/**
	 * Constructor de la clase
	 *
	 * @param name
	 * @throws IOException
	 */
	public ByteFileManager(String name) throws IOException {
		super(name);

		if (file.length() > 0) {
			loadListFromFile();
		}
	}

	@Override
	public void saveOnFile(T object) {
		objects.add(object);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
			objectOutputStream.writeObject(objects);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga el ArrayList objects con la informacion del archivo
	 */
	private void loadListFromFile() {
		try {
			FileInputStream archi = new FileInputStream(file);

			ObjectInputStream objectInputStream = new ObjectInputStream(archi);
			objects = (ArrayList<T>) objectInputStream.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<T> getFileList() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Guarda el ArrayList objects en el archivo
	 */
	public void saveListOnfile() {
		try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));

			writer.writeObject(objects);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return el campo objects
	 */
	public List<T> getObjects() {
		return objects;
	}

	/**
	 * @param objects El parametro objects para setear
	 */
	public void setObjects(ArrayList<T> objects) {
		this.objects = objects;
	}

}
