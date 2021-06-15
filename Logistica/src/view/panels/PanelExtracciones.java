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
 * @name PanelSucursales.java
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfaces.iPanels;
import negocio.dominio.Depositos;
import negocio.dominio.Productos;
import negocio.dominio.Sucursales;
import negocio.dominio.Tiendas;
import view.events.EventosPanelExtracciones;

/**
 * @author IVANB
 *
 */
public class PanelExtracciones extends JPanel implements iPanels {

	private JComboBox comboDepositos = new JComboBox();
	private JComboBox comboTiendas = new JComboBox();
	private JComboBox comboProductos = new JComboBox();

	private JButton btnCancelar = new JButton("Cancelar");
	private JButton btnAceptar = new JButton("Aceptar");

	private EventosPanelExtracciones evento;

	/**
	 * @param sucursales
	 * @param productos
	 */
	public PanelExtracciones(ArrayList<Sucursales> sucursales, ArrayList<Productos> productos) {
		this.evento = new EventosPanelExtracciones(this);
		this.init(sucursales, productos);
	}

	/**
	 * 
	 */
	public PanelExtracciones() {
		// TODO Auto-generated constructor stub
	}

	private void init(ArrayList<Sucursales> sucursales, ArrayList<Productos> productos) {

		setLayout(new BorderLayout(0, 0));

		/* ** Titulo ** */
		JPanel pTitulo = new JPanel();
		add(pTitulo, BorderLayout.NORTH);
		JLabel lblNewLabel = new JLabel("Extracciones");
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

		if (sucursales.isEmpty()) {

			JLabel datos = new JLabel("No hay informacion para mostrar.");
			pFormulario.add(datos);

		} else {

			for (Sucursales suc : sucursales) {
				if (suc instanceof Tiendas) {
					comboTiendas.addItem(suc);
				} else {
					comboDepositos.addItem(suc);
				}
			}

			comboTiendas.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					rellenaComboHasta(((Tiendas) comboTiendas.getSelectedItem()), sucursales);
					rellenaProducto(((Tiendas) comboTiendas.getSelectedItem()).getProductos());
				}
			});

			for (Productos producto : productos) {
				comboProductos.addItem(producto);
			}

			pFormulario.add(new JLabel("Tienda"));
			pFormulario.add(comboTiendas);
			pFormulario.add(new JLabel("Deposito"));
			pFormulario.add(comboDepositos);
			pFormulario.add(new JLabel("Productos"));
			pFormulario.add(comboProductos);
		}

	}

	private void rellenaComboHasta(Tiendas selecion, ArrayList<Sucursales> depositos) {
		// Se borran los valores previos
		comboDepositos.removeAllItems();

		for (Sucursales deposito : depositos) {
			if (deposito instanceof Depositos) {
				if (!deposito.equals(selecion)) {
					comboDepositos.addItem(deposito);
				}
			}
		}
	}

	private void rellenaProducto(ArrayList<Productos> productos) {
		// Se borran los valores previos
		comboProductos.removeAllItems();

		for (Productos producto : productos) {
			comboProductos.addItem(producto);
		}
	}

	@Override
	public Object getObjeto() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return el campo comboDepositos
	 */
	public JComboBox getComboDepositos() {
		return comboDepositos;
	}

	/**
	 * @return el campo comboTiendas
	 */
	public JComboBox getComboTiendas() {
		return comboTiendas;
	}

	/**
	 * @return el campo comboProductos
	 */
	public JComboBox getComboProductos() {
		return comboProductos;
	}

	/**
	 * @return el campo btnCancelar
	 */
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	/**
	 * @return el campo btnAceptar
	 */
	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	/**
	 * @return el campo evento
	 */
	public EventosPanelExtracciones getEvento() {
		return evento;
	}

	/**
	 * @param producto
	 * @param desde
	 * @param hasta
	 */
	public void falloExtraxion(Productos producto, Sucursales desde, Sucursales hasta) {
		JOptionPane.showMessageDialog(null,
				"No se pudo mover el producto " + producto + " de " + desde + " a " + hasta);

	}

	/**
	 * @param producto
	 * @param desde
	 * @param hasta
	 */
	public void confirmarExtraxion(Productos producto, Sucursales desde, Sucursales hasta) {
		JOptionPane.showMessageDialog(null, "Se movio el producto " + producto + " de " + desde + " a " + hasta);

	}

}
