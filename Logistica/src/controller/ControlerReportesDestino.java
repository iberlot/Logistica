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
 * @name ControlerReportesDestino.java
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
import negocio.dominio.Sucursales;
import negocio.dominio.Transacciones;
import view.panels.PanelReportesDestino;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class ControlerReportesDestino implements IController {

	private ArrayList<Transacciones> transacciones;
	private ArrayList<Sucursales> sucursales;
	private PanelReportesDestino vista;
	private FactoriDAO daos = new FactoriDAO();

	/**
	 * 
	 */
	public ControlerReportesDestino() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object initPanel() {
		vista = new PanelReportesDestino(transacciones, sucursales);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	public void rellenaTabla(Object selectedItem) {
		try {

			List<Transacciones> transa = transacciones.stream().filter(t -> (t.getHasta().equals(selectedItem)))
					.sorted().collect(Collectors.toList());

			List<Object[]> objetos = new ArrayList<>();

			for (Transacciones transaccion : transa) {

				Object[] data = { transaccion.getUsuario().getDni(), transaccion.getDesde().getNombre(),
						transaccion.getHasta().getNombre() };

				objetos.add(data);
			}

			vista.rellenaTabla(objetos);

		} catch (Exception e) {
			ValidacionesException.mostrarMensaje(e);
		}

	}

	public void expontar(Object selectedItem) throws Exception {

		try {
			daos.setElemento("docReporteDestino");

			ArrayList<String[]> objetos = new ArrayList<>();
			String[] columnas = { "Usuario", "Desde", "Hasta" };

			objetos.add(columnas);

			List<Transacciones> transa = transacciones.stream().filter(t -> (t.getHasta().equals(selectedItem)))
					.sorted().collect(Collectors.toList());

			for (Transacciones transaccion : transa) {

				String[] data = { Long.toString(transaccion.getUsuario().getDni()), transaccion.getDesde().getNombre(),
						transaccion.getHasta().getNombre() };

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
	public PanelReportesDestino getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelReportesDestino vista) {
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

	/**
	 * @return el campo sucursales
	 */
	public ArrayList<Sucursales> getSucursales() {
		return sucursales;
	}

	/**
	 * @param sucursales El parametro sucursales para setear
	 */
	public void setSucursales(ArrayList<Sucursales> sucursales) {
		this.sucursales = sucursales;
	}

}
