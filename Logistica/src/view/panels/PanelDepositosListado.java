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
 * @name PanelDepositos.java
 * @package view.panels
 * @project Logistica
 */
package view.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import interfaces.iPanels;
import negocio.dominio.Depositos;
import negocio.dominio.Sucursales;
import negocio.dominio.Tiendas;
import view.events.EventosPanelDepositosListado;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class PanelDepositosListado extends JPanel implements iPanels {

	private String[] columnas = { "Nombre", "Tipo", "Localidad", "Provincia" };
	private JTable tabla;
	private DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);

	private JButton btnCancelar = new JButton("Cancelar");

	private EventosPanelDepositosListado evento;

	/**
	 * @param sucursales
	 */
	public PanelDepositosListado(ArrayList<Sucursales> sucursales) {
		this.evento = new EventosPanelDepositosListado(this);
		this.init(sucursales);
	}

	private void init(ArrayList<Sucursales> sucursales) {

		setLayout(new BorderLayout(0, 0));

		/* ** Titulo ** */
		JPanel pTitulo = new JPanel();
		add(pTitulo, BorderLayout.NORTH);
		JLabel lblNewLabel = new JLabel("Listado de depositos");
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
		pFormulario.setLayout(new GridLayout(4, 2, 0, 0));

		if (sucursales.isEmpty()) {

			JLabel datos = new JLabel("No hay informacion para mostrar.");
			pFormulario.add(datos);

		} else {

			for (Sucursales sucursal : sucursales) {
				String tipo;

				if (sucursal instanceof Tiendas) {
					tipo = "Tienda";
				} else {
					tipo = "Deposito";
				}

				Object[] data = { sucursal.getNombre(), tipo, sucursal.getLocalidades(), sucursal.getProvincia() };

				tableModel.addRow(data);
			}

			tabla = new JTable(tableModel);

			JScrollPane scrollPane = new JScrollPane(tabla);

			pFormulario.add(scrollPane);
		}

	}

	/**
	 * 
	 */
	public PanelDepositosListado() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 */
	@Override
	public Object getObjeto() {
		Depositos deposito = new Depositos();

		return deposito;
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
	public EventosPanelDepositosListado getEvento() {
		return evento;
	}

}
