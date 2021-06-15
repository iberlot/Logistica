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
 * @name PanelTiendas.java
 * @package javax.swing
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
import view.events.EventosPanelDepositar;

/**
 * @author IVANB
 *
 */
public class PanelDepositar extends JPanel implements iPanels {

	private JComboBox comboDesdeTienda = new JComboBox();
	private JComboBox comboHastaDeposito = new JComboBox();
	private JComboBox comboProductos = new JComboBox();

	private JButton btnCancelar = new JButton("Cancelar");
	private JButton btnAceptar = new JButton("Aceptar");

	private EventosPanelDepositar evento;

	/**
	 * @param sucursales
	 * @param productos
	 */
	public PanelDepositar(ArrayList<Sucursales> sucursales, ArrayList<Productos> productos) {
		this.evento = new EventosPanelDepositar(this);
		this.init(sucursales, productos);
	}

	/**
	 * 
	 */
	public PanelDepositar() {
		// TODO Auto-generated constructor stub
	}

	private void init(ArrayList<Sucursales> sucursales, ArrayList<Productos> productos) {

		setLayout(new BorderLayout(0, 0));

		/* ** Titulo ** */
		JPanel pTitulo = new JPanel();
		add(pTitulo, BorderLayout.NORTH);
		JLabel lblNewLabel = new JLabel("Depositar");
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

			for (Sucursales sucursal : sucursales) {
				if (sucursal instanceof Depositos) {
					comboHastaDeposito.addItem(sucursal);
				} else {
					comboDesdeTienda.addItem(sucursal);
				}
			}

			comboDesdeTienda.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					rellenaProducto(((Tiendas) comboDesdeTienda.getSelectedItem()).getProductos());
				}
			});

			for (Productos producto : productos) {
				comboProductos.addItem(producto);
			}

			pFormulario.add(new JLabel("Desde"));
			pFormulario.add(comboDesdeTienda);
			pFormulario.add(new JLabel("Hasta"));
			pFormulario.add(comboHastaDeposito);
			pFormulario.add(new JLabel("Productos"));
			pFormulario.add(comboProductos);
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
	 * @return el campo comboDesdeTienda
	 */
	public JComboBox getComboDesdeTienda() {
		return comboDesdeTienda;
	}

	/**
	 * @return el campo comboHastaDeposito
	 */
	public JComboBox getComboHastaDeposito() {
		return comboHastaDeposito;
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
	public EventosPanelDepositar getEvento() {
		return evento;
	}

	/**
	 * @param producto
	 * @param desde
	 * @param hasta
	 */
	public void confirmarDeposito(Productos producto, Sucursales desde, Sucursales hasta) {
		JOptionPane.showMessageDialog(null, "Se movio el producto " + producto + " de " + desde + " a " + hasta);

	}

	/**
	 * @param producto
	 * @param desde
	 * @param hasta
	 */
	public void falloDeposito(Productos producto, Sucursales desde, Sucursales hasta) {
		JOptionPane.showMessageDialog(null,
				"No se pudo mover el producto " + producto + " de " + desde + " a " + hasta);

	}

}
