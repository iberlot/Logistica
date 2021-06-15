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

	private List<T> objects;

	public ByteFileManager(String name) {
		super(name);
		loadListFromFile();
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
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
			objects = (List<T>) objectInputStream.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<T> getFileOperationList() {
		// TODO Auto-generated method stub
		return null;
	}

}
