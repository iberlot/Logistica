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
 * @name ControlerPrincipal.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.util.Properties;

import interfaces.IController;
import negocio.dominio.Principal;
import view.frame.FramePrincipal;

/**
 * @author IVANB
 *
 */
public class ControlerPrincipal implements IController {

	Principal modelo = new Principal();
	FramePrincipal vista;

	public void initFrame() throws Exception {
		vista = new FramePrincipal(Integer.parseInt(modelo.getPropiedades().getProperty("version")),
				modelo.getPropiedades().getProperty("titulo"));

		// FIXME estoy bastante convencido de que esto no va asi pero no se como
		// solucionarlo ahora

		System.out.println(modelo.getTransacciones().get(0));

		vista.getEvento().setDatos(modelo);

		long dni = vista.logueo();

		if (modelo.buscarDni(dni)) {
			modelo.asignarUsuarioDni(dni);

			vista.setVisible(true);
		} else {
			throw new Exception("Documento no encontrado.");
		}
	}

	/**
	 * 
	 */
	public ControlerPrincipal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object initPanel() {
		// TODO Auto-generated method stub
		return null;
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
