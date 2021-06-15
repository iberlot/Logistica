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
 * @name PanelReportesFecha.java
 * @package view.panels
 * @project Logistica
 */
package view.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import interfaces.iPanels;
import negocio.dominio.Sucursales;
import negocio.dominio.Transacciones;
import view.events.EventosPanelReportesFecha;

/**
 * @author IVANB
 *
 */
public class PanelReportesFecha extends JPanel implements iPanels {

	private JLabel lblNroTienda = new JLabel("Nro de Tienda:");
	private JFormattedTextField nroTienda;
	private JLabel lblFechaDesde = new JLabel("Fecha Desde:");
	private JFormattedTextField fechaDesde;
	private JLabel lblFechaHasta = new JLabel("Fecha Hasta:");
	private JFormattedTextField fechaHasta;

	private String[] columnas = { "Numero", "Hasta", "Producto", "Usuario", "Fecha" };
	private JTable tabla;
	private DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);

	private JButton btnCancelar = new JButton("Cancelar");
	private JButton btnAceptar = new JButton("Aceptar");

	private EventosPanelReportesFecha evento;

	/**
	 * @param sucursales
	 * @param transacciones
	 * @throws ParseException
	 */
	public PanelReportesFecha(ArrayList<Sucursales> sucursales, ArrayList<Transacciones> transacciones)
			throws ParseException {
		this.evento = new EventosPanelReportesFecha(this);
		this.init(transacciones);
	}

	/**
	 * 
	 */
	public PanelReportesFecha() {
		// TODO Auto-generated constructor stub
	}

	private void init(ArrayList<Transacciones> transacciones) throws ParseException {

		setLayout(new BorderLayout(0, 0));

		/* ** Titulo ** */
		JPanel pTitulo = new JPanel();
		add(pTitulo, BorderLayout.NORTH);
		JLabel lblNewLabel = new JLabel("Reporte por fecha");
		pTitulo.add(lblNewLabel);

		/* ** Botonera ** */
		JPanel botonera = new JPanel();
		add(botonera, BorderLayout.SOUTH);
		botonera.setLayout(new GridLayout(1, 2));
		botonera.add(btnAceptar);
		botonera.add(btnCancelar);
		btnCancelar.addActionListener(this.evento);
		btnAceptar.addActionListener(this.evento);

		/* ** Cuerpo principal ** */
		JPanel pFormulario = new JPanel();
		add(pFormulario, BorderLayout.CENTER);
		pFormulario.setLayout(new GridLayout(4, 2, 0, 0));

		if (transacciones.isEmpty()) {

			JLabel datos = new JLabel("No hay informacion para mostrar.");
			pFormulario.add(datos);

		} else {
			nroTienda = new JFormattedTextField(new MaskFormatter("#####"));
			nroTienda.setColumns(5);

			fechaDesde = new JFormattedTextField(new MaskFormatter("##-##-####"));
			fechaHasta = new JFormattedTextField(new MaskFormatter("##-##-####"));

			pFormulario.add(lblNroTienda);
			pFormulario.add(nroTienda);
			pFormulario.add(lblFechaDesde);
			pFormulario.add(fechaDesde);
			pFormulario.add(lblFechaHasta);
			pFormulario.add(fechaHasta);

			int i = 0;

			// FIXME mover logica de la ventana deberia pasar el array con los datos que
			// corresponden
			for (Transacciones transaccion : transacciones) {
				if (i == 9) {
					break;
				}
				// XXX revisar que sea el hasta y no el desde
//				if (Integer.parseInt(nroTienda.getText()) == transaccion.getDesde().getId()) {

				Object[] data = { i + 1, transaccion.getHasta().getNombre(), transaccion.getProducto().getNombre(),
						transaccion.getUsuario().getDni(), transaccion.getFechaString() };

				i++;

				tableModel.addRow(data);
//				}
			}

			tabla = new JTable(tableModel);

			JScrollPane scrollPane = new JScrollPane(tabla);

			pFormulario.add(scrollPane);
		}

	}

	@Override
	public Object getObjeto() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return el campo lblNroTienda
	 */
	public JLabel getLblNroTienda() {
		return lblNroTienda;
	}

	/**
	 * @return el campo nroTienda
	 */
	public JTextField getNroTienda() {
		return nroTienda;
	}

	/**
	 * @return el campo lblFechaDesde
	 */
	public JLabel getLblFechaDesde() {
		return lblFechaDesde;
	}

	/**
	 * @return el campo fechaDesde
	 */
	public JTextField getFechaDesde() {
		return fechaDesde;
	}

	/**
	 * @return el campo lblFechaHasta
	 */
	public JLabel getLblFechaHasta() {
		return lblFechaHasta;
	}

	/**
	 * @return el campo fechaHasta
	 */
	public JTextField getFechaHasta() {
		return fechaHasta;
	}

	/**
	 * @return el campo columnas
	 */
	public String[] getColumnas() {
		return columnas;
	}

	/**
	 * @return el campo tabla
	 */
	public JTable getTabla() {
		return tabla;
	}

	/**
	 * @return el campo tableModel
	 */
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	/**
	 * @return el campo btnCancelar
	 */
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	/**
	 * @return el campo evento
	 */
	public EventosPanelReportesFecha getEvento() {
		return evento;
	}

}
