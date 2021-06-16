package FileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Clase de manejo de archivos de texto
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 * @param <T>
 */
public class StringFileManager<T> extends FileManager<T> implements AutoCloseable {

	/**
	 * Constructor de la clase
	 *
	 * @param name
	 * @throws IOException
	 */
	public StringFileManager(String name) throws IOException {
		super(name);
	}

	/**
	 * Escripbe en el archivo la informacion de un arrayList de Strings separados
	 * por el Char pasado
	 *
	 * @param info      - ArrayList<String[]> con los distintos campos a agregar en
	 *                  el archivo
	 * @param separador - char que se va a usar para separar los datos
	 * @throws IOException
	 */
	public void escribeCamposSepararPor(ArrayList<String[]> info, char separador) throws IOException {

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		fw.close();

		for (String[] strings : info) {
			escribeCamposSepararPor(strings, separador);
		}
	}

	/**
	 * Escribe una linea con los campos del array separados por el caracter pasado
	 *
	 * @param info      Array con la informacion a cargar
	 * @param separador Saracter con el que separar la informacion
	 * @throws IOException
	 */
	public void escribeCamposSepararPor(String[] info, char separador) throws IOException {

		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);

		for (String dato : info) {

			fw.append(dato + separador);
		}

		fw.append("\n");
		fw.close();

	}

	/**
	 * Grabar un arrayList en el archivo. FIXME no funciona y me quede sin tiempo
	 * para revisarla.
	 *
	 * @param object ArrayList con los objetos a cargar en el archivo
	 */
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
