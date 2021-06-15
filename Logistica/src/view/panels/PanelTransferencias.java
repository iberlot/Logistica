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
 * @name PanelProductos.java
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
import view.events.EventosPanelTransferencias;

/**
 * @author IVANB
 *
 */
public class PanelTransferencias extends JPanel implements iPanels {

	private JComboBox comboDesde = new JComboBox();
	private JComboBox comboHasta = new JComboBox();
	private JComboBox comboProductos = new JComboBox();

	private JButton btnCancelar = new JButton("Cancelar");
	private JButton btnAceptar = new JButton("Aceptar");

	private EventosPanelTransferencias evento;

	public PanelTransferencias(ArrayList<Sucursales> depositos, ArrayList<Productos> productos) {
		this.evento = new EventosPanelTransferencias(this);
		this.init(depositos, productos);
	}

	/**
	 * 
	 */
	public PanelTransferencias() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getObjeto() {
		// TODO Auto-generated method stub
		return null;
	}

	// FIXME este combo deberia ser dinamico, solo deberia mostrarte los productos
	// que tenga el desposite seleccionado en desde
	private void init(ArrayList<Sucursales> depositos, ArrayList<Productos> productos) {

		setLayout(new BorderLayout(0, 0));

		/* ** Titulo ** */
		JPanel pTitulo = new JPanel();
		add(pTitulo, BorderLayout.NORTH);
		JLabel lblNewLabel = new JLabel("Transferir");
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

		for (Sucursales deposito : depositos) {
			if (deposito instanceof Depositos) {
				comboDesde.addItem(deposito);
				comboHasta.addItem(deposito);
			}
		}

		comboDesde.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rellenaComboHasta(((Depositos) comboDesde.getSelectedItem()), depositos);
				rellenaProducto(((Depositos) comboDesde.getSelectedItem()).getProductos());
			}
		});

		for (Productos producto : productos) {
			comboProductos.addItem(producto);
		}

		pFormulario.add(new JLabel("Desde"));
		pFormulario.add(comboDesde);
		pFormulario.add(new JLabel("Hasta"));
		pFormulario.add(comboHasta);
		pFormulario.add(new JLabel("Productos"));
		pFormulario.add(comboProductos);

	}

	private void rellenaComboHasta(Depositos selecion, ArrayList<Sucursales> depositos) {
		// Se borran los valores previos
		comboHasta.removeAllItems();

		for (Sucursales deposito : depositos) {
			if (deposito instanceof Depositos) {
				if (!deposito.equals(selecion)) {
					comboHasta.addItem(deposito);
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

	public void confirmarTransferencia(Productos producto, Depositos desde, Depositos hasta) {
		JOptionPane.showMessageDialog(null, "Se movio el producto " + producto + " de " + desde + " a " + hasta);
	}

	public void falloTransferencia(Productos producto, Depositos desde, Depositos hasta) {
		JOptionPane.showMessageDialog(null,
				"No se pudo mover el producto " + producto + " de " + desde + " a " + hasta);
	}

	/**
	 * @return el campo comboDesde
	 */
	public JComboBox getComboDesde() {
		return comboDesde;
	}

	/**
	 * @return el campo comboHasta
	 */
	public JComboBox getComboHasta() {
		return comboHasta;
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
	public EventosPanelTransferencias getEvento() {
		return evento;
	}

}
