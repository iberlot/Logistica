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
 * @since 13 jun. 2021
 * @user iBerlo <@> iberlot@usal.edu.ar
 * @name ControlerPrincipal.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.io.FileReader;
import java.util.Properties;

import interfaces.IController;
import negocio.dao.factory.FactoriDAO;
import negocio.dominio.Principal;
import view.frame.FramePrincipal;

/**
 * Clase de
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class ControlerPrincipal implements IController {

	/**
	 * @var Principal modelo
	 */
	private Principal modelo = new Principal();

	/**
	 * @var FramePrincipal vista
	 */
	private FramePrincipal vista;

	/**
	 * @var FactoriDAO daos
	 */
	private FactoriDAO daos = new FactoriDAO();

	@Override
	public Object initPanel() throws Exception {
		vista = new FramePrincipal(Integer.parseInt(modelo.getPropiedades().getProperty("version")),
				modelo.getPropiedades().getProperty("titulo"));

		// FIXME estoy bastante convencido de que esto no va asi pero no se como
		// solucionarlo ahora

		vista.getEvento().setDatos(this);

		long dni = vista.logueo();

		if (modelo.buscarDni(dni)) {
			modelo.asignarUsuarioDni(dni);

			vista.setVisible(true);
			return null;
		} else {
			throw new Exception("Documento no encontrado.");
		}
	}

	/**
	 * @throws Exception
	 */
	public void guardarModifiaciones() throws Exception {
		daos.getDao("Productos").saveLista(modelo.getProductos());
		daos.getDao("Usuarios").saveLista(modelo.getUsuarios());
		daos.getDao("Sucursales").saveLista(modelo.getSucursales());
		daos.getDao("Transacciones").saveLista(modelo.getTransacciones());
	}

	/**
	 * @throws Exception
	 *
	 */
	public ControlerPrincipal() throws Exception {

		Properties propiedades = new Properties();
		propiedades.load(new FileReader("config.propierties"));
		modelo.setPropiedades(propiedades);

//		modelo.setProductos(daos.getDao("Productos").getLista());
//		modelo.setUsuarios(daos.getDao("Usuarios").getLista());
//		modelo.setSucursales(daos.getDao("Sucursales").getLista());
//		modelo.setTransacciones(daos.getDao("Transacciones").getLista());
		modelo.cargadatos();

	}

	public void setPropiedades(Properties propiedades) {
		modelo.setPropiedades(propiedades);
	}

	/**
	 * @return el campo modelo
	 */
	public Principal getModelo() {
		return modelo;
	}

	/**
	 * @param modelo El parametro modelo para setear
	 */
	public void setModelo(Principal modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return el campo vista
	 */
	public FramePrincipal getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(FramePrincipal vista) {
		this.vista = vista;
	}
}
