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
 * @name FramePrincipal.java
 * @package view.frame
 * @project Logistica
 */
package view.frame;

import java.awt.CardLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.events.EventosFramePrincipal;

/**
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class FramePrincipal extends JFrame {

	private JPanel panelContenedor = new JPanel();;
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menuFile = new JMenu("File");
	private JMenu menuAcciones = new JMenu("Acciones");
	private JMenu menuReportes = new JMenu("Reportes");
	private JMenu menuAyuda = new JMenu("Ayuda");
	private JMenuItem itemMenuFilePropiedades = new JMenuItem("Propiedades");
	private JMenuItem itemMenuFileCerrar = new JMenuItem("Cerrar");
	private JMenuItem itemMenuAccionesTransferir = new JMenuItem("Transferir");
	private JMenuItem itemMenuAccionesExtraer = new JMenuItem("Extraer");
	private JMenuItem itemMenuAccionesDepositar = new JMenuItem("Depositar");
	private JMenuItem itemMenuReportesHistorial = new JMenuItem("Historico");
	private JMenuItem itemMenuReportesTipo = new JMenuItem("Por Tipo");
	private JMenuItem itemMenuReportesDeposito = new JMenuItem("Por Deposito");
	private JMenuItem itemMenuReportesTienda = new JMenuItem("Por Tienda");
	private JMenuItem itemMenuAyudaVersion = new JMenuItem("Version");

	private EventosFramePrincipal evento;

	/**
	 * @throws HeadlessException
	 */
	public FramePrincipal(int version, String titulo) throws HeadlessException {
		this.evento = new EventosFramePrincipal(this);
		this.init();
	}

	private void init() {

		this.barraMenu.add(menuFile);
		this.barraMenu.add(menuAcciones);
		this.barraMenu.add(menuReportes);
		this.barraMenu.add(menuAyuda);

		menuFile.add(itemMenuFilePropiedades);
		menuFile.add(itemMenuFileCerrar);
		menuAcciones.add(itemMenuAccionesTransferir);
		menuAcciones.add(itemMenuAccionesExtraer);
		menuAcciones.add(itemMenuAccionesDepositar);
		menuReportes.add(itemMenuReportesHistorial);
		menuReportes.addSeparator();
		menuReportes.add(itemMenuReportesTipo);
		menuReportes.add(itemMenuReportesDeposito);
		menuReportes.add(itemMenuReportesTienda);
		menuAyuda.add(itemMenuAyudaVersion);

		setJMenuBar(barraMenu);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelContenedor);
		panelContenedor.setLayout(new CardLayout(0, 0));

		this.itemMenuFilePropiedades.addActionListener(this.evento);
		itemMenuFileCerrar.addActionListener(this.evento);
		itemMenuAccionesTransferir.addActionListener(this.evento);
		itemMenuAccionesExtraer.addActionListener(this.evento);
		itemMenuAccionesDepositar.addActionListener(this.evento);
		itemMenuReportesHistorial.addActionListener(this.evento);
		itemMenuReportesTipo.addActionListener(this.evento);
		itemMenuReportesDeposito.addActionListener(this.evento);
		itemMenuReportesTienda.addActionListener(this.evento);
		itemMenuAyudaVersion.addActionListener(this.evento);

	}

	/**
	 * @param gc
	 */
	public FramePrincipal(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public FramePrincipal(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param gc
	 */
	public FramePrincipal(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 */
	public Long logueo() {
//		try {
		return Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese su Dni:"));
//		} catch (NumberFormatException e) {
//			if (!e.equals("") && !e.equals(null)) {
//				JOptionPane.showMessageDialog(null, e + "Folmato incorrecto.");
//				return logueo();
//			}
//			return null;
//		}
	}

	/**
	 * @return el campo panelContenedor
	 */
	public JPanel getPanelContenedor() {
		return panelContenedor;
	}

	/**
	 * @return el campo barraMenu
	 */
	public JMenuBar getBarraMenu() {
		return barraMenu;
	}

	/**
	 * @return el campo menuFile
	 */
	public JMenu getMenuFile() {
		return menuFile;
	}

	/**
	 * @return el campo menuAcciones
	 */
	public JMenu getMenuAcciones() {
		return menuAcciones;
	}

	/**
	 * @return el campo menuReportes
	 */
	public JMenu getMenuReportes() {
		return menuReportes;
	}

	/**
	 * @return el campo menuAyuda
	 */
	public JMenu getMenuAyuda() {
		return menuAyuda;
	}

	/**
	 * @return el campo itemMenuFilePropiedades
	 */
	public JMenuItem getItemMenuFilePropiedades() {
		return itemMenuFilePropiedades;
	}

	/**
	 * @return el campo itemMenuFileCerrar
	 */
	public JMenuItem getItemMenuFileCerrar() {
		return itemMenuFileCerrar;
	}

	/**
	 * @return el campo itemMenuAccionesTransferir
	 */
	public JMenuItem getItemMenuAccionesTransferir() {
		return itemMenuAccionesTransferir;
	}

	/**
	 * @return el campo itemMenuAccionesExtraer
	 */
	public JMenuItem getItemMenuAccionesExtraer() {
		return itemMenuAccionesExtraer;
	}

	/**
	 * @return el campo itemMenuAccionesDepositar
	 */
	public JMenuItem getItemMenuAccionesDepositar() {
		return itemMenuAccionesDepositar;
	}

	/**
	 * @return el campo itemMenuReportesHistorial
	 */
	public JMenuItem getItemMenuReportesHistorial() {
		return itemMenuReportesHistorial;
	}

	/**
	 * @return el campo itemMenuReportesTipo
	 */
	public JMenuItem getItemMenuReportesTipo() {
		return itemMenuReportesTipo;
	}

	/**
	 * @return el campo itemMenuReportesDeposito
	 */
	public JMenuItem getItemMenuReportesDeposito() {
		return itemMenuReportesDeposito;
	}

	/**
	 * @return el campo itemMenuReportesTienda
	 */
	public JMenuItem getItemMenuReportesTienda() {
		return itemMenuReportesTienda;
	}

	/**
	 * @return el campo itemMenuAyudaVersion
	 */
	public JMenuItem getItemMenuAyudaVersion() {
		return itemMenuAyudaVersion;
	}

	/**
	 * @return el campo evento
	 */
	public EventosFramePrincipal getEvento() {
		return evento;
	}

}
