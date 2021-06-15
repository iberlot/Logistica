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
 * @name ControlerReportesFecha.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exepciones.ValidacionesException;
import interfaces.IController;
import negocio.dominio.Sucursales;
import negocio.dominio.Transacciones;
import view.panels.PanelReportesFecha;

/**
 * @author IVANB
 *
 */
public class ControlerReportesFecha implements IController {

	private PanelReportesFecha vista;

	private ArrayList<Transacciones> transacciones;
	private ArrayList<Sucursales> sucursales;

	/**
	 * 
	 */
	public ControlerReportesFecha() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object initPanel() {
		try {
			vista = new PanelReportesFecha(sucursales, transacciones);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("todos putos");
		}
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	/**
	 * @return el campo vista
	 */
	public PanelReportesFecha getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelReportesFecha vista) {
		this.vista = vista;
	}

	public void rellenaTabla() {
		// Se borran los valores previos
		List<Object[]> objetos = new ArrayList<>();

		int i = 0;

		for (Transacciones transaccion : transacciones) {
			if (i == 9) {
				break;
			}

			Object[] data = { i++, transaccion.getDesde().getId(), transaccion.getDesde().getNombre(),
					transaccion.getProducto().getNombre(), transaccion.getUsuario().getDni(),
					transaccion.getFechaString() };

			objetos.add(data);
		}

		vista.rellenaTabla(objetos);
	}

	public void rellenaTabla(int tienda, String fDesde, String fHasta) {
		try {
			if ((fDesde != null && fHasta != null) && Long.parseLong(fHasta) < Long.parseLong(fDesde)) {
				throw new Exception("La fecha desde es mayor que hasta");
			}

			List<Transacciones> transa = transacciones;

			if (tienda > 0) {
				transa = transa.stream().filter(t -> (t.getDesde().getId() == tienda)).sorted()
						.collect(Collectors.toList());
			}

			if (fDesde != null) {
				transa = transa.stream().filter(t -> (Long.parseLong(t.getFechaNumero()) >= Long.parseLong(fDesde)))
						.sorted().collect(Collectors.toList());
			}

			if (fHasta != null) {
				transa = transa.stream().filter(t -> (Long.parseLong(t.getFechaNumero()) <= Long.parseLong(fHasta)))
						.sorted().collect(Collectors.toList());
			}
			List<Object[]> objetos = armaLista(transa);

			vista.rellenaTabla(objetos);

		} catch (Exception e) {
			ValidacionesException.mostrarMensaje(e);
		}

	}

	private List<Object[]> armaLista(List<Transacciones> array) {
		List<Object[]> objetos = new ArrayList<>();

		int i = 0;
		for (Transacciones transaccion : array) {
			if (i == 9) {
				break;
			}
			Object[] data = { i++, transaccion.getDesde().getId(), transaccion.getDesde().getNombre(),
					transaccion.getProducto().getNombre(), transaccion.getUsuario().getDni(),
					transaccion.getFechaString() };

			objetos.add(data);
		}
		return objetos;

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
