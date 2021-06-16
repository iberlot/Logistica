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
 * @name ControlerTransacciones.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.util.ArrayList;

import interfaces.IController;
import negocio.dao.factory.FactoriDAO;
import negocio.dominio.Transacciones;
import negocio.dominio.Usuarios;
import view.panels.PanelTransaccionesHistorico;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class ControlerTransaccionesHistorico implements IController {

	/**
	 * @var ArrayList<Transacciones> transacciones
	 */
	private ArrayList<Transacciones> transacciones;
	/**
	 * @var Usuarios usuario
	 */
	private Usuarios usuario;
	private PanelTransaccionesHistorico vista;
	private FactoriDAO daos = new FactoriDAO();

	/**
	 */
	public ControlerTransaccionesHistorico() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object initPanel() {
		vista = new PanelTransaccionesHistorico(transacciones);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	public void expontar() throws Exception {

		daos.setElemento("docHistorico");

		ArrayList<String[]> cosas = new ArrayList<>();

		String[] columnas = { "Usuario", "Desde", "Hasta", "Tipo", "Producto", "Fecha" };

		cosas.add(columnas);

		for (Transacciones transaccion : transacciones) {

			String[] data = { Long.toString(transaccion.getUsuario().getDni()), transaccion.getDesde().getNombre(),
					transaccion.getHasta().getNombre(), transaccion.getTipo(), transaccion.getProducto().getNombre(),
					transaccion.getFechaString() };
			cosas.add(data);
		}

		daos.getDao("transacciones_txt").saveOnFile(cosas);

	}

	/**
	 * @return el campo vista
	 */
	public PanelTransaccionesHistorico getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelTransaccionesHistorico vista) {
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
	 * @return el dato de usuario
	 */
	public Usuarios getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario para cargar en usuario
	 */
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return el dato de daos
	 */
	public FactoriDAO getDaos() {
		return daos;
	}

	/**
	 * @param daos para cargar en daos
	 */
	public void setDaos(FactoriDAO daos) {
		this.daos = daos;
	}

}
