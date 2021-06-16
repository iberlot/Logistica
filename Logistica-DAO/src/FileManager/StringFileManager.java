package FileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class StringFileManager<T> extends FileManager<T> implements AutoCloseable {

	public StringFileManager(String name) throws IOException {
		super(name);
	}

	public void escribeCamposSepararPor(ArrayList<String[]> info, char separador) throws IOException {

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		fw.close();

		for (String[] strings : info) {
			escribeCamposSepararPor(strings, separador);
		}
	}

	public void escribeCamposSepararPor(String[] info, char separador) {
		try {

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);

			for (String dato : info) {

				fw.append(dato + separador);
			}

			fw.append("\n");
			fw.close();

		} catch (IOException e) {

		}
	}

	public void saveOnFile(ArrayList<T> object) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

			Field[] fields = object.getClass().getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {

				Field field = object.getClass().getDeclaredField(fields[i].getName());
				field.setAccessible(true);
				if (field.get(object) != null)
					writer.write(field.get(object).toString() + " ");
			}
			writer.write("\n");

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveOnFile(T object) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

			Field[] fields = object.getClass().getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {

				Field field = object.getClass().getDeclaredField(fields[i].getName());
				field.setAccessible(true);
				if (field.get(object) != null)
					writer.write(field.get(object).toString() + " ");
			}
			writer.write("\n");

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<T> getFileList() {

		ArrayList<T> result = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(" ");
				if ("Transferencia".equals(data[0]))
					result.add((T) new Object());
				else
					result.add((T) new Object());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void close() throws Exception {

	}

}
