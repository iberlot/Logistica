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
 * @name ControlerReportesTipo.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exepciones.ValidacionesException;
import interfaces.IController;
import negocio.dao.factory.FactoriDAO;
import negocio.dominio.Transacciones;
import view.panels.PanelReportesTipo;

/**
 * @author IVANB
 *
 */
public class ControlerReportesTipo implements IController {

	private ArrayList<Transacciones> transacciones;
	private PanelReportesTipo vista;
	private FactoriDAO daos = new FactoriDAO();

	/**
	 * 
	 */
	public ControlerReportesTipo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object initPanel() {
		vista = new PanelReportesTipo(transacciones);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	public void rellenaTabla(Object selectedItem) {
		try {

			List<Transacciones> transa = transacciones.stream().filter(t -> (t.getTipo().equals(selectedItem))).sorted()
					.collect(Collectors.toList());

			List<Object[]> objetos = new ArrayList<>();

			for (Transacciones transaccion : transa) {

				Object[] data = { transaccion.getDesde().getNombre(), transaccion.getHasta().getNombre(),
						transaccion.getUsuario().getDni(), transaccion.getFechaString() };

				objetos.add(data);
			}

			vista.rellenaTabla(objetos);

		} catch (Exception e) {
			ValidacionesException.mostrarMensaje(e);
		}
	}

	public void expontar(Object selectedItem) throws Exception {

		try {
			daos.setElemento("docReporteTipo");

			ArrayList<String[]> objetos = new ArrayList<>();
			String[] columnas = { "Desde", "Hasta", "Usuario", "Fecha" };

			objetos.add(columnas);

			List<Transacciones> transa = transacciones.stream().filter(t -> (t.getTipo().equals(selectedItem))).sorted()
					.collect(Collectors.toList());

			for (Transacciones transaccion : transa) {

				String[] data = { transaccion.getDesde().getNombre(), transaccion.getHasta().getNombre(),
						Long.toString(transaccion.getUsuario().getDni()), transaccion.getFechaString() };

				objetos.add(data);
			}

			daos.getDao("transacciones_txt").saveOnFile(objetos);

		} catch (Exception e) {
			ValidacionesException.mostrarMensaje(e);
		}
	}

	/**
	 * @return el campo vista
	 */
	public PanelReportesTipo getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelReportesTipo vista) {
		this.vista = vista;
	}

	/**
	 * @return el campo transacciones
	 */
	public ArrayList<Transacciones> getTransacciones() {
		return transacciones;
	}

	/**
	 * @param transacciones El parametro transacciones para setear
	 */
	public void setTransacciones(ArrayList<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}

}
