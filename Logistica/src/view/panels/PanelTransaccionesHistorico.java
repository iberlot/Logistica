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
 * @name PanelTransacciones.java
 * @package view.panels
 * @project Logistica
 */
package view.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import interfaces.iPanels;
import negocio.dominio.Transacciones;
import view.events.EventosPanelTransaccionesHistorico;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class PanelTransaccionesHistorico extends JPanel implements iPanels {

	private String[] columnas = { "Usuario", "Desde", "Hasta", "Tipo", "Producto", "Fecha" };
	private JTable tabla;
	private DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
	private JButton btnCancelar = new JButton("Cancelar");
	private JButton btnExportar = new JButton("Exportar");

	private EventosPanelTransaccionesHistorico evento;

	/**
	 * 
	 */
	public PanelTransaccionesHistorico(ArrayList<Transacciones> transacciones) {
		this.evento = new EventosPanelTransaccionesHistorico(this);
		this.init(transacciones);
	}

	private void init(ArrayList<Transacciones> transacciones) {

		setLayout(new BorderLayout(0, 0));

		/* ** Titulo ** */
		JPanel pTitulo = new JPanel();
		add(pTitulo, BorderLayout.NORTH);
		JLabel lblNewLabel = new JLabel("Historico");
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
			for (Transacciones transaccion : transacciones) {

				Object[] data = { transaccion.getUsuario().getDni(), transaccion.getDesde().getNombre(),
						transaccion.getHasta().getNombre(), transaccion.getTipo(),
						transaccion.getProducto().getNombre(), transaccion.getFechaString() };

				tableModel.addRow(data);
			}

			tabla = new JTable(tableModel);

			JScrollPane scrollPane = new JScrollPane(tabla);

			pFormulario.add(scrollPane);
		}

	}

	/**
	 * @param layout
	 */
	public PanelTransaccionesHistorico(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isDoubleBuffered
	 */
	public PanelTransaccionesHistorico(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public PanelTransaccionesHistorico(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public PanelTransaccionesHistorico() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getObjeto() {
		// TODO Auto-generated method stub
		return null;
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
	public EventosPanelTransaccionesHistorico getEvento() {
		return evento;
	}

	/**
	 * @return el campo btnExportar
	 */
	public JButton getBtnExportar() {
		return btnExportar;
	}

}
