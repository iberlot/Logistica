package FileManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ByteFileManager<T> extends FileManager<T> {

	private ArrayList<T> objects;

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
