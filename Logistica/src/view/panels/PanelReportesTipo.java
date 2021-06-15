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
 * @name PanelReportesTipo.java
 * @package view.panels
 * @project Logistica
 */
package view.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import interfaces.iPanels;
import negocio.dominio.Transacciones;
import view.events.EventosPanelReportesTipo;

/**
 * @author IVANB
 *
 */
public class PanelReportesTipo extends JPanel implements iPanels {

	private JComboBox comboTipos = new JComboBox();

	private String[] columnas = { "Desde", "Hasta", "Usuario", "Fecha" };
	private JTable tabla;
	private DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);

	private JButton btnCancelar = new JButton("Cancelar");

	private EventosPanelReportesTipo evento;

	/**
	 * @param transacciones
	 */
	public PanelReportesTipo(ArrayList<Transacciones> transacciones) {
		this.evento = new EventosPanelReportesTipo(this);
		this.init(transacciones);
	}

	/**
	 * 
	 */
	public PanelReportesTipo() {
		// TODO Auto-generated constructor stub
	}

	private void init(ArrayList<Transacciones> transacciones) {

		setLayout(new BorderLayout(0, 0));

		/* ** Titulo ** */
		JPanel pTitulo = new JPanel();
		add(pTitulo, BorderLayout.NORTH);
		JLabel lblNewLabel = new JLabel("Reporte por Tipo");
		pTitulo.add(lblNewLabel);

		/* ** Botonera ** */
		JPanel botonera = new JPanel();
		add(botonera, BorderLayout.SOUTH);
		botonera.setLayout(new GridLayout(1, 2));
		botonera.add(btnCancelar);
		btnCancelar.addActionListener(this.evento);

		/* ** Cuerpo principal ** */
		JPanel pFormulario = new JPanel();
		add(pFormulario, BorderLayout.CENTER);
		pFormulario.setLayout(new GridLayout(2, 2, 0, 0));

		if (transacciones.isEmpty()) {

			JLabel datos = new JLabel("No hay informacion para mostrar.");
			pFormulario.add(datos);

		} else {

			for (String tipo : Transacciones.getTipos()) {
				comboTipos.addItem(tipo);
			}

			comboTipos.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					rellenaTabla(comboTipos.getSelectedItem(), transacciones);
				}

			});

			pFormulario.add(comboTipos);

			for (Transacciones transaccion : transacciones) {

				// XXX revisar que sea el hasta y no el desde

				Object[] data = { transaccion.getDesde().getNombre(), transaccion.getHasta().getNombre(),
						transaccion.getUsuario().getDni(), transaccion.getFechaString() };

				tableModel.addRow(data);
			}

			tabla = new JTable(tableModel);

			JScrollPane scrollPane = new JScrollPane(tabla);

			pFormulario.add(scrollPane);
		}

	}

	private void rellenaTabla(Object selectedItem, ArrayList<Transacciones> transacciones) {
		// Se borran los valores previos
		int e = tableModel.getRowCount();

		for (int i = 0; i < e; i++) {
			tableModel.removeRow(0);
		}

		for (Transacciones transaccion : transacciones) {

			// XXX revisar que sea el hasta y no el desde
			if (transaccion.getTipo().equals(selectedItem)) {
				Object[] data = { transaccion.getDesde().getNombre(), transaccion.getHasta().getNombre(),
						transaccion.getUsuario().getDni(), transaccion.getFechaString() };

				tableModel.addRow(data);
			}
		}
	}

	@Override
	public Object getObjeto() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return el campo comboTipos
	 */
	public JComboBox getComboTipos() {
		return comboTipos;
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
	public EventosPanelReportesTipo getEvento() {
		return evento;
	}

}
