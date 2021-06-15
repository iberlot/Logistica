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
 * @name EventosFramePrincipal.java
 * @package view.events
 * @project Logistica
 */
package view.events;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.ControlerDepositar;
import controller.ControlerExtracciones;
import controller.ControlerReportesDestino;
import controller.ControlerReportesFecha;
import controller.ControlerReportesTipo;
import controller.ControlerTransaccionesHistorico;
import controller.ControlerTransferencias;
import negocio.dominio.Principal;
import view.frame.FramePrincipal;

/**
 * @author IVANB
 *
 */
public class EventosFramePrincipal implements ActionListener {

	private FramePrincipal principal;

	// FIXME estoy seguro de que esto no es asi pero no se me ocurre como resolverlo
	private Principal datos;

	public EventosFramePrincipal(FramePrincipal principal) {
		this.principal = principal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(this.principal.getItemMenuFileCerrar())) {

			int opcion = JOptionPane.showConfirmDialog(this.principal, "¿Seguro que desea salir?", "Salir",
					JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				System.exit(0);
			}
		} else if (e.getSource().equals(this.principal.getItemMenuAccionesTransferir())) {

			principal.getPanelContenedor().removeAll();
			principal.getPanelContenedor().repaint();

			ControlerTransferencias controlador = new ControlerTransferencias();
			controlador.setProductos(datos.getProductos());
			controlador.setSucursales(datos.getSucursales());

			principal.getContentPane().add((Component) controlador.initPanel());

		} else if (e.getSource().equals(this.principal.getItemMenuAccionesExtraer())) {

			principal.getPanelContenedor().removeAll();
			principal.getPanelContenedor().repaint();

			ControlerExtracciones controlador = new ControlerExtracciones();
			controlador.setProductos(datos.getProductos());
			controlador.setSucursales(datos.getSucursales());

			principal.getContentPane().add((Component) controlador.initPanel());

		} else if (e.getSource().equals(this.principal.getItemMenuAccionesDepositar())) {

			principal.getPanelContenedor().removeAll();
			principal.getPanelContenedor().repaint();

			ControlerDepositar controlador = new ControlerDepositar();
			controlador.setProductos(datos.getProductos());
			controlador.setSucursales(datos.getSucursales());

			principal.getContentPane().add((Component) controlador.initPanel());

		} else if (e.getSource().equals(this.principal.getItemMenuReportesHistorial())) {

			principal.getPanelContenedor().removeAll();
			principal.getPanelContenedor().repaint();

			ControlerTransaccionesHistorico controlador = new ControlerTransaccionesHistorico();

			controlador.setTransacciones(datos.getTransacciones());

			principal.getContentPane().add((Component) controlador.initPanel());

		} else if (e.getSource().equals(this.principal.getItemMenuReportesTipo())) {

			principal.getPanelContenedor().removeAll();
			principal.getPanelContenedor().repaint();

			ControlerReportesTipo controlador = new ControlerReportesTipo();

			controlador.setTransacciones(datos.getTransacciones());

			principal.getContentPane().add((Component) controlador.initPanel());

		} else if (e.getSource().equals(this.principal.getItemMenuReportesDeposito())) {

			principal.getPanelContenedor().removeAll();
			principal.getPanelContenedor().repaint();

			ControlerReportesDestino controlador = new ControlerReportesDestino();

			controlador.setTransacciones(datos.getTransacciones());
			controlador.setSucursales(datos.getSucursales());

			principal.getContentPane().add((Component) controlador.initPanel());

		} else if (e.getSource().equals(this.principal.getItemMenuReportesTienda())) {

			principal.getPanelContenedor().removeAll();
			principal.getPanelContenedor().repaint();

			ControlerReportesFecha controlador = new ControlerReportesFecha();

			controlador.setTransacciones(datos.getTransacciones());
			controlador.setSucursales(datos.getSucursales());

			principal.getContentPane().add((Component) controlador.initPanel());

		}
//		else if (e.getSource().equals(this.principal.getItemMenuAyudaVersion())) {
//
//		principal.getPanelContenedor().removeAll();
//		principal.getPanelContenedor().repaint();

//			Controler controlador = new ControlerTransferencias();
//			principal.getContentPane().add((Component) controlador.initPanel());
//
//		} else if (e.getSource().equals(this.principal.getItemMenuFilePropiedades())) {

//		principal.getPanelContenedor().removeAll();
//		principal.getPanelContenedor().repaint();

//		ControlerTransferencias controlador = new ControlerTransferencias();
//		principal.getContentPane().add((Component) controlador.initPanel());

//	}

		principal.validate();
	}

	/**
	 * @param datos El parametro datos para setear
	 */
	public void setDatos(Principal datos) {
		this.datos = datos;
	}

}
