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
 * @name PanelReportesDestino.java
 * @package javax.swing
 * @project Logistica
 */
package view.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import interfaces.iPanels;
import negocio.dominio.Sucursales;
import negocio.dominio.Transacciones;
import view.events.EventosPanelReportesDestino;

/**
 * @author IVANB
 *
 */
public class PanelReportesDestino extends JPanel implements iPanels {

	private JComboBox comboDestino = new JComboBox();

	private String[] columnas = { "Usuario", "Desde", "Hasta" };
	private JTable tabla;
	private DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);

	private JButton btnCancelar = new JButton("Cancelar");
	private JButton btnExportar = new JButton("Exportar");

	private EventosPanelReportesDestino evento;

	/**
	 * @param sucursales
	 */
	public PanelReportesDestino(ArrayList<Transacciones> transacciones, ArrayList<Sucursales> sucursales) {
		this.evento = new EventosPanelReportesDestino(this);
		this.init(transacciones, sucursales);
	}

	/**
	 * 
	 */
	public PanelReportesDestino() {
		// TODO Auto-generated constructor stub
	}

	private void init(ArrayList<Transacciones> transacciones, ArrayList<Sucursales> sucursales) {

		setLayout(new BorderLayout(0, 0));

		/* ** Titulo ** */
		JPanel pTitulo = new JPanel();
		add(pTitulo, BorderLayout.NORTH);
		JLabel lblNewLabel = new JLabel("Reporte por destino");
		pTitulo.add(lblNewLabel);

		/* ** Botonera ** */
		JPanel botonera = new JPanel();
		add(botonera, BorderLayout.SOUTH);
		botonera.setLayout(new GridLayout(1, 2));
		botonera.add(btnExportar);
		btnExportar.addActionListener(this.evento);
		botonera.add(btnCancelar);
		btnCancelar.addActionListener(this.evento);

		/* ** Cuerpo principal ** */
		JPanel pFormulario = new JPanel();
		add(pFormulario, BorderLayout.CENTER);
		pFormulario.setLayout(new GridLayout(1, 2, 0, 0));

		if (transacciones.isEmpty()) {

			JLabel datos = new JLabel("No hay informacion para mostrar.");
			pFormulario.add(datos);

		} else {

			for (Sucursales sucursal : sucursales) {
				comboDestino.addItem(sucursal);
			}

			comboDestino.addActionListener(this.evento);

			pFormulario.add(comboDestino);

			for (Transacciones transaccion : transacciones) {

				// XXX revisar que sea el hasta y no el desde
				if (sucursales.contains(transaccion.getHasta())) {
					Object[] data = { transaccion.getUsuario().getDni(), transaccion.getDesde().getNombre(),
							transaccion.getHasta().getNombre() };

					tableModel.addRow(data);
				}
			}

			tabla = new JTable(tableModel);

			JScrollPane scrollPane = new JScrollPane(tabla);

			pFormulario.add(scrollPane);
		}

	}

	public void rellenaTabla(List<Object[]> transacciones) {
		// Se borran los valores previos
		int e = tableModel.getRowCount();
		for (int i = 0; i < e; i++) {
			tableModel.removeRow(0);
		}

		for (Object[] transaccion : transacciones) {

			tableModel.addRow(transaccion);
		}
	}

	@Override
	public Object getObjeto() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return el campo comboDestino
	 */
	public JComboBox getComboDestino() {
		return comboDestino;
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
	public EventosPanelReportesDestino getEvento() {
		return evento;
	}

}
