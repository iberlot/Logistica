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
 * @since 13 jun. 2021
 * @user IVANB
 * @name UsuariosDAO.java
 * @package negocio.dao
 * @project Logistica-DAO
 */
package negocio.dao.texto;

import FileManager.FileManager;
import FileManager.StringFileManager;
import negocio.dao.iDAO;
import negocio.dominio.Usuarios;

/**
 * @author IVANB
 *
 */
public class UsuariosDAO_txt implements iDAO {

	/**
	 * 
	 */
	public UsuariosDAO_txt() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object add(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
//		Connection con = null;
//		PreparedStatement prepared = null;
//		int resultado = 0;
//
//		try {
//			con = Conexion.getConection();
//			String insertSQL = "INSERT INTO tb_empleado VALUES ( ?, ?, ?, ?)";
//			prepared = con.prepareStatement(insertSQL);
//			prepared.setInt(1, empleado.getEmpleadoId());
//			prepared.setString(2, empleado.getEmpleadoNombre());
//			prepared.setString(3, empleado.getEmpleadoApellido());
//			prepared.setString(4, empleado.getEmpleadoContacto());
//			resultado = prepared.executeUpdate();
//		} catch (SQLException ex) {
//			JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
//		}
//		
//		return resultado;
	}

//	public ArrayList<Object> listar() {
//
//		ArrayList<Usuarios> listado = new ArrayList<>();
//
//		ObjectInputStream reader = new ObjectInputStream(new FileInputStream("archivoUsuarios"));
//
//		listado = (ArrayList<Usuarios>) reader.readObject();
//		reader.close();
//
//		return listado;
//
//	}

	private FileManager<Usuarios> fileManager;

	private void Historial() {
		fileManager = new StringFileManager<>("resources/historial.txt");
	}
//
//	public void registrarOperacion(Operacion operacion) {
//		fileManager.saveOnFile(operacion);
//	}

//	public ArrayList<Object> listar() {
//		return fileManager.getFileOperationList();
//	}

}
