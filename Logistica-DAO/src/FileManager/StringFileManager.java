package FileManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class StringFileManager<T> extends FileManager<T> implements AutoCloseable {

	public StringFileManager(String name) {
		super(name);
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
//
//    @Override
//    public List<Cliente> getFileClientList(){
//        ArrayList<Cliente> result = new ArrayList<>();
//        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
//            String line;
//            while((line = reader.readLine()) != null){
//                String[] data = line.split(" ");
//                if("Transferencia".equals(data[0]))
//                    result.add(new Cliente());
//                else
//                    result.add(new Cliente());
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

	@Override
	public void close() throws Exception {

	}

	@Override
	public ArrayList<T> getFileOperationList() {
		// TODO Auto-generated method stub
		return null;
	}
}
