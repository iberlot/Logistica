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
 * @name ControlerTiendas.java
 * @package controller
 * @project Logistica
 */
package controller;

import java.util.ArrayList;

import interfaces.IController;
import negocio.dominio.Depositos;
import negocio.dominio.Productos;
import negocio.dominio.Sucursales;
import negocio.dominio.Transacciones;
import negocio.dominio.Usuarios;
import view.panels.PanelTransferencias;

/**
 * Clase de
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 * @since 16 jun. 2021
 * @version 0.0 Creacion del archivo.
 *
 *
 */
public class ControlerTransferencias implements IController {
	/*
	 * @var ArrayList<Transacciones> transacciones
	 */
	private ArrayList<Transacciones> transacciones;
	/**
	 * @var ArrayList<Productos> productos
	 */
	private ArrayList<Productos> productos;
	/**
	 * @var ArrayList<Sucursales> sucursales
	 */
	private ArrayList<Sucursales> sucursales;
	/**
	 * @var PanelTransferencias vista
	 */
	private PanelTransferencias vista;

	/**
	 * @var Usuarios usuario
	 */
	private Usuarios usuario;

	/**
	 * Constructor de la clase
	 *
	 */
	public ControlerTransferencias() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object initPanel() {
		vista = new PanelTransferencias(sucursales, productos);
		this.vista.getEvento().setControl(this);
		this.vista.setVisible(true);

		return this.vista;
	}

	/**
	 * @param desde
	 * @param hasta
	 * @param producto
	 */
	public void transferir(Depositos desde, Depositos hasta, Productos producto) {
		if (desde.transferir(hasta, producto)) {
			transacciones.add(new Transacciones(desde, hasta, producto, usuario, "transferir"));
			vista.confirmarTransferencia(producto, desde, hasta);

		} else {
			vista.falloTransferencia(producto, desde, hasta);
		}
		limpiar();
	}

	/**
	 * @return el campo vista
	 */
	public PanelTransferencias getVista() {
		return vista;
	}

	/**
	 * @param vista El parametro vista para setear
	 */
	public void setVista(PanelTransferencias vista) {
		this.vista = vista;
	}

	public void limpiar() {

		vista.removeAll();
		vista.setVisible(false);
	}

	/**
	 * @return el campo productos
	 */
	public ArrayList<Productos> getProductos() {
		return productos;
	}

	/**
	 * @param productos El parametro productos para setear
	 */
	public void setProductos(ArrayList<Productos> productos) {
		this.productos = productos;
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

	/**
	 * @return el dato de transacciones
	 */
	public ArrayList<Transacciones> getTransacciones() {
		return transacciones;
	}

	/**
	 * @param transacciones para cargar en transacciones
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

}
